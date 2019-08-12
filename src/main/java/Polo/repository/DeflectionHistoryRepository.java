package polo.repository;

import org.apache.log4j.Logger;
import polo.connections.ConnectionManager;
import polo.connections.ConnectorManager;
import polo.exception.RepositoryException;

import java.sql.*;

public class DeflectionHistoryRepository implements IRepository {

    private static final Logger LOG = Logger.getLogger(DeflectionHistoryRepository.class);
    ConnectionManager connectionManager;

    @Override
    public void create(Object... args) {
        connectionManager = new ConnectorManager();

        try (PreparedStatement createPreparedStatement = connectionManager.getConnection()
                    .prepareStatement("INSERT INTO deflection_history" +
                " VALUES(NULL, ?, ?, ?, ?, ?, ?)")) {
            createPreparedStatement.setInt(1, (Integer) args[0]);
            createPreparedStatement.setDate(2, (Date) args[1]);
            createPreparedStatement.setDouble(3, (Double) args[2]);
            createPreparedStatement.setDouble(4, (Double) args[3]);
            createPreparedStatement.setDouble(5, (Double) args[4]);
            createPreparedStatement.setDouble(6, (Double) args[5]);

            createPreparedStatement.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new RepositoryException("SQL error in create", e);
        }
    }

    @Override
    public ResultSet read(int id) {
        connectionManager = new ConnectorManager();

        try {
            Statement readStatement = connectionManager.getConnection().createStatement();

            return readStatement.executeQuery(String.format("SELECT * FROM food_history WHERE id=%d", id));
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new RepositoryException("SQL error in read", e);
        }
    }

    @Override
    public void delete(int id) {
        connectionManager = new ConnectorManager();

        try (PreparedStatement deleteStatement = connectionManager.getConnection()
                    .prepareStatement("DELETE FROM food_history WHERE id=?")){
            deleteStatement.setInt(1, id);
            deleteStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int update(Object... args){
        return 0;
    }
}
