package Polo.repository.specification;

import Polo.connections.ConnectionManager;

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
        PreparedStatement readNameStatement = connectionManager.getConnection()
                .prepareStatement("SELECT name FROM clients WHERE id=?");

        readNameStatement.setInt(1, id);

        return readNameStatement;
    }
}
