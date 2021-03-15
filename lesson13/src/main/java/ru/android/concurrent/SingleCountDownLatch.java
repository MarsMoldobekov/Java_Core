package ru.android.concurrent;

import java.util.concurrent.CountDownLatch;

public class SingleCountDownLatch {
    private static SingleCountDownLatch instance;
    private final CountDownLatch countDownLatch;

    private SingleCountDownLatch(int THREADS_COUNT) {
        countDownLatch = new CountDownLatch(THREADS_COUNT);
    }

    public static SingleCountDownLatch getInstance(int THREADS_COUNT) {
        if (instance == null) {
            instance = new SingleCountDownLatch(THREADS_COUNT);
        }

        return instance;
    }

    public void await() throws InterruptedException {
        countDownLatch.await();
    }

    public void countDown() {
        countDownLatch.countDown();
    }
}
