package ru.geekbrains.lessons;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static char[][] map;

    private static final int SIZE = 3;
    private static final int DOTS_TO_WIN = 3;

    private static final char DOT_EMPTY = '*';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    public static void main(String[] args) {
        int[] coordinates;

        initMap();
        printMap();

        while (true) {
            coordinates = humanTurn();
            if (checkWin(coordinates, DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            coordinates = aiTurn();
            printMap();
            if (checkWin(coordinates, DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
        scanner.close();
    }

    private static boolean checkWin(int[] coordinates, char symbol) {
        int x = coordinates[0];
        int y = coordinates[1];

        for (int i = 0; i < SIZE; i++) {
            if (map[y][i] != symbol) {
                break;
            }
            if (i + 1 == DOTS_TO_WIN) {
                return true;
            }
        }

        for (int i = 0; i < SIZE; i++) {
            if (map[i][x] != symbol) {
                break;
            }
            if (i + 1 == DOTS_TO_WIN) {
                return true;
            }
        }

        if (x == y) {
            for (int i = 0; i < SIZE; i++) {
                if (map[i][i] != symbol) {
                    break;
                }
                if (i + 1 == DOTS_TO_WIN) {
                    return true;
                }
            }
        }

        if (x + y == SIZE - 1) {
            for (int i = 0; i < SIZE; i++) {
                if (map[i][SIZE - i - 1] != symbol) {
                    break;
                }
                if (i + 1 == DOTS_TO_WIN) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] aiTurn() {
        int x, y;

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (isCellValid(x, y));

        System.out.printf("Компьютер походил в точку %d %d\n", (x + 1), (y + 1));
        map[y][x] = DOT_O;

        return new int[] {x, y};
    }

    private static int[] humanTurn() {
        int x, y;

        do {
            System.out.println("Введите координаты в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (isCellValid(x, y));

        map[y][x] = DOT_X;

        return new int[] {x, y};
    }

    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return true;
        if (map[y][x] == DOT_EMPTY) return false;
        return true;
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
