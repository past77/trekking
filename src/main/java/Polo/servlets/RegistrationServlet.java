package polo.servlets;

import polo.command.ICommand;
import polo.command.RegistrationCommand;

import javax.servlet.Registration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("jsp/registration.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICommand registrationCommand = new RegistrationCommand();
        String url = null;
        try {
            url = registrationCommand.execute(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher(url).forward(req, resp);
    }
}
