package polo.servlets;

import polo.command.AddFood;
import polo.command.ICommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CustomFoodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("jsp/custom_food.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICommand foodCommand = new AddFood();
        String url = null;
        try {
            url = foodCommand.execute(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher(url).forward(req, resp);
    }
}
