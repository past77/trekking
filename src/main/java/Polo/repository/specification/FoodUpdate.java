package polo.repository.specification;

import polo.connections.ConnectionManager;
import polo.connections.ConnectorManager;
import polo.entity.Food;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FoodUpdate implements  SQLSpecification{
    ConnectionManager connectionManager;
    private Food food;


    public FoodUpdate(Food food) {
        this.food = food;
    }

    @Override
    public PreparedStatement toSqlQuery() throws SQLException {
        connectionManager = new ConnectorManager();
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
    }
}
