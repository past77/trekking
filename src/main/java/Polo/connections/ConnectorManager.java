package Polo.connections;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

import static java.lang.System.getProperty;

public class ConnectorManager  implements ConnectionManager {
    private static final Logger LOGGER = Logger.getLogger(ConnectorManager.class);
    private static final String PROP_FILE_NAME = "options";

    private String url;
    private String username;
    private String password;
    private int initialSize;
    private int maxSize;

    private static BasicDataSource instance;

    public ConnectorManager() {
        try {
            url = getProperty("url", PROP_FILE_NAME);
            username = getProperty("username", PROP_FILE_NAME);
            password = getProperty("pass", PROP_FILE_NAME);
            initialSize = Integer.parseInt(getProperty("initial", PROP_FILE_NAME));
            maxSize = Integer.parseInt(getProperty("max", PROP_FILE_NAME));
            instance = setupDriver();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }


    public synchronized Connection getConnection() {
        Connection connection = null;
        try {
            connection = instance.getConnection();
            LOGGER.debug("Connection received " + connection);
        } catch (SQLException e) {
            LOGGER.error("Can't provide connection from pool.");
        }
        return connection;
    }
        private BasicDataSource setupDriver () throws Exception {
            BasicDataSource dbcp = new BasicDataSource();
            dbcp.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dbcp.setUrl(url);
            dbcp.setUsername(username);
            dbcp.setPassword(password);
            dbcp.setInitialSize(initialSize);
            dbcp.setMaxTotal(maxSize);
            dbcp.getConnection();
            return dbcp;
        }
}
