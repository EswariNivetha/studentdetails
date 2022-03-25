package com.theatmo.studentmanagement;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Activate the Bundle.
 *
 * @author EswariNivethaVU
 */
public class Activator implements BundleActivator {

    /**
     * Start the bundle
     *
     * @param context
     */
    public void start(final BundleContext context) {
        System.out.println("Starting the View bundle");
    }

    /**
     * stop the bundle
     *
     * @param context
     */
    public void stop(final BundleContext context) {
        System.out.println("Stopping the bundle");
    }
}