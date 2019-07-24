package Polo.repository.specification;

import Polo.connections.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientLogin implements SQLSpecification {
    ConnectionManager connectionManager;
    private String userName;
    private String password;

    public ClientLogin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public PreparedStatement toSqlQuery() throws SQLException {
        PreparedStatement readStatement = connectionManager.getConnection()
                .prepareStatement("SELECT id, name, password, role FROM clients WHERE name = ? AND password = ?");

        readStatement.setString(1, userName);
        readStatement.setString(2, password);

        return readStatement;
    }
}
