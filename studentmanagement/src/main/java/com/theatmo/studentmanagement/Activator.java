package com.theatmo.studentmanagement;

import com.theatmo.studentmanagement.view.StudentManagement;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(BundleContext context) {
        System.out.println("Starting the View bundle");
        //StudentManagement.selectChoice();
    }

    public void stop(BundleContext context) {
        System.out.println("Stopping the bundle");
    }
}