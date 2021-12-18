package com.harmonyplugins.errorreporter;

import com.harmonyplugins.errorreporter.function.ExceptionSupplier;

public class TrySupplier<T> {
    private final ExceptionSupplier<T> supplier;

    private boolean printStackTrace;

    public TrySupplier(ExceptionSupplier<T> supplier) {
        this.supplier = supplier;
    }

    public TrySupplier(ExceptionSupplier<T> supplier, boolean printStackTrace) {
        this.supplier = supplier;
        this.printStackTrace = printStackTrace;
    }

    public TrySupplier<T> printStackTrace() {
        this.printStackTrace = true;
        return this;
    }

    public T or(T obj) {
        final T throwing = supplier.getThrowing(printStackTrace);
        if(throwing == null) {
            return obj;
        }

        return throwing;
    }
}
