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

        array = changeElementsByFormula(array, array.length);

        System.out.println(System.currentTimeMillis() - a);
    }

    private static void changeArrayAsynchronously() {
        float[] array = new float[SIZE];
        var ref = new Object() {
            float[] array1 = new float[HALF_SIZE];
            float[] array2 = new float[HALF_SIZE];
        };

        for (int i = 0; i < SIZE; i++) {
            array[i] = INIT_VALUE;
        }

        long a = System.currentTimeMillis();

        System.arraycopy(array, 0, ref.array1, 0, HALF_SIZE);
        System.arraycopy(array, HALF_SIZE, ref.array2, 0, HALF_SIZE);

        new Thread(() -> ref.array1 = changeElementsByFormula(ref.array1, ref.array1.length)).start();
        new Thread(() -> ref.array2 = changeElementsByFormula(ref.array2, ref.array2.length)).start();

        System.arraycopy(ref.array1, 0, array, 0, HALF_SIZE);
        System.arraycopy(ref.array2, 0, array, HALF_SIZE, HALF_SIZE);

        System.out.println(System.currentTimeMillis() - a);
    }

    /**
     * changeElementsByFormula(array, length)
     * @param array - массив
     * @param length - количество элементов в массиве
     * @return новый массив, элементы которого получаем с помощью формумы:
     * result[i] = array[i] * sin(0.2f + i / 5.0f) * cos(0.2f + i / 5.0f) * cos(0.4f + i / 2.0f)
     */
    private static float[] changeElementsByFormula(float[] array, int length) {
        float[] result = new float[array.length];

        for (int i = 0; i < length; i++) {
            result[i] = (float) (array[i] * sin(0.2f + i / 5.0f) * cos(0.2f + i / 5.0f) * cos(0.4f + i / 2.0f));
        }

        return result;
    }
}
