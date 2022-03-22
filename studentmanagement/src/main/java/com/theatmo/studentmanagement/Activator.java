package com.theatmo.studentmanagement;

import com.theatmo.studentmanagement.view.StudentManagement;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Activator
 *
 * @author EswariNivethaVU
 */
public class Activator implements BundleActivator {

    /**
     * Start the bundle
     *
     * @param context
     */
    public void start(BundleContext context) {
        System.out.println("Starting the View bundle");
        //StudentManagement.selectChoice();
    }

    /**
     * stop the bundle
     *
     * @param context
     */
    public void stop(BundleContext context) {
        System.out.println("Stopping the bundle");
    }
}