package polo.repository;

import org.apache.log4j.Logger;
import polo.command.AddToPlate;
import polo.connections.ConnectionManager;
import polo.connections.ConnectorManager;
import polo.dto.FoodHistoryDTO;
import polo.exception.RepositoryException;
import polo.repository.specification.SQLSpecification;

import java.sql.*;

public class FoodHistoryRepository extends AbstaractFuncForRepo implements IRepository,  IQuery {
    private static final Logger LOG = Logger.getLogger(FoodHistoryRepository.class);
    ConnectionManager connectionManager;

    @Override
    public void create(Object... args) {
        connectionManager = new ConnectorManager();
        AddToPlate fillPlate = new AddToPlate();

        try (PreparedStatement createPreparedStatement = connectionManager.getConnection()
                    .prepareStatement("INSERT INTO food_history VALUES(NULL, ?, ?, ?, ?)",  Statement.RETURN_GENERATED_KEYS)) {
            createPreparedStatement.setInt(1, (Integer) args[0]);
            createPreparedStatement.setInt(2, (Integer) args[1]);
            createPreparedStatement.setDouble(3, (Double) args[2]);
            createPreparedStatement.setDate(4, (Date) args[3]);

            createPreparedStatement.execute();
            fillPlate.SetLastId((generateId(createPreparedStatement)));
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new RepositoryException("SQL error in create", e);
        }
    }

    @Override
    public ResultSet read(int historyId){
        connectionManager = new ConnectorManager();

        try (Statement readStatement = connectionManager.getConnection().createStatement()) {
            return readStatement.executeQuery(String.format("SELECT * FROM food_history WHERE history_id=%d", historyId));
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new RepositoryException("SQL error in read", e);
        }
    }

    @Override
    public void delete(int historyId) {
        connectionManager = new ConnectorManager();
        try (PreparedStatement readStatement = connectionManager.getConnection().
                prepareStatement("DELETE FROM food_history WHERE id=?")) {
            readStatement.setInt(1, historyId);
            readStatement.execute();
        } catch (SQLException e){
            LOG.error(e.getMessage());
            throw new RepositoryException("SQL error in delete", e);
        }
    }

    @Override
    public int update(Object... args){
        return 0;
    }

    @Override
    public ResultSet specificReadQuery(SQLSpecification sqlSpecification) {
        try {
            return sqlSpecification.toSqlQuery().executeQuery();
        } catch (SQLException e) {
            throw new RepositoryException("SQL error in specification", e);
        }
    }
}