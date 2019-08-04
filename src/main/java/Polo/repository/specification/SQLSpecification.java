package polo.repository.specification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SQLSpecification {
    PreparedStatement toSqlQuery() throws SQLException;
}
