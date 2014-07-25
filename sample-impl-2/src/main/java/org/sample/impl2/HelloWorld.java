package org.sample.impl2;

import org.sample.api.Hello;

/**
 * Created by aruna on 11/07/2014.
 */
public class HelloWorld implements Hello{

    @Override
    public String sayHello() {
        return "Hello World from Sample-Impl-2";
    }
}
