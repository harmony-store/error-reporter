package com.harmonyplugins.errorreporter;

import com.harmonyplugins.errorreporter.function.ExceptionRunnable;

public class TryRunnable {
    private final ExceptionRunnable runnable;

    private boolean printStackTrace;

    public TryRunnable(ExceptionRunnable runnable) {
        this.runnable = runnable;
    }

    public TryRunnable(ExceptionRunnable runnable, boolean printStackTrace) {
        this.runnable = runnable;
        this.printStackTrace = printStackTrace;
    }

    public TryRunnable printStackTrace() {
        this.printStackTrace = true;
        return this;
    }

    public void run() {
        runnable.runThrowing(printStackTrace);
    }

    public TryRunnable then(ExceptionRunnable runnable) {
        return new TryRunnable(this.runnable.then(runnable), printStackTrace);
    }
}
