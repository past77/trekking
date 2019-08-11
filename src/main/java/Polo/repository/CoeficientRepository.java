package polo.repository;



import org.apache.log4j.Logger;
import polo.connections.ConnectionManager;
import polo.connections.ConnectorManager;
import polo.exception.RepositoryException;
import polo.repository.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoeficientRepository implements IRepository, IQuery {

    private static final Logger LOG = Logger.getLogger(CoeficientRepository.class);
    ConnectionManager connectionManager;

    @Override
    public void create(Object... args){
        connectionManager = new ConnectorManager();
        try(PreparedStatement  createStatement = connectionManager.getConnection()
                .prepareStatement("INSERT INTO coeficient VALUES(?, ?, ?)")) {

            createStatement.setInt(1, (Integer) args[0]);
            createStatement.setDouble(1, (Double) args[1]);
            createStatement.setDouble(1, (Double) args[2]);

            createStatement.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new RepositoryException("SQL error in create", e);
        }
    }

    @Override
    public ResultSet read(int id) {
        connectionManager = new ConnectorManager();

        try(PreparedStatement readStatement = connectionManager.getConnection()
                .prepareStatement("SELECT * FROM coeficient WHERE id = ?")) {
            readStatement.setInt(1, id);
            return readStatement.executeQuery();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new RepositoryException("SQL error in read", e);
        }

    }

    @Override
    public void delete(int id) {
        connectionManager = new ConnectorManager();

        try (PreparedStatement deleteStatement = connectionManager.getConnection()
                .prepareStatement("DELETE FROM coeficient WHERE id=?")) {
            deleteStatement.setInt(1, id);
            deleteStatement.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new RepositoryException("SQL error in delete", e);
        }

    }

    @Override
    public int update(Object... args) throws SQLException {
        return 0;
    }

    @Override
    public ResultSet specificReadQuery(SQLSpecification sqlSpecification) {
        try {
            return sqlSpecification.toSqlQuery().executeQuery();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new RepositoryException("Error in specification", e);
        }
    }
}