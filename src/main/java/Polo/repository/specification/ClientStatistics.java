package polo.repository.specification;

import polo.connections.ConnectionManager;
import polo.connections.ConnectorManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientStatistics implements SQLSpecification {
    ConnectionManager connectionManager;

    @Override
    public PreparedStatement toSqlQuery() throws SQLException {
        connectionManager = new ConnectorManager();

        return connectionManager.getConnection()
                .prepareStatement("Select clients.name, food_history.date, food.name,  food_history.amount\n" +
                        "from clients\n" +
                        "Join food_history on food_history.client_id = clients.id\n" +
                        "join food on food_history.food_id = food.id order by food_history.date desc;");
    }
}
