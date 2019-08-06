package polo.command;

import polo.dto.ClientDTO;
import polo.entity.*;
import polo.service.ClientService;
import polo.service.FoodService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.time.LocalDate;

public class RegistrationCommand implements ICommand {
    /**
     * Command to add new client to the database
     */

    /**
     * Creates new client instance and add it to the database
     *
     * @param req request containing all necessary data
     * @return url to redirect to main page
     */

    @Override
    public String execute(HttpServletRequest req) {
        ClientBuilder builder = new ClientBuilder();
        builder.reset();
        builder.setName(req.getParameter("client_name").trim());
        builder.setPassword((req.getParameter("client_pas").trim()));
        builder.setBirthDate(LocalDate.parse(req.getParameter("birth_date").trim()));
        builder.setGenderEnum((req.getParameter("client.gender").trim()));
        builder.setHeight(Double.parseDouble(req.getParameter("client_height").trim()));
        builder.setWeight(Double.parseDouble(req.getParameter("client_weight").trim()));
        System.out.println("(req.getParameter(client_life_style).trim()) : " + (req.getParameter("client_life_style").trim()));
        builder.setLifeStyle((req.getParameter("client_life_style").trim()));

        ClientDTO client = builder.getResult();

        ClientService service = new ClientService();
        service.addClient(client);

        return "/jsp/registration.jsp";
    }
}
