package polo.repository;

import polo.connections.ConnectionManager;
import polo.connections.ConnectorManager;

import java.sql.*;

public class DeflectionHistoryRepository implements IRepository {

    ConnectionManager connectionManager;

    @Override
    public void create(Object... args) throws SQLException {
        connectionManager = new ConnectorManager();

        PreparedStatement createPreparedStatement = connectionManager.getConnection()
                .prepareStatement("INSERT INTO deflection_history" +
                        " VALUES(NULL, ?, ?, ?, ?, ?, ?)");

        createPreparedStatement.setInt(1, (Integer) args[0]);
        createPreparedStatement.setDate(2, (Date) args[1]);
        createPreparedStatement.setDouble(3, (Double) args[2]);
        createPreparedStatement.setDouble(4, (Double) args[3]);
        createPreparedStatement.setDouble(5, (Double) args[4]);
        createPreparedStatement.setDouble(6, (Double) args[5]);

        createPreparedStatement.execute();

        createPreparedStatement.close();
    }

    @Override
    public ResultSet read(int id) throws SQLException {
        connectionManager = new ConnectorManager();

        Statement readStatement = connectionManager.getConnection().createStatement();

        return readStatement.executeQuery(String.format("SELECT * FROM food_history WHERE id=%d", id));
    }

    @Override
    public void delete(int id) throws SQLException {
        connectionManager = new ConnectorManager();

        PreparedStatement deleteStatement = connectionManager.getConnection()
                .prepareStatement("DELETE FROM food_history WHERE id=?");

        deleteStatement.setInt(1, id);
        deleteStatement.execute();

        deleteStatement.close();
    }

    @Override
    public int update(Object... args){
        return 0;
    }
}
