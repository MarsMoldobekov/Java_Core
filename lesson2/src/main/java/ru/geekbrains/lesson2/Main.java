package ru.geekbrains.lesson2;

public class Main {

    public static void main(String[] args) {
        invertArr();
        fillArr();
        changeArr();
        fillDiagonalElements();
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
    public static void changeArr() {
        int[] arr2 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] < 6) {
                arr2[i] *= 2;
            }
            System.out.print(arr2[i] + " ");
        }
    }

    //Задание №4
    public static void fillDiagonalElements() {
        int[][] matrix = new int[10][10];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (i == j) ? 1 : 0;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
