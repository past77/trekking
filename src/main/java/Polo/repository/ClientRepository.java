package polo.repository;

import org.apache.log4j.Logger;
import polo.connections.ConnectionManager;
import polo.connections.ConnectorManager;
import polo.exception.RepositoryException;
import polo.repository.specification.SQLSpecification;

import java.sql.*;
import java.time.LocalDate;

public class ClientRepository implements IRepository, IQuery {

    private static final Logger LOG = Logger.getLogger(ClientRepository.class);
    ConnectionManager connectionManager;

    @Override
    public void create(Object... args) {

        connectionManager = new ConnectorManager();

        try(PreparedStatement createStatement = connectionManager.getConnection()
                .prepareStatement("INSERT INTO clients(id, name, password, " +
                        "date_of_birth, gender,height, weight,`lifestyle`) " +
                        "VALUES\n " +
                        " (NULL, ?, ?, ?, ?, ?, ?, ?)")) {

            createStatement.setString(1, (String) args[0]);
            createStatement.setString(2, (String) args[1]);
            createStatement.setTimestamp(3, Timestamp.valueOf(((LocalDate) args[2]).atStartOfDay()));
            createStatement.setString(4, (String) args[3]);
            createStatement.setDouble(5, (Double) args[4]);
            createStatement.setDouble(6, (Double) args[5]);
            createStatement.setString(7, (String) args[6]);

            createStatement.execute();
        } catch (SQLException e){
            LOG.error(e.getMessage());
            throw new RepositoryException("SQL error in create ", e);
        }

    }

    @Override
    public ResultSet read(int id) {
        connectionManager = new ConnectorManager();
        try {
            PreparedStatement readStatement = connectionManager.getConnection()
                    .prepareStatement("SELECT img, name, date_of_birth, gender, height, " +
                            "weight, lifestyle FROM clients WHERE id=?");
            readStatement.setInt(1, id);

            return readStatement.executeQuery();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new RepositoryException("SQL error in read ", e);
        }


    }

    @Override
    public void delete(int id) {
        connectionManager = new ConnectorManager();
        try(PreparedStatement readStatement = connectionManager.getConnection()
                .prepareStatement("DELETE FROM clients WHERE id=?")) {
            readStatement.setInt(1, id);

            readStatement.execute();
        } catch (SQLException e){
            LOG.error(e.getMessage());
            throw new RepositoryException("SQL error in delete ", e);
        }
    }

    @Override
    public int update(Object... args){
        connectionManager = new ConnectorManager();
        try {
            PreparedStatement updateStatement = connectionManager.getConnection()
                    .prepareStatement("UPDATE clients SET name=?, gender=?, " +
                            "height=?, weight=?, lifestyle=?, img=? WHERE id=?");

            updateStatement.setString(1, (String) args[0]);
            updateStatement.setString(2, (String) args[1]);
            updateStatement.setDouble(3, (Double) args[2]);
            updateStatement.setDouble(4, (Double) args[3]);
            updateStatement.setString(5, (String) args[4]);
            updateStatement.setString(6, (String) args[5]);
            updateStatement.setInt(7, (Integer) args[6]);

            return updateStatement.executeUpdate();
        } catch (SQLException e){
            LOG.error(e.getMessage());
            throw new RepositoryException("SQL error in update ", e);
        }

    }

    @Override
    public ResultSet specificReadQuery(SQLSpecification sqlSpecification) {
        try {
            return sqlSpecification.toSqlQuery().executeQuery();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new RepositoryException("Error in specification ", e);
        }
    }
}
