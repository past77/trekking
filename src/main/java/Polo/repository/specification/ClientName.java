package polo.repository.specification;

import org.apache.log4j.Logger;
import polo.connections.ConnectionManager;
import polo.connections.ConnectorManager;
import polo.exception.RepositoryException;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientName implements SQLSpecification {
    private static final Logger LOG = Logger.getLogger(FoodId.class);
    ConnectionManager connectionManager;
    private int id;

    public ClientName(int id) {
        this.id = id;
    }

    @Override
    public PreparedStatement toSqlQuery() {
        connectionManager = new ConnectorManager();

        try {

            PreparedStatement readNameStatement = connectionManager.getConnection()
                    .prepareStatement("SELECT name FROM clients WHERE id=?");

            readNameStatement.setInt(1, id);
            return readNameStatement;
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new RepositoryException("Error in specification", e);
        }
    }
}
