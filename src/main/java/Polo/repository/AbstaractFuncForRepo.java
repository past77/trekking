package polo.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ppolozhe on 5/26/19.
 */
public abstract class AbstaractFuncForRepo {

    protected int generateId(PreparedStatement statement) throws SQLException {
        int id = -1;
        ResultSet rs = statement.getGeneratedKeys();
        while (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }
   public double roundResult (double d, int precise) {

        precise = 10^precise;
        d = d*precise;
        int i = (int) Math.round(d);
        return (double) i/precise;

    }

}
