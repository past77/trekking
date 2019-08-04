package polo.repository.specification;

import polo.connections.ConnectionManager;
import polo.connections.ConnectorManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FoodId implements  SQLSpecification{
    ConnectionManager connectionManager;
    private int id;

    public FoodId(int id) {
        this.id = id;
    }

    @Override
    public PreparedStatement toSqlQuery() throws SQLException {
        connectionManager = new ConnectorManager();
        PreparedStatement readAllStatement = connectionManager.getConnection()
                .prepareStatement("SELECT * FROM food WHERE id=?");

        readAllStatement.setInt(1, id);

        return readAllStatement;
    }
}
