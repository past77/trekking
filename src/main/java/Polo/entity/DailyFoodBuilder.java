package polo.entity;

public class DailyFoodBuilder {
    private FoodHistory foodUnit;

    public void reset() {
        foodUnit = new FoodHistory();
    }

    public void setClient_id(int client_id) {
        foodUnit.setClient_id(client_id);
    }

    public void setFood_id(int food_id) {
        foodUnit.setFood_id(food_id);
    }
    public void setAmount(int amount) {
        foodUnit.setAmount(amount);
    }
    public FoodHistory getResult() {
        return foodUnit;
    }
}
