package com.myproject.connection;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by uyutthy on 3/2/2017.
 */

public class DBCP2DataSourceUtils {
    private static BasicDataSource ds = null;

    static {
        String propsFile = "db.properties";
        Properties props = new Properties();

        try {
            props.load(Thread.currentThread().getContextClassLoader().getResource(propsFile).openStream());
            ds = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
            props = null;
        }
    }
    /**get connection from pool*/
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static DataSource getDataSource() {
        return ds;
    }
}
