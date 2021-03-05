package ru.android;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Main {
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

        for (int i = 0; i < SIZE; i++) {
            array[i] = (float) (array[i] * sin(0.2f + i / 5.0f) * cos(0.2f + i / 5.0f) * cos(0.4f + i / 2.0f));
        }

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

        new Thread(() -> {
            for (int i = 0; i < HALF_SIZE; i++) {
                array1[i] = (float) (array1[i] * sin(0.2f + i / 5.0f) * cos(0.2f + i / 5.0f) * cos(0.4f + i / 2.0f));
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < HALF_SIZE; i++) {
                array2[i] = (float) (array2[i] * sin(0.2f + i / 5.0f) * cos(0.2f + i / 5.0f) * cos(0.4f + i / 2.0f));
            }
        }).start();

        System.arraycopy(array1, 0, array, 0, HALF_SIZE);
        System.arraycopy(array2, 0, array, HALF_SIZE, HALF_SIZE);

        System.out.println(System.currentTimeMillis() - a);
    }
}
