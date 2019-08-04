package polo.repository;



import polo.connections.ConnectionManager;
import polo.connections.ConnectorManager;
import polo.repository.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoeficientRepository implements IRepository, IQuery {

    ConnectionManager connectionManager;

    @Override
    public void create(Object... args) throws SQLException {
        connectionManager = new ConnectorManager();
        PreparedStatement createStatement = connectionManager.getConnection()
                .prepareStatement("INSERT INTO coeficient VALUES(?, ?, ?)");

        createStatement.setInt(1, (Integer) args[0]);
        createStatement.setDouble(1, (Double) args[1]);
        createStatement.setDouble(1, (Double) args[2]);

        createStatement.execute();

        createStatement.close();
    }

    @Override
    public ResultSet read(int id) throws SQLException {
        connectionManager = new ConnectorManager();

        PreparedStatement readStatement = connectionManager.getConnection().prepareStatement("SELECT * FROM coeficient WHERE id = ?");
        readStatement.setInt(1, id);
        return readStatement.executeQuery();
    }

    @Override
    public void delete(int id) throws SQLException {
        connectionManager = new ConnectorManager();

        PreparedStatement deleteStatement = connectionManager.getConnection().prepareStatement("DELETE FROM coeficient WHERE id=?");
        deleteStatement.setInt(1, id);
        deleteStatement.execute();
        deleteStatement.close();
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