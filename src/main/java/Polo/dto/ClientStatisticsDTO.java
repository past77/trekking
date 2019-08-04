package polo.dto;

import polo.entity.NutritiveValue;

public class ClientStatisticsDTO {
    String name;
    NutritiveValue averageDeflection;
    String favFood;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NutritiveValue getAverageDeflection() {
        return averageDeflection;
    }

    public void setAverageDeflection(NutritiveValue averageDeflection) {
        this.averageDeflection = averageDeflection;
    }

    public String getFavFood() {
        return favFood;
    }

    public void setFavFood(String favFood) {
        this.favFood = favFood;
    }
}
