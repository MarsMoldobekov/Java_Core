package ru.android.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class SingleCyclicBarrier {
    private static SingleCyclicBarrier instance;
    private final CyclicBarrier cyclicBarrier;

    private SingleCyclicBarrier(int THREADS_COUNT) {
        cyclicBarrier = new CyclicBarrier(THREADS_COUNT);
    }

    public static SingleCyclicBarrier getInstance(int THREADS_COUNT) {
        if (instance == null) {
            instance = new SingleCyclicBarrier(THREADS_COUNT);
        }

        return instance;
    }

    public void await() throws BrokenBarrierException, InterruptedException {
        cyclicBarrier.await();
    }
}
