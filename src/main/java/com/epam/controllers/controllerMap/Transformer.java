package com.epam.controllers.controllerMap;

public interface Transformer<S, T> {

    S bind(T t);

    T unbind(S s);

}
