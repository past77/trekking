package polo.entity;

public class FoodBuilder {
    private Food foodUnit;

    public void reset() {
        foodUnit = new Food();
    }

    public void setName(String name) {
        foodUnit.setName(name);
    }

    public void setNumber(int number) {
        foodUnit.setNumber(number);
    }

    public void setCalories(double calories) {
        foodUnit.setCalories(calories);
    }

    public void setProteins(double proteins) {
        foodUnit.setProtein(proteins);
    }

    public void setFats(double fats) {
        foodUnit.setFat(fats);
    }

    public void setCarbohydrates(double carbohydrates) {
        foodUnit.setCarbohydrates(carbohydrates);
    }

    public Food getResult() {
        return foodUnit;
    }
}
