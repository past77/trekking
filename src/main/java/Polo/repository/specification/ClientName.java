package polo.repository.specification;

import polo.connections.ConnectionManager;
import polo.connections.ConnectorManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientName implements SQLSpecification {
    ConnectionManager connectionManager;
    private int id;

    public ClientName(int id) {
        this.id = id;
    }

    @Override
    public PreparedStatement toSqlQuery() throws SQLException {
        connectionManager = new ConnectorManager();
        PreparedStatement readNameStatement = connectionManager.getConnection()
                .prepareStatement("SELECT name FROM clients WHERE id=?");

        readNameStatement.setInt(1, id);

        return readNameStatement;
    }
}
