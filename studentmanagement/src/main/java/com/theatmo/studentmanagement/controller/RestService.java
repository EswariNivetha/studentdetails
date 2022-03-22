package com.theatmo.studentmanagement.controller;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

/**
 * RestService.
 *
 * @author EswariNivethaVU
 */
@Component(immediate = true, name = "system.properties" )
public class RestService {

    private Server server;
    /**
     * Activate the server.
     */
    @Activate
    public void activate(Map<String, Object> properties) {
        try {
            String driver =  (String) properties.get("karaf.jdbc.driver");

            System.out.println(driver);
            JAXRSServerFactoryBean bean = new JAXRSServerFactoryBean();
            bean.setAddress("/student");
            bean.setBus(BusFactory.getDefaultBus());
            bean.setProvider(new JacksonJsonProvider());
            bean.setServiceBean(new StudentApiImpl());
            server = bean.create();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    /**
     * Deactivate the server.
     */
    @Deactivate
    public void deactivate() throws Exception {
        if (server != null) {
            server.destroy();
        }
    }
}
