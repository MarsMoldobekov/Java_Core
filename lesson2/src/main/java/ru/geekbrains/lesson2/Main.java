package ru.geekbrains.lesson2;

import java.util.Arrays;

public class Main {
    private static final int INF = 1_000_000_000;
    private static final int NEGATIVE_INF = -INF;

    public static void main(String[] args) {
        invertArr();
        fillArr();
        changeArr();
        fillDiagonalElements();

        int[] arr = {-100, -500, 0, 54, 9, 1, -1, -9};
        System.out.println("Минимальный элемент массива: " + min(arr));
        System.out.println("Максимальный элемент массива: " + max(arr));

        int[] massive = {2, 2, 2, 1, 2, 2, 10, 1};
        if (checkBalance(massive)) {
            System.out.println("Существует место, в котором сумма левой и правой части массива равны");
        } else {
            System.out.println("Не существует место, в котором сумма левой и правой части массива равны");
        }

        int[] massive2 = {3, 5, 6, 1};
        shiftArr(massive2, -2);
        System.out.println(Arrays.toString(massive2));

        shiftArr(massive2, 3);
        System.out.println(Arrays.toString(massive2));
    }

    //Задание №1
    private static void invertArr() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? 1 : 0;
        }
        System.out.println(Arrays.toString(arr));
    }

    //Задание №2
    private static void fillArr() {
        int[] arrLengthEight = new int[8];
        for (int i = 0; i < arrLengthEight.length; i++) {
            arrLengthEight[i] = i * 3;
        }
        System.out.println(Arrays.toString(arrLengthEight));
    }

    //Задание №3
    private static void changeArr() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //Задание №4
    private static void fillDiagonalElements() {
        int[][] matrix = new int[10][10];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (i == j) ? 1 : 0;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    //Задание №5
    private static int min(int[] arr) {
        int min = INF;
        for (int element : arr) {
            if (element < min) {
                min = element;
            }
        }
        return min;
    }

    private static int max(int[] arr) {
        int max = NEGATIVE_INF;
        for (int element : arr) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    //Задание №6
    private static boolean checkBalance(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int left = sum(arr, 0, i);
            int right = sum(arr, i + 1, arr.length - 1);

            if (left == right) {
                return true;
            }
        }
        return false;
    }

    private static int sum(int[] arr, int begin, int end) {
        int sum = 0;
        for (int i = begin; i <= end; i++) {
            sum += arr[i];
        }
        return sum;
    }

    //Задание №7
    private static void shiftArr(int[] arr, int shift) {
        int size = arr.length;
        shift = normalizeShift(shift, size);
        for (int i = 0; i < shift; i++) {
            int buffer = arr[0];
            arr[0] = arr[size - 1];

            for (int j = 1; j < size - 1; j++) {
                arr[size - j] = arr[size - j - 1];
            }

            arr[1] = buffer;
        }
    }

    private static int normalizeShift(int shift, int size) {
        int finalShift = shift;
        if (finalShift >= size) {
            finalShift %= size;
        } else if (finalShift < 0) {
            do {
                finalShift += size;
            } while (finalShift < 0);
        }
        return finalShift;
    }
}
