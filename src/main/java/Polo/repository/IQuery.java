package polo.repository;

import polo.repository.specification.SQLSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IQuery {
    ResultSet specificReadQuery(SQLSpecification sqlSpecification) throws SQLException;
}

