package polo.repository;

import org.apache.log4j.Logger;
import polo.connections.ConnectionManager;
import polo.connections.ConnectorManager;
import polo.exception.RepositoryException;
import polo.repository.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FoodRepository implements IRepository, IQuery {
    private static final Logger LOG = Logger.getLogger(FoodRepository.class);

    ConnectionManager connectionManager;

    @Override
    public void create(Object... args) {
        connectionManager = new ConnectorManager();
        try (PreparedStatement insertFoodUnit = connectionManager.getConnection()
                    .prepareStatement("INSERT INTO food VALUES(NULL, ?, ?, ?, ?, ?, ?)")) {

            insertFoodUnit.setString(1, (String) args[0]);
            insertFoodUnit.setInt(2, (Integer) args[1]);
            insertFoodUnit.setDouble(3, (Double) args[2]);
            insertFoodUnit.setDouble(4, (Double) args[3]);
            insertFoodUnit.setDouble(5, (Double) args[4]);
            insertFoodUnit.setDouble(6, (Double) args[5]);

            insertFoodUnit.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new RepositoryException("SQL error in create", e);
        }
    }

    @Override
    public ResultSet read(int id){
        connectionManager = new ConnectorManager();
        try {
            Statement readStatement = connectionManager.getConnection().createStatement();

            return readStatement.executeQuery("SELECT * FROM food");
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new RepositoryException("SQL error in read", e);
        }
    }

    @Override
    public void delete(int id) {
        connectionManager = new ConnectorManager();
        try(PreparedStatement deleteStatement = connectionManager.getConnection()
                .prepareStatement("DELETE FROM food WHERE id = ?")) {

            deleteStatement.setInt(1, id);
            deleteStatement.execute();
        } catch (SQLException e) {
            throw new RepositoryException("SQL error in delete", e);
        }
    }

    @Override
    public int update(Object... args) {
        connectionManager = new ConnectorManager();
        try {
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
        } catch (SQLException e) {
            throw new RepositoryException("SQL error in update", e);
        }
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