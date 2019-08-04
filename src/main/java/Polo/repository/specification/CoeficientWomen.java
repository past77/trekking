package polo.repository.specification;

import polo.connections.ConnectionManager;
import polo.connections.ConnectorManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CoeficientWomen implements SQLSpecification {
    ConnectionManager connectionManager;

    @Override
    public PreparedStatement toSqlQuery() throws SQLException {
        connectionManager = new ConnectorManager();
        return connectionManager.getConnection()
                .prepareStatement("SELECT women FROM coeficient");
    }
}
