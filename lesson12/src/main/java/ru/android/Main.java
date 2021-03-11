package ru.android;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Main {
    private static final int SIZE = 10_000_000;
    private static final int HALF_SIZE = SIZE / 2;
    private static final int THREADS_COUNT = 2;

    private static final float INIT_VALUE = 1.0F;

    public static void main(String[] args) {
        changeArray();
        changeArrayAsynchronously();
    }

    private static void changeArray() {
        final float[] array = new float[SIZE];

        for (int i = 0; i < SIZE; i++) {
            array[i] = INIT_VALUE;
        }

        long a = System.currentTimeMillis();

        changeElementsByFormula(array, array.length);

        System.out.println(System.currentTimeMillis() - a);
    }

    private static void changeArrayAsynchronously() {
        final float[] array = new float[SIZE];
        final float[] array1 = new float[HALF_SIZE];
        final float[] array2 = new float[HALF_SIZE];

        for (int i = 0; i < SIZE; i++) {
            array[i] = INIT_VALUE;
        }

        long a = System.currentTimeMillis();

        System.arraycopy(array, 0, array1, 0, HALF_SIZE);
        System.arraycopy(array, HALF_SIZE, array2, 0, HALF_SIZE);

        ExecutorService service = Executors.newFixedThreadPool(THREADS_COUNT);

        Future<Boolean> future1 = service.submit(() -> {
            changeElementsByFormula(array1, array1.length);
            return true;
        });

        Future<Boolean> future2 = service.submit(() -> {
            changeElementsByFormula(array2, array2.length);
            return true;
        });

        service.shutdown();

        while (true) {
            try {
                boolean finished = future1.get() && future2.get();

                if (finished) {
                    System.arraycopy(array1, 0, array, 0, HALF_SIZE);
                    System.arraycopy(array2, 0, array, HALF_SIZE, HALF_SIZE);

                    System.out.println(System.currentTimeMillis() - a);

                    break;
                }
            } catch (InterruptedException | ExecutionException exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * changeElementsByFormula(array, length)
     * @param array - массив
     * @param length - количество элементов в массиве
     * Изменяет элементы массива по формуле:
     * result[i] = array[i] * sin(0.2f + i / 5.0f) * cos(0.2f + i / 5.0f) * cos(0.4f + i / 2.0f)
     */
    private static void changeElementsByFormula(final float[] array, int length) {
        for (int i = 0; i < length; i++) {
            array[i] = (float) (array[i] * sin(0.2f + i / 5.0f) * cos(0.2f + i / 5.0f) * cos(0.4f + i / 2.0f));
        }
    }
}
