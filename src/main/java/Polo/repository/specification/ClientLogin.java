package polo.repository.specification;

import org.apache.log4j.Logger;
import polo.connections.ConnectionManager;
import polo.connections.ConnectorManager;
import polo.exception.RepositoryException;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientLogin implements SQLSpecification {
    private static final Logger LOG = Logger.getLogger(FoodId.class);

    ConnectionManager connectionManager;
    private String userName;
    private String password;

    public ClientLogin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public PreparedStatement toSqlQuery()  {
        connectionManager = new ConnectorManager();
        try(PreparedStatement readStatement = connectionManager.getConnection()
                    .prepareStatement("SELECT id, name, password, role " +
                            "FROM clients WHERE name = ? AND password = ?")) {

            readStatement.setString(1, userName);
            readStatement.setString(2, password);

            return readStatement;
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new RepositoryException("Error in specification", e);
        }
    }
}
