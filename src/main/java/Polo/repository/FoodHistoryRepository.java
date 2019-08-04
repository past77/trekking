package polo.repository;

import polo.command.AddToPlate;
import polo.connections.ConnectionManager;
import polo.connections.ConnectorManager;
import polo.dto.FoodHistoryDTO;
import polo.repository.specification.SQLSpecification;

import java.sql.*;

public class FoodHistoryRepository extends AbstaractFuncForRepo implements IRepository,  IQuery {
    ConnectionManager connectionManager;

    @Override
    public void create(Object... args) throws SQLException {
        connectionManager = new ConnectorManager();
        AddToPlate fillPlate = new AddToPlate();
        FoodHistoryDTO foodHistoryDTO = new FoodHistoryDTO();

        PreparedStatement createPreparedStatement = connectionManager.getConnection()
                .prepareStatement("INSERT INTO food_history VALUES(NULL, ?, ?, ?, ?)",  Statement.RETURN_GENERATED_KEYS);

        createPreparedStatement.setInt(1, (Integer) args[0]);
        createPreparedStatement.setInt(2, (Integer) args[1]);
        createPreparedStatement.setDouble(3, (Double) args[2]);
        createPreparedStatement.setDate(4, (Date) args[3]);

        createPreparedStatement.execute();
        fillPlate.SetLastId((generateId(createPreparedStatement)));
        createPreparedStatement.close();
    }

    @Override
    public ResultSet read(int historyId) throws SQLException {
        connectionManager = new ConnectorManager();
        Statement readStatement = connectionManager.getConnection().createStatement();

        return readStatement.executeQuery(String.format("SELECT * FROM food_history WHERE history_id=%d", historyId));
    }

    @Override
    public void delete(int historyId) throws SQLException {
        connectionManager = new ConnectorManager();
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
    @Override
    public ResultSet specificReadQuery(SQLSpecification sqlSpecification) throws SQLException {
        return sqlSpecification.toSqlQuery().executeQuery();
    }
}