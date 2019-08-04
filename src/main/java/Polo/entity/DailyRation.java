package polo.entity;

import java.util.Map;

public class DailyRation {
    private Map<Food, Double> foodMap;
    private Double amount;

    public DailyRation(Map<Food, Double> foodMap) {
        this.foodMap = foodMap;
    }

    public Map<Food, Double> getFoodMap() {
        return foodMap;
    }

    public void addFood(Food food, Double amnt) {
        System.out.println("amount: " + amount);
        if ((amount = foodMap.get(food)) != null) {
            amount += amnt;
        } else {
            amount = amnt;
        }

        foodMap.put(food, amount);
    }

    public double getFoodAmount(Food food) {
        return foodMap.get(amount);
    }

    @Override
    public String toString() {
        return "DailyRation{" +
                "foodMap=" + foodMap +
                ", amount=" + amount +
                '}';
    }
}