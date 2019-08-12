package polo.service;

import org.junit.Test;
import polo.entity.Food;

import java.util.List;

import static org.junit.Assert.*;

public class FoodServiceTest {
    @Test
    public void shouldReturnFoodList() {
        List<Food> foodList = new FoodService().getFoodLIst();
        assertNotNull(foodList);
    }

}