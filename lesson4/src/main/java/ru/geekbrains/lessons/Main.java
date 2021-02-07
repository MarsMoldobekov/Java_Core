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

    private enum Player {
        HUMAN, AI
    }

    public static void main(String[] args) {
        init();
        printMap();
        run();

        scanner.close();
    }

    private static void init() {
        System.out.print("1. Карта 3х3. Условие победы - 3 символа подряд.\n" +
                "2. Карта 5х5. Условие победы - 4 символа подряд.\nВаш выбор: ");

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
        }

        sums = new int[2 * size + 2];
        map = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
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
        int x, y;

        do {
            x = random.nextInt(size);
            y = random.nextInt(size);
        } while (isCellValid(x, y));

        System.out.printf("Компьютер походил в точку %d %d\n", (x + 1), (y + 1));
        map[y][x] = DOT_O;

        fillSums(new int[]{x, y}, Player.AI);
    }

    private static void humanTurn() {
        int x, y;

        do {
            System.out.println("Введите координаты в формате X Y");

            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (isCellValid(x, y));

        map[y][x] = DOT_X;

        fillSums(new int[]{x, y}, Player.HUMAN);
    }

    private static void fillSums(int[] coordinates, Player player) {
        int x = coordinates[0];
        int y = coordinates[1];
        int length = sums.length;

        int indexVertical = size + x;
        int indexMainDiagonal = length - 2;
        int indexSideDiagonal = length - 1;

        switch (player) {
            case HUMAN -> {
                sums[y]++;
                sums[indexVertical]++;

                if (x == y) {
                    sums[indexMainDiagonal]++;
                }

                if (x + y == size - 1) {
                    sums[indexSideDiagonal]++;
                }
            }
            case AI -> {
                sums[y]--;
                sums[indexVertical]--;

                if (x == y) {
                    sums[indexMainDiagonal]--;
                }

                if (x + y == size - 1) {
                    sums[indexSideDiagonal]--;
                }
            }
        }
    }

    private static boolean isCellValid(int x, int y) {
        return !((x >= 0 && x < size) &&
                (y >= 0 && y < size) &&
                map[y][x] == DOT_EMPTY);
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
}
