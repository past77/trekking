package Polo.repository;

import Polo.connections.ConnectionManager;

import java.sql.*;

public class FoodHistoryRepository implements IRepository {
    ConnectionManager connectionManager;
    @Override
    public void create(Object... args) throws SQLException {
        PreparedStatement createPreparedStatement = connectionManager.getConnection()
                .prepareStatement("INSERT INTO food_history VALUES(NULL, ?, ?, ?, ?)");

        createPreparedStatement.setInt(1, (Integer) args[0]);
        createPreparedStatement.setInt(2, (Integer) args[1]);
        createPreparedStatement.setDouble(3, (Double) args[2]);
        createPreparedStatement.setDate(4, (Date) args[3]);

        createPreparedStatement.execute();

        createPreparedStatement.close();
    }

    @Override
    public ResultSet read(int historyId) throws SQLException {
        Statement readStatement = connectionManager.getConnection().createStatement();

        return readStatement.executeQuery(String.format("SELECT * FROM food_history WHERE id=%d", historyId));
    }

    @Override
    public void delete(int historyId) throws SQLException {
        PreparedStatement readStatement = connectionManager.getConnection().
                prepareStatement("DELETE FROM food_history WHERE id=?");

        readStatement.setInt(1, historyId);
        readStatement.execute();

        readStatement.close();
    }

    @Override
    public int update(Object... args) throws SQLException {
        return 0;
    }
}