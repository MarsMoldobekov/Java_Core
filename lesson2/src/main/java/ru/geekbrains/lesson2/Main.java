package ru.geekbrains.lesson2;

public class Main {

    public static void main(String[] args) {
        //Задание №1
        int[] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? 1 : 0;
            System.out.print(arr[i] + " ");
        }

        //Задание №2
        int[] arrLengthEight = new int[8];
        for (int i = 0; i < arrLengthEight.length; i++) {
            arrLengthEight[i] = i * 3;
            System.out.println(arrLengthEight[i] + " ");
        }

        //Задание №3
        int[] arr2 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] < 6) {
                arr2[i] *= 2;
            }
        }

        //Задание №4
        int[][] matrix = new int[10][10];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (i == j) ? 1 : 0;
            }
        }
    }
}
