package org.sample.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.sample.api.Hello;

import javax.imageio.spi.ServiceRegistry;

/**
 * Created by aruna on 11/07/2014.
 */
public class Activator implements BundleActivator {
    ServiceRegistration serviceRegistration;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Service Hello Activated...");
        HelloWorld helloWorld = new HelloWorld();
        serviceRegistration = bundleContext.registerService(Hello.class, helloWorld, null);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Service Hello Stopped...");
       serviceRegistration.unregister();
    }
}
