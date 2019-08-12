package polo.entity;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class DailyRationTest {
    private static Food food;
    private static double amount;
    private static DailyRation dailyRation;

    @BeforeClass
    public static void setUp() throws Exception {
        food = new Food();
        food.setId(1);

        amount = 1.0;

        dailyRation = new DailyRation(new HashMap<>());
    }

    @Test
    public void shouldAddNewFood() {
        dailyRation.addFood(food, amount);
        assertEquals(1.0, dailyRation.getFoodAmount(food), 0.0);
    }

    @Test
    public void shouldAddExistedFood() {
        dailyRation.addFood(food, amount);
        assertEquals(2.0, dailyRation.getFoodAmount(food), 0.0);
    }
}
