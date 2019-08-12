package polo.repository.specification;

import org.apache.log4j.Logger;
import polo.connections.ConnectionManager;
import polo.connections.ConnectorManager;
import polo.exception.RepositoryException;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientStatistics implements SQLSpecification {
    private static final Logger LOG = Logger.getLogger(ClientStatistics.class);

    ConnectionManager connectionManager;

    @Override
    public PreparedStatement toSqlQuery() {
        connectionManager = new ConnectorManager();

        try {
            return connectionManager.getConnection()
                    .prepareStatement("Select clients.name, food_history.date, food.name,  food_history.amount\n" +
                            "from clients\n" +
                            "Join food_history on food_history.client_id = clients.id\n" +
                            "join food on food_history.food_id = food.id order by food_history.date desc;");
        } catch (SQLException e) {
                LOG.error(e.getMessage());
                throw new RepositoryException("Error in specification", e);
        }
    }
}
