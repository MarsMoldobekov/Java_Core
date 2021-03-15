package ru.android.concurrent;

import java.util.concurrent.Semaphore;

public class SingleSemaphore {
    private static SingleSemaphore instance;
    private final Semaphore semaphore;

    private SingleSemaphore(int THREADS_COUNT) {
        this.semaphore = new Semaphore(THREADS_COUNT);
    }

    public static SingleSemaphore getInstance(int THREADS_COUNT) {
        if (instance == null) {
            instance = new SingleSemaphore(THREADS_COUNT);
        }

        return instance;
    }

    public void acquire() throws InterruptedException {
        semaphore.acquire();
    }

    public void release() {
        semaphore.release();
    }
}
