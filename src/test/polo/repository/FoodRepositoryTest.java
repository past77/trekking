package polo.repository;

import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class FoodRepositoryTest {
    private ResultSet resultSet;
    private FoodRepository foodRepository;

    @Before
    public void setUp() throws Exception {
        foodRepository = new FoodRepository();
    }

    @Test
    public void shouldReadEntity() throws SQLException {
        int rows = 0;
        try {
            resultSet = foodRepository.read(0);
            while (resultSet.next()) {
                rows++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertNotEquals(0, rows);

    }
}