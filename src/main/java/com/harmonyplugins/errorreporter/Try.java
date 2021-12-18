package com.harmonyplugins.errorreporter;

import com.harmonyplugins.errorreporter.function.ExceptionRunnable;
import com.harmonyplugins.errorreporter.function.ExceptionSupplier;

public class Try {
    public static TryRunnable of(ExceptionRunnable runnable) {
        return new TryRunnable(runnable);
    }

    public static <T> TrySupplier<T> ofSupplier(ExceptionSupplier<T> supplier) {
        return new TrySupplier<T>(supplier);
    }
}
