package ru.android;

import java.util.concurrent.*;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Main {
    private static record MyCallable(float[] array) implements Callable<float[]> {

        @Override
        public float[] call() {
            float[] result = new float[array.length];
            int length = array.length;

            for (int i = 0; i < length; i++) {
                result[i] = (float) (array[i] * sin(0.2f + i / 5.0f) * cos(0.2f + i / 5.0f) * cos(0.4f + i / 2.0f));
            }

            return result;
        }
    }

    private static final int SIZE = 10_000_000;
    private static final int HALF_SIZE = SIZE / 2;

    private static final float INIT_VALUE = 1.0F;

    public static void main(String[] args) {
        changeArray();
        changeArrayAsynchronously();
    }

    private static void changeArray() {
        float[] array = new float[SIZE];

        for (int i = 0; i < SIZE; i++) {
            array[i] = INIT_VALUE;
        }

        long a = System.currentTimeMillis();

        MyCallable myCallable = new MyCallable(array);
        array = myCallable.call();

        System.out.println(System.currentTimeMillis() - a);
    }

    private static void changeArrayAsynchronously() {
        float[] array = new float[SIZE];
        float[] array1 = new float[HALF_SIZE];
        float[] array2 = new float[HALF_SIZE];

        for (int i = 0; i < SIZE; i++) {
            array[i] = INIT_VALUE;
        }

        long a = System.currentTimeMillis();

        System.arraycopy(array, 0, array1, 0, HALF_SIZE);
        System.arraycopy(array, HALF_SIZE, array2, 0, HALF_SIZE);

        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<float[]> future1 = service.submit(new MyCallable(array1));
        Future<float[]> future2 = service.submit(new MyCallable(array2));

        try {
            System.arraycopy(future1.get(), 0, array, 0, HALF_SIZE);
            System.arraycopy(future2.get(), 0, array, HALF_SIZE, HALF_SIZE);
        } catch (InterruptedException | ExecutionException exception) {
            exception.printStackTrace();
        }

        service.shutdown();

        System.out.println(System.currentTimeMillis() - a);
    }
}
