package org.sample.listener;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.sample.api.Hello;

/**
 * Created by jayanga on 7/25/14.
 */
public class Activator implements BundleActivator {
    HelloServiceListener serviceListener;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Starting HelloServiceListenerBundle");
        serviceListener = new HelloServiceListener(bundleContext);

        ServiceReference reference = bundleContext.getServiceReference(Hello.class.getName());

        Hello helloService;

        if (reference != null) {
            helloService = (Hello) bundleContext.getService(reference);
            helloService.sayHello();
        }
        bundleContext.addServiceListener(serviceListener);

    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Stopping HelloServiceListenerBundle");
        bundleContext.removeServiceListener(serviceListener);
    }
}