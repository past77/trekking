package polo.servlets;

import polo.command.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddToPlateServlet extends HttpServlet {

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

        ICommand plateCommand = new AddToPlate();

        String result = null;
        try {
            result = plateCommand.execute(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher(result).forward(req, resp);
    }
}
