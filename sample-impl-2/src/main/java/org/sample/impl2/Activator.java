package org.sample.impl2;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.sample.api.Hello;

import javax.print.DocFlavor;
import java.util.Hashtable;

/**
 * Created by aruna on 11/07/2014.
 */
public class Activator implements BundleActivator {
    ServiceRegistration serviceRegistration;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Service Hello2 Activated...");
        HelloWorld helloWorld = new HelloWorld();

        //serviceRegistration = bundleContext.registerService(Hello.class, helloWorld, null);

        Hashtable metadata = new Hashtable();
        metadata.put(Constants.SERVICE_RANKING, 1000);

        serviceRegistration = bundleContext.registerService(Hello.class, helloWorld, metadata);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Service Hello2 Stopped...");
        serviceRegistration.unregister();
    }
}
