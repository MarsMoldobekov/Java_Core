package ru.geekbrains.lesson2;

public class Main {
    private static final int INF = 1_000_000_000;
    private static final int NEGATIVE_INF = -INF;

    public static void main(String[] args) {
        invertArr();
        fillArr();
        changeArr();
        fillDiagonalElements();

        int[] arr = { -100, -500, 0, 54, 9, 1, -1, -9 };
        System.out.println("Минимальный элемент массива: " + min(arr));
        System.out.println("Максимальный элемент массива: " + max(arr));
    }

    //Задание №1
    private static void invertArr() {
        int[] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? 1 : 0;
            System.out.print(arr[i] + " ");
        }
    }

    //Задание №2
    private static void fillArr() {
        int[] arrLengthEight = new int[8];
        for (int i = 0; i < arrLengthEight.length; i++) {
            arrLengthEight[i] = i * 3;
            System.out.print(arrLengthEight[i] + " ");
        }
    }

    //Задание №3
    private static void changeArr() {
        int[] arr2 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] < 6) {
                arr2[i] *= 2;
            }
            System.out.print(arr2[i] + " ");
        }
    }

    //Задание №4
    private static void fillDiagonalElements() {
        int[][] matrix = new int[10][10];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (i == j) ? 1 : 0;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

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
}
