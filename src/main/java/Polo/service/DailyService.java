package polo.service;

import org.apache.log4j.Logger;
import polo.entity.*;
import polo.repository.FoodHistoryRepository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DailyService {
    private static final Logger LOG = Logger.getLogger(DailyService.class);

    public void writeToFoodHistory(FoodHistory foodHistory) {
        FoodHistoryRepository repo = new FoodHistoryRepository();

        Object[] args = new Object[4];

        for (Integer foodId : foodHistory.getFoodIds().keySet()) {
            args[0] = foodHistory.getClient_id();
            args[1] = foodId;
            args[2] = foodHistory.getFoodIds().get(foodId);
            args[3] = Date.valueOf(foodHistory.getDate());

            repo.create(args);
            LOG.info("Write plate to database successfully");
        }
    }

    public FoodHistory getRawData(int id) {
        FoodHistoryRepository foodHistoryRepository = new FoodHistoryRepository();
        FoodHistory foodHistory = new FoodHistory();

        try {
            ResultSet foodHistoryRes = foodHistoryRepository.read(id);
            while (foodHistoryRes.next()) {
                foodHistory.setHistory_id(foodHistoryRes.getInt(1));
                foodHistory.setClient_id(foodHistoryRes.getInt(2));
                foodHistory.setFood_id(foodHistoryRes.getInt(3));
                foodHistory.setAmount(foodHistoryRes.getInt(4));
                foodHistory.setDate(foodHistoryRes.getDate(5).toLocalDate());
            }
            return foodHistory;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
