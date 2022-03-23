package com.theatmo.databaseconnection.dbconnection;

import com.theatmo.databaseconnection.exception.ConnectionFailedException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

/**
 * DataBase Connection which connects the database.
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
            Class.forName("org.postgresql.Driver");
            final Connection connection = DriverManager.getConnection(properties.get("karaf.jdbc.url"), properties.get("karaf.jdbc.user"), properties.get("karaf.jdbc.password"));
            return connection;
        } catch (Exception e) {
            throw new ConnectionFailedException("Connection Error");
        }
    }

    /**
     * Set the property file for Database Connection
     *
     * @param property
     */
    public static void setProperties(Map < String, String > property) {
        properties = property;
    }
}



