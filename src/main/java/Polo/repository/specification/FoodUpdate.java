package polo.repository.specification;

import org.apache.log4j.Logger;
import polo.connections.ConnectionManager;
import polo.connections.ConnectorManager;
import polo.entity.Food;
import polo.exception.RepositoryException;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FoodUpdate implements  SQLSpecification{
    private static final Logger LOG = Logger.getLogger(FoodUpdate.class);
    ConnectionManager connectionManager;
    private Food food;


    public FoodUpdate(Food food) {
        this.food = food;
    }

    @Override
    public PreparedStatement toSqlQuery() {
        connectionManager = new ConnectorManager();

        try {
            PreparedStatement updateStatement = connectionManager.getConnection()
                    .prepareStatement("UPDATE food SET name='?', number=?, " +
                            "calories=?, proteins=?, fats=?, carbohydrates=?" +
                            "WHERE id=?");

            updateStatement.setString(1, food.getName());
            updateStatement.setInt(2, food.getNumber());
            updateStatement.setDouble(3, food.getCalories());
            updateStatement.setDouble(4, food.getProtein());
            updateStatement.setDouble(5, food.getFat());
            updateStatement.setDouble(6, food.getCarbohydrates());

            return updateStatement;
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new RepositoryException("Error in specification", e);
        }


    }
}
