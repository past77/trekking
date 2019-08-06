package polo.servlets;


import org.apache.log4j.Logger;
import polo.command.GetClientsStatisticTable;
import polo.command.ICommand;
import polo.command.NutritiologistCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class NutritiologistServlet extends HttpServlet {
    private static Logger LOG = Logger.getLogger(LogoutServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ICommand nutritiologist = new NutritiologistCommand();
        String url = null;
        try {
            url = nutritiologist.execute(req);
            LOG.info("Set client  successfully");
        } catch (SQLException e) {
            LOG.error("Failed to set client");
            e.printStackTrace();
        }

        //get clients info table
        nutritiologist = new GetClientsStatisticTable();
        try {
            nutritiologist.execute(req);
            LOG.info("Write clients statistic successfully");
        } catch (SQLException e) {
            LOG.error("Failed to write clients statistic");
            e.printStackTrace();
        }

        req.getRequestDispatcher(url).forward(req, resp);
    }
}
