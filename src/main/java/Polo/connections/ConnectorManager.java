package polo.connections;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;
import polo.exception.InitializationException;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import static java.lang.System.getProperty;

public class ConnectorManager implements ConnectionManager {
    private static final Logger LOGGER = Logger.getLogger(ConnectorManager.class);
    private static BasicDataSource dbcp = new BasicDataSource();
    private static Connection conn = null;

    static {
        try (FileInputStream in = new FileInputStream("target/classes/o.properties")){
            Properties jdbcProps = new Properties();
            jdbcProps.load(in);

            LOGGER.info("Read JDBC properties successfully");

            dbcp.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dbcp.setUrl(jdbcProps.getProperty("url"));
            dbcp.setUsername(jdbcProps.getProperty("username"));
            dbcp.setPassword(jdbcProps.getProperty("password"));
            dbcp.setInitialSize(Integer.parseInt(jdbcProps.getProperty("initial")));
            dbcp.setMaxTotal(Integer.parseInt(jdbcProps.getProperty("max")));
            dbcp.setMinIdle(5);
            dbcp.setMaxIdle(10);
            dbcp.setMaxOpenPreparedStatements(100);
            dbcp.setDefaultTransactionIsolation(1);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new InitializationException("Can't start DBCP");
        }
    }

    public synchronized Connection getConnection() {
        if (conn == null) {
            try {
                conn = dbcp.getConnection();
                LOGGER.info("Connected to database successfully " + conn);
            } catch (SQLException e) {
                LOGGER.fatal("Could't connect to database server", e);
                throw new InitializationException("Could not connect to database server", e);
            }
        }
        return conn;
    }
}
