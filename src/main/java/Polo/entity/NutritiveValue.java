package polo.entity;

import java.util.Objects;

public class NutritiveValue {
    private double calories;
    private double protein;
    private double fat;
    private double carbohydrates;

    public NutritiveValue(double calories, double protein, double fat, double carbohydrates) {
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
    }

    public NutritiveValue subtract(NutritiveValue norm) {
        double caloriesDifference = this.calories - norm.getCalories();
        double proteinDifference = this.protein - norm.getProtein();
        double fatDifference = this.fat - norm.getFat();
        double carbohydratesDifference = this.carbohydrates - norm.getCarbohydrates();

        return new NutritiveValue(caloriesDifference, proteinDifference, fatDifference, carbohydratesDifference);
    }

    public NutritiveValue add(NutritiveValue adder) {
        double resultCalories = calories + adder.calories;
        double resultProtein = protein + adder.protein;
        double resultFat = fat + adder.fat;
        double resultCarbohydrates = carbohydrates + adder.carbohydrates;

        return new NutritiveValue(resultCalories, resultProtein, resultFat, resultCarbohydrates);
    }

    public double getCalories() {
        return calories;
    }

    public double getProtein() {
        return protein;
    }

    public double getFat() {
        return fat;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NutritiveValue that = (NutritiveValue) o;
        return Double.compare(that.getCalories(), getCalories()) == 0 &&
                Double.compare(that.getProtein(), getProtein()) == 0 &&
                Double.compare(that.getFat(), getFat()) == 0 &&
                Double.compare(that.getCarbohydrates(), getCarbohydrates()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCalories(), getProtein(), getFat(), getCarbohydrates());
    }

    @Override
    public String toString() {
        return "NutritiveValue{" +
                "calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", carbohydrates=" + carbohydrates +
                '}';
    }
}
