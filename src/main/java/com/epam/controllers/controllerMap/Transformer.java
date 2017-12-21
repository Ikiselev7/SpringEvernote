package com.epam.controllers.controllerMap;

/**
 * Basic transformer interface.
 *
 * @param <S> Dto model
 * @param <T> Controller model
 */
public interface Transformer<S, T> {


    S bind(T t);

    T unbind(S s);

}
