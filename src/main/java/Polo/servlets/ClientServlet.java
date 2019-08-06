package polo.servlets;

import org.apache.log4j.Logger;
import polo.command.GetClientData;
import polo.command.GetFoodList;
import polo.command.ICommand;
import polo.command.UpdateClientData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ClientServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(ClientServlet.class);

    private ICommand command;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        command = new GetClientData();
        String url = null;
        try {
            url = command.execute(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        command = new GetFoodList();
        try {
            command.execute(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        command = new UpdateClientData();
        String url = null;
        try {
            url = command.execute(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher(url).forward(req, resp);
    }
}
