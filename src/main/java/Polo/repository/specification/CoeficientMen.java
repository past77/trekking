package Polo.repository.specification;

import Polo.connections.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CoeficientMen implements SQLSpecification {
    ConnectionManager connectionManager;
    @Override
    public PreparedStatement toSqlQuery() throws SQLException {
        return connectionManager.getConnection()
                .prepareStatement("SELECT men FROM coeficient");
    }
}
