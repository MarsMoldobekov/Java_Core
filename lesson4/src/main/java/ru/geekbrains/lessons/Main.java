package ru.geekbrains.lessons;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static char[][] map;

    private static int size;
    private static int dotsToWin;

    private static final char DOT_EMPTY = '*';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    /**
     * Хранит количество символов на строках, столбцах, диагоналях
     * Количество элементов 2 * n + 2, n - размер поля
     * Каждый элемент в массиве будет суммой X или O по горизонтали (первые n позиций в массиве),
     * по вертикали (вторые n позиций в массиве) и по диагонали (последние 2 позиции).
     */
    private static int[] sums;

    private static final int ROWS_BEGIN = 0;
    private static final int ROWS_END = 2;
    private static final int COLUMNS_BEGIN = 3;
    private static final int COLUMNS_END = 5;
    private static final int MAIN_DIAGONAL = 6;
    private static final int SIDE_DIAGONAL = 7;

    private enum Player {
        HUMAN, AI
    }

    public static void main(String[] args) {
        init();
        run();
        finish();
    }

    private static void init() {
        System.out.print("1. Карта 3х3. Условие победы - 3 символа подряд.\n" +
                "2. Карта 5х5. Условие победы - 5 символа подряд.\nВаш выбор: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                size = 3;
                dotsToWin = 3;
            }
            case 2 -> {
                size = 5;
                dotsToWin = 5;
            }
            default -> throw new IllegalArgumentException("Illegal argument " + choice);
        }

        sums = new int[2 * size + 2];
        map = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }

        printMap();
    }

    private static void run() {
        Player player = Player.HUMAN;

        while (true) {
            Player previousPlayer = player;

            switch (player) {
                case HUMAN -> {
                    player = Player.AI;
                    humanTurn();
                }
                case AI -> {
                    player = Player.HUMAN;
                    aiTurn();
                }
            }

            printMap();

            if (checkWin(previousPlayer)) {
                System.out.println("Победа!");
                break;
            }

            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    private static boolean checkWin(Player player) {
        int winScore = (player == Player.HUMAN) ? dotsToWin : -dotsToWin;

        for (int sum : sums) {
            if (sum == winScore) {
                return true;
            }
        }

        return false;
    }

    private static boolean isMapFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void aiTurn() {
        int[] coordinates = new int[2];

        if (checkRows(coordinates)) {

        } else if (checkColumns(coordinates)) {

        } else if (checkMainDiagonal(coordinates)) {

        } else if (checkSideDiagonal(coordinates)) {

        } else {
            int row, col;

            do {
                row = random.nextInt(size);
                col = random.nextInt(size);
            } while (!isCellValid(row, col));

            coordinates[0] = row;
            coordinates[1] = col;
        }

        int row = coordinates[0];
        int col = coordinates[1];

        System.out.printf("Компьютер походил в точку %d %d\n", row + 1, col + 1);
        map[row][col] = DOT_O;

        fillSums(coordinates, Player.AI);
    }

    private static boolean checkRows(int[] coordinates) {
        for (int row = ROWS_BEGIN; row <= ROWS_END; row++) {
            if (sums[row] == dotsToWin - 1) {
                for (int col = 0; col < size; col++) {
                    if (isCellValid(row, col)) {
                        coordinates[0] = row;
                        coordinates[1] = col;

                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean checkColumns(int[] coordinates) {
        for (int col = COLUMNS_BEGIN; col <= COLUMNS_END; col++) {
            if (sums[col] == dotsToWin - 1) {
                int colInMap = col - size;
                for (int row = 0; row < size; row++) {
                    if (isCellValid(row, colInMap)) {
                        coordinates[0] = row;
                        coordinates[1] = colInMap;

                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean checkMainDiagonal(int[] coordinates) {
        if (sums[MAIN_DIAGONAL] == dotsToWin - 1) {
            for (int i = 0; i < size; i++) {
                if (isCellValid(i, i)) {
                    coordinates[0] = coordinates[1] = i;

                    return true;
                }
            }
        }

        return false;
    }

    private static boolean checkSideDiagonal(int[] coordinates) {
        if (sums[SIDE_DIAGONAL] == dotsToWin - 1) {
            for (int i = 0; i < size; i++) {
                if (isCellValid(i, size - i - 1)) {
                    coordinates[0] = i;
                    coordinates[1] = size - i - 1;

                    return true;
                }
            }
        }

        return false;
    }

    private static void humanTurn() {
        int row, col;

        do {
            System.out.println("Введите координаты в строка/столбец");

            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        } while (!isCellValid(row, col));

        map[row][col] = DOT_X;

        fillSums(new int[]{row, col}, Player.HUMAN);
    }

    private static void fillSums(int[] coordinates, Player player) {
        int row = coordinates[0];
        int col = coordinates[1];
        int length = sums.length;

        int indexVertical = size + col;
        int indexMainDiagonal = length - 2;
        int indexSideDiagonal = length - 1;

        switch (player) {
            case HUMAN -> {
                sums[row]++;
                sums[indexVertical]++;

                if (row == col) {
                    sums[indexMainDiagonal]++;
                }

                if (row + col == size - 1) {
                    sums[indexSideDiagonal]++;
                }
            }
            case AI -> {
                sums[row]--;
                sums[indexVertical]--;

                if (row == col) {
                    sums[indexMainDiagonal]--;
                }

                if (row + col == size - 1) {
                    sums[indexSideDiagonal]--;
                }
            }
        }
    }

    private static boolean isCellValid(int row, int col) {
        return (col >= 0 && col < size) &&
                (row >= 0 && row < size) &&
                map[row][col] == DOT_EMPTY;
    }

    private static void printMap() {
        for (int i = 0; i <= size; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + " ");

            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }

    private static void finish() {
        scanner.close();
    }
}
