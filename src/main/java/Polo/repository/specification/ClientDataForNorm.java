package Polo.repository.specification;

import Polo.connections.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDataForNorm implements SQLSpecification {
    ConnectionManager connectionManager;
    private int id;

    public ClientDataForNorm (int id) {
        this.id = id;
    }

    @Override
    public PreparedStatement toSqlQuery() throws SQLException {
        PreparedStatement readStatement = connectionManager.getConnection()
                .prepareStatement("SELECT date_of_birth, gender, height, weight, lifestyle FROM clients WHERE id=?");

        readStatement.setInt(1, id);

        return readStatement;
    }
}
