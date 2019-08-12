package polo.repository.specification;

import org.apache.log4j.Logger;
import polo.connections.ConnectionManager;
import polo.connections.ConnectorManager;
import polo.exception.RepositoryException;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FoodId implements  SQLSpecification{
    private static final Logger LOG = Logger.getLogger(FoodId.class);
    ConnectionManager connectionManager;
    private int id;

    public FoodId(int id) {
        this.id = id;
    }

    @Override
    public PreparedStatement toSqlQuery() {
        connectionManager = new ConnectorManager();

        try {
            PreparedStatement readAllStatement = connectionManager.getConnection()
                    .prepareStatement("SELECT * FROM food WHERE id=?");
            readAllStatement.setInt(1, id);

            return readAllStatement;
        } catch (SQLException e) {
            LOG.error(e.getMessage());
            throw new RepositoryException("Error in specification", e);
        }
    }
}
