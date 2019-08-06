package polo.command;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public interface ICommand {
    /**
     * Interface that provide restrictions for all commands
     */

    /**
     * Method to execute a certain command
     *
     * @param req request containing all necessary data
     * @return url to redirect
     */
    String execute(HttpServletRequest req) throws SQLException;
}
