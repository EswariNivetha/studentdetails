package com.theatmo.databaseconnection.dbconnection;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import java.util.Map;

/**
 * DataBaseService which gets the Databaseconnection by using property file .
 *
 * @author EswariNivethaVU
 */
@Component(immediate = true, name = "jdbcconnection")
public class DataBaseProperties {

    /**
     * Activate the server.
     */
    @Activate
    public void activate(Map<String, String> properties) {
        DataBaseConnection.setProperties(properties);
    }
}
