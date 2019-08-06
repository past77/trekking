package polo.command;

import polo.dto.ClientDTO;
import polo.facade.FacadeClient;
import polo.utils.AppUtils;

import javax.servlet.http.HttpServletRequest;

public class GetClientData implements ICommand {
    /**
     * Command to generate data about certain client
     */

    /**
     * Get information about current user and outputs it
     *
     * @param req request that serves for the client to
     *            get information about and further client`s
     *            data receiving
     * @return url for output
     */
    @Override
    public String execute(HttpServletRequest req) {
        FacadeClient clientFacade = new FacadeClient();
       int id = AppUtils.getClientFromSession(req).getId();

        ClientDTO client = clientFacade.getData(id);

        req.getServletContext().setAttribute("id", id);
        req.getServletContext().setAttribute("image", client.getImg());
        req.getServletContext().setAttribute("name", client.getName());
        req.getServletContext().setAttribute("age", client.getAge());
        req.getServletContext().setAttribute("gender", client.getGender());
        req.getServletContext().setAttribute("height", client.getHeight());
        req.getServletContext().setAttribute("weight", client.getWeight());
        req.getServletContext().setAttribute("lifeStyle", client.getLifeStyle());

        return "/jsp/client_page.jsp";
    }
}
