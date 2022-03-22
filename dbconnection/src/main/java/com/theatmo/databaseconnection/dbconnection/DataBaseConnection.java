package com.theatmo.databaseconnection.dbconnection;

import com.theatmo.databaseconnection.exception.ConnectionFailedException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;


/**
 * DataBase Connection.
 *
 * @author EswariNivethaVU
 */

public class DataBaseConnection {

    private static Map<String, String> properties;

    /**
     * Connects the Database.
     */
    public static Connection getConnection() {

        try {
            //String driver = properties.get("karaf.jdbc.driver");
            Class.forName("org.postgresql.Driver");
           // Class.forName(driver);
            final Connection connection = DriverManager.getConnection(properties.get("karaf.jdbc.url"), properties.get("karaf.jdbc.user"), properties.get("karaf.jdbc.password"));
            return connection;
        } catch (Exception e) {
            throw new ConnectionFailedException("Connection Error");
        }
    }

    public static void studentDbConnection(Map<String, String> property) {
        properties = property;
    }
}



