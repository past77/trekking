package polo.command;

import polo.entity.Food;
import polo.service.FoodService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetFoodList implements ICommand{
    /**
     * Command to get all existed food and show it to client
     */

    /**
     * Get all existed food names and and outputs
     * it in the "select food" dropdown list
     *
     * @param req where all food information
     *            is stored
     * @return url to redirect
     */

    @Override
    public String execute(HttpServletRequest req) {
        FoodService foodService = new FoodService();
        List<Food> foodList = foodService.getFoodLIst();
        req.getServletContext().setAttribute("foodList", foodList);

        return "jsp/client_page.jsp";
    }
}
