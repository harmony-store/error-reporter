package com.harmonyplugins.errorreporter.function;

import java.util.Objects;

public interface ExceptionRunnable {
    void run() throws Exception;

    default void runThrowing(boolean printStackTrace) {
        try {
            run();
        } catch (Exception e) {
            if(printStackTrace) e.printStackTrace();
        }
    }

    default ExceptionRunnable then(ExceptionRunnable after) {
        Objects.requireNonNull(after);
        return () -> { run(); after.run(); };
    }
}
