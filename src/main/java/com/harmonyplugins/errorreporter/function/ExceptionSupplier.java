package com.harmonyplugins.errorreporter.function;

public interface ExceptionSupplier<T> {
    T get() throws Exception;

    default T getThrowing(boolean printStackTrace) {
        try {
            return get();
        } catch (Exception e) {
            if(printStackTrace) e.printStackTrace();
            return null;
        }
    }
}
