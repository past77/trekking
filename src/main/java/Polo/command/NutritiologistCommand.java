package polo.command;

import polo.entity.Client;
import polo.service.ClientService;
import polo.utils.AppUtils;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class NutritiologistCommand implements ICommand{
    /**
     * Command designed to get information about the doctor
     */

    /**
     * Get doctors further information by id
     *
     * @param req request containing doctor`s id
     * @return doctor page url
     */
    @Override
    public String execute(HttpServletRequest req) {
        Client client = AppUtils.getClientFromSession(req);
        System.out.println("CLIENT NAME: " + client.getName());
        //client.setName(new ClientService().getName(client.getId()));

        req.setAttribute("client_name", client.getName());

        return "jsp/stat_page.jsp";
    }
}
