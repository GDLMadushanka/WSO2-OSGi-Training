package org.sample.bundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.sample.api.Hello;

/**
 * Created by aruna on 11/07/2014.
 */
public class Activator implements BundleActivator {
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Staring Sample Service Consumer Bundle...");

        ServiceReference reference = bundleContext.getServiceReference(Hello.class.getName());

        Hello helloService = null;

        if (reference != null) {
            helloService = (Hello) bundleContext.getService(reference);
        }else{
            System.out.println("Service reference is null...");
        }

        if (helloService != null) {
            System.out.println(helloService.sayHello());
        }else{
            System.out.println("Hello service is null...");
        }
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Stopping Sample Service Consumer Bundle...");
    }
}
