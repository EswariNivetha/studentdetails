package com.theatmo.studentmanagement.controller;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.log4j.Logger;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * RestService which activate the server.
 *
 * @author EswariNivethaVU
 */
@Component(immediate = true)
public class RestService {

    private Server server;
    private static final Logger LOGGER = Logger.getLogger(RestService.class);

    /**
     * Activate the server.
     */
    @Activate
    public void activate() {
        try {
            final JAXRSServerFactoryBean bean = new JAXRSServerFactoryBean();

            bean.setAddress("/student");
            bean.setBus(BusFactory.getDefaultBus());
            bean.setProvider(new JacksonJsonProvider());
            bean.setServiceBean(new StudentRestControllerImpl());

            server = bean.create();
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
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
