package polo.servlets;

import polo.command.ICommand;
import polo.command.NormCommand;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class NormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ICommand normCommand = new NormCommand();
        String result = null;
        try {
            result = normCommand.execute(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.setContentType("text/html");
        resp.getWriter().write(result);
    }
}
