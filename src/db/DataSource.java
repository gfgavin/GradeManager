package db;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.*;

public class DataSource {

    private static DataSource datasource;
    private BasicDataSource ds;

    private DataSource() {
        ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername(DBInfo.USER);
        ds.setPassword(DBInfo.PASSWORD);
        ds.setUrl(DBInfo.URL);

        // the settings below are optional -- dbcp can work with defaults
        ds.setMinIdle(10);
        ds.setMaxIdle(20);
        ds.setMaxOpenPreparedStatements(180);
    }

    public static DataSource getInstance() {
        if (datasource == null) {
            datasource = new DataSource();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }

}
