package polo.facade;

import polo.dto.ClientDTO;
import polo.dto.FoodHistoryDTO;
import polo.entity.Client;
import polo.entity.DailyRation;
import polo.entity.Food;
import polo.entity.FoodHistory;
import polo.service.ClientService;
import polo.service.DailyService;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class DailyFacade {

    public FoodHistoryDTO getData(int id) {
        DailyService dailyService = new DailyService();
        FoodHistory foodHistory = dailyService.getRawData(id);

        FoodHistoryDTO foodHistoryDTO = new FoodHistoryDTO();

        foodHistoryDTO.setHistory_id(foodHistory.getHistory_id());
        foodHistoryDTO.setClient_id(foodHistory.getClient_id());
        foodHistoryDTO.setFood_id(foodHistory.getFood_id());
        foodHistoryDTO.setDate(foodHistory.getDate());
        foodHistoryDTO.setAmount(foodHistory.getAmount());


        return foodHistoryDTO;
    }

    public void writeToFoodHistory(DailyRation ration, int client_id) {
        Map<Integer, Double> foodIds = new LinkedHashMap<>();
        Map<Food, Double> foodMap = ration.getFoodMap();
        for (Food food : foodMap.keySet()) {
            foodIds.put(food.getId(), foodMap.get(food));
        }

        FoodHistory foodHistrory = new FoodHistory(client_id, foodIds, LocalDate.now());

        DailyService dailyService = new DailyService();
        dailyService.writeToFoodHistory(foodHistrory);
    }
}
