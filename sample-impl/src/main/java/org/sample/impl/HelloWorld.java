package org.sample.impl;

import org.sample.api.Hello;

/**
 * Created by aruna on 11/07/2014.
 */
public class HelloWorld implements Hello{

    @Override
    public String sayHello() {
        return "Hello World";
    }
}
