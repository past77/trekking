package polo.repository.specification;

import org.apache.log4j.Logger;
import polo.connections.ConnectionManager;
import polo.connections.ConnectorManager;
import polo.exception.RepositoryException;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CoeficientWomen implements SQLSpecification {
    private static final Logger LOG = Logger.getLogger(FoodId.class);
    ConnectionManager connectionManager;

    @Override
    public PreparedStatement toSqlQuery() {
        connectionManager = new ConnectorManager();
        try {
            return connectionManager.getConnection()
                    .prepareStatement("SELECT women FROM coeficient");
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new RepositoryException("Error in specification", e);
        }
    }
}
