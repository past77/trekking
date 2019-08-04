package polo.repository;

import polo.connections.ConnectionManager;
import polo.connections.ConnectorManager;
import polo.repository.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FoodRepository implements IRepository, IQuery {
    ConnectionManager connectionManager;

    @Override
    public void create(Object... args) throws SQLException {
        connectionManager = new ConnectorManager();
        PreparedStatement insertFoodUnit = connectionManager.getConnection()
                .prepareStatement("INSERT INTO food VALUES(NULL, ?, ?, ?, ?, ?, ?)");

        insertFoodUnit.setString(1, (String) args[0]);
        insertFoodUnit.setInt(2, (Integer) args[1]);
        insertFoodUnit.setDouble(3, (Double) args[2]);
        insertFoodUnit.setDouble(4, (Double) args[3]);
        insertFoodUnit.setDouble(5, (Double) args[4]);
        insertFoodUnit.setDouble(6, (Double) args[5]);

        insertFoodUnit.execute();

        insertFoodUnit.close();

    }

    @Override
    public ResultSet read(int id) throws SQLException {
        connectionManager = new ConnectorManager();
        Statement readStatement = connectionManager.getConnection().createStatement();

        return readStatement.executeQuery("SELECT * FROM food");
    }

    @Override
    public void delete(int id) throws SQLException {
        connectionManager = new ConnectorManager();
        PreparedStatement deleteStatement = connectionManager.getConnection()
                .prepareStatement("DELETE FROM food WHERE id = ?");

        deleteStatement.setInt(1, id);
        deleteStatement.execute();

        deleteStatement.close();
    }

    @Override
    public int update(Object... args) throws SQLException {
        connectionManager = new ConnectorManager();
        PreparedStatement updateStatement = connectionManager.getConnection()
                .prepareStatement("UPDATE food SET name=?, number=?, " +
                        "calories=?, proteins=?, fats=?, carbohydrates=? WHERE id=?");
        updateStatement.setString(1, (String) args[0]);
        updateStatement.setString(2, (String) args[1]);
        updateStatement.setString(3, (String) args[2]);
        updateStatement.setString(4, (String) args[3]);
        updateStatement.setString(5, (String) args[4]);
        updateStatement.setString(6, (String) args[5]);
        updateStatement.setString(7, (String) args[6]);

        return updateStatement.executeUpdate();
    }
    @Override
    public ResultSet specificReadQuery(SQLSpecification sqlSpecification) throws SQLException {
        return sqlSpecification.toSqlQuery().executeQuery();
    }
}