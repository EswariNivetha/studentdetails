package com.theatmo.databaseconnection.dbconnection;

import com.theatmo.databaseconnection.exception.ConnectionFailedException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * DataBase Connection.
 *
 * @author EswariNivethaVU
 */
public class DataBaseConnection {

    /**
     * Connects the Database.
     */
//    public Connection getConnection() {
//        Connection connection = null;
//
//        try {
//            Class.forName("org.postgresql.Driver");
//            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/studentdetails", "postgres",
//                    "root");
//        } catch (Exception e) {
//            throw new ConnectionFailedException("Connection Error");
//        }
//        return connection;
//    }
    public static Connection getConnection() {
        Connection connection = null;

        try {
            InputStream input = new FileInputStream("etc/system.properties");
            Properties properties = new Properties();
            properties.load(input);
            //final String driver = properties.getProperty("karaf.jdbc.driver");
            Class.forName("org.postgresql.Driver");
            final String url = properties.getProperty("karaf.jdbc.url");
            final String username = properties.getProperty("karaf.jdbc.user");
            final String password = properties.getProperty("karaf.jdbc.password");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new ConnectionFailedException("Connection Error");
        }
        return connection;
    }
}
