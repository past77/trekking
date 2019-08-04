package polo.entity;

import java.time.LocalDate;
import java.util.Map;

public class FoodHistory {
    private int client_id;

    public int getHistory_id() {
        return history_id;
    }

    public void setHistory_id(int history_id) {
        this.history_id = history_id;
    }

    private int history_id;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    private int amount;

    public FoodHistory(){}

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    private int food_id;
    private Map<Integer, Double> foodIds;
    private LocalDate date;

    public FoodHistory(int client_id, Map<Integer, Double> foodIds, LocalDate date) {
        this.client_id = client_id;
        this.foodIds = foodIds;
        this.date = date;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public Map<Integer, Double> getFoodIds() {
        return foodIds;
    }

    public void setFoodIds(Map<Integer, Double> foodIds) {
        this.foodIds = foodIds;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "FoodHistoryDTO{" +
                "history_id=" + history_id +
                "client_id=" + client_id +
                ", food_id=" + food_id +
                ", amount=" + amount +
                ", date=" + date+
                '}';
    }
}
