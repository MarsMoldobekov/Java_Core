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
            int[] coordinates;
            char symbol;

            switch (player) {
                case HUMAN -> {
                    coordinates = humanTurn();
                    symbol = DOT_X;
                    player = Player.AI;
                }
                case AI -> {
                    coordinates = aiTurn();
                    symbol = DOT_O;
                    player = Player.HUMAN;
                }
                default -> throw new IllegalStateException("Unexpected value: " + player);
            }

            printMap();

            if (checkWin(coordinates, symbol)) {
                System.out.println("Победа!");
                break;
            }

            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    private static boolean checkWin(int[] coordinates, char symbol) {
        int x = coordinates[0];
        int y = coordinates[1];

        for (int i = 0; i < size; i++) {
            if (map[y][i] != symbol) {
                break;
            }
            if (i + 1 == dotsToWin) {
                return true;
            }
        }

        for (int i = 0; i < size; i++) {
            if (map[i][x] != symbol) {
                break;
            }
            if (i + 1 == dotsToWin) {
                return true;
            }
        }

        if (x == y) {
            for (int i = 0; i < size; i++) {
                if (map[i][i] != symbol) {
                    break;
                }
                if (i + 1 == dotsToWin) {
                    return true;
                }
            }
        }

        if (x + y == size - 1) {
            for (int i = 0; i < size; i++) {
                if (map[i][size - i - 1] != symbol) {
                    break;
                }
                if (i + 1 == dotsToWin) {
                    return true;
                }
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

    private static int[] aiTurn() {
        int x, y;

        do {
            x = random.nextInt(size);
            y = random.nextInt(size);
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
