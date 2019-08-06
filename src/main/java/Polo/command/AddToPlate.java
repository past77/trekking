package polo.command;

import org.apache.log4j.Logger;
import polo.dto.FoodHistoryDTO;
import polo.entity.Client;
import polo.entity.DailyRation;
import polo.entity.Food;
import polo.facade.DailyFacade;
import polo.service.FoodService;
import polo.utils.AppUtils;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddToPlate implements ICommand {
    static public ArrayList<ArrayList<Food>> aList = null;
    static public List<Integer> dailyPlate = null;
    public static int last_id;
    /**
     * Command to fill the today`s client "plate"
     */

    private static final Logger LOG = Logger.getLogger(AddToPlate.class);
    /**
     * gets the chosen food and puts it to client`s plate for further
     * operations
     *
     * @param req request containing selected food unit
     * @return string to output on the client`s personal page
     */

    @Override
    public String execute(HttpServletRequest req) {
        int i;
        ArrayList<Food> foodListDaily = null;
        int foodId = Integer.parseInt(req.getParameter("food_selection"));
        foodId--;

        List<Food> foodList = (ArrayList<Food>) req.getServletContext().getAttribute("foodList");

        double amount = Double.parseDouble(req.getParameter("food_amount").trim());

        Client client = AppUtils.getClientFromSession(req);

        DailyRation dailyRation;
        if ((dailyRation = client.getDailyRation()) == null) {
            dailyRation = new DailyRation(new HashMap<>());
            client.setDailyRation(dailyRation);
        }

        Food food = foodList.get(foodId);
        dailyRation.addFood(food, amount);//or through the client

        DailyFacade dailyFacade = new DailyFacade();
        dailyFacade.writeToFoodHistory(dailyRation, client.getId());
        dailyRation.getFoodMap().clear();

        dailyPlate = new ArrayList<>();
        FoodService foodService = new FoodService();
        aList = new ArrayList<>();

        for(i = 1; i <= last_id; i++) {
            FoodHistoryDTO date = dailyFacade.getData(i);
            int clientId = date.getClient_id();
            if(date.getDate().equals(LocalDate.now()) && clientId == client.getId()) {
                dailyPlate.add(date.getAmount());
                foodListDaily = foodService.getFoodData(date.getFood_id());
                aList.add(foodListDaily);
            }
        }
        req.setAttribute("plate", aList);
        req.setAttribute("amount", dailyPlate);

        return "/jsp/client_page.jsp";

    }

    public void SetLastId(int id_last){
        last_id = id_last;
    }
}
