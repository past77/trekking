package polo.servlets;

import org.apache.log4j.Logger;
import polo.entity.Client;
import polo.entity.RoleEnum;
import polo.exception.UserIsNotExist;
import polo.service.ClientService;
import polo.utils.AppUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(LoginServlet.class);

    private RequestDispatcher loginDispatcher;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("error_message", "error.login.empty");
        LOG.debug("Login error message is empty");
        loginDispatcher = req.getRequestDispatcher("/jsp/login.jsp");
        loginDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        loginDispatcher = req.getRequestDispatcher("/jsp/login.jsp");
        String userName = req.getParameter("userName").trim();
        String password = req.getParameter("password").trim();

        Client loginedClient = null;
        try {
            loginedClient = new ClientService().getLoginData(userName, password);
        } catch (UserIsNotExist e) {
            LOG.error("Client not found in the database ");

            req.setAttribute("error_message", "error.login.message");
            LOG.debug("Login error message returned");
            loginDispatcher.forward(req, resp);
            return;
        }
        LOG.info("Got client from database: " + loginedClient.getName());

        //store data in the session
        AppUtils.storeClientInSession(req, loginedClient);

        //do redirect
        String redirectTo;

        RoleEnum role = loginedClient.getRoleEnum();
        if (role.name().equals("C")) {
            redirectTo = "/client_page";
            LOG.info("Client redirected to client_page");
        } else {
            redirectTo = "/stat_page";
            LOG.info("Client redirected stat_page");
        }
        resp.sendRedirect(redirectTo);

    }
}
