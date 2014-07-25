package org.sample;

import org.osgi.framework.*;

/**
 * Created by aruna on 11/07/2014.
 */
public class Activator implements BundleActivator , FrameworkListener , SynchronousBundleListener{
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Starting sample activator..");
        Bundle[] bundles = bundleContext.getBundles();
        for (int i = 0; i < bundles.length ; i++) {
            System.out.println(bundles[i].getSymbolicName()+" -------- "+bundles[i].getVersion());
        }

        bundleContext.addBundleListener(new Activator());
        bundleContext.addFrameworkListener(new Activator());
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Stopping sample activator..");

    }

    @Override
    public void bundleChanged(BundleEvent event) {
        System.out.println("\tBundleEvent(type=" + event.getType() +
                ",bundle=" + event.getBundle() +
                ",source=" + event.getSource()+")");
    }

    @Override
    public void frameworkEvent(FrameworkEvent event) {
        System.out.println("\tFrameworkEvent(type=" + event.getType() +
                ",bundle=" + event.getBundle() +
                ",source=" + event.getSource() +
                ",throwable=" + event.getThrowable() + ")");
    }
}
