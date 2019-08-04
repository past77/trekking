package polo.repository.specification;

import polo.connections.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDateOfBirthDay implements SQLSpecification {
    private int id;
    ConnectionManager connectionManager;

    public ClientDateOfBirthDay(int id) {
        this.id = id;
    }

    @Override
    public PreparedStatement toSqlQuery() throws SQLException {
        PreparedStatement readStatement = connectionManager.getConnection()
                .prepareStatement("SELECT date_of_birth FROM clients WHERE id=?");

        readStatement.setInt(1, id);

        return readStatement;
    }
}
