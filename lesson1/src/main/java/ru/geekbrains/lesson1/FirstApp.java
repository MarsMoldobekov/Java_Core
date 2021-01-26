package ru.geekbrains.lesson1;

public class FirstApp {

    public static void main(String[] args) {
        //Задание №2
        byte b = -1;
        short s = -1;
        int i = -1;
        long l = 10000L;
        float f = -1.3F;
        double d = -1.2;
        char c = ' ';

        System.out.println(calculate(7.5F, 6.0F, -15.9902F, 562F));
        System.out.println(task10and20(5, 9) ? "Yes, 5 + 9 belongs [10, 20]" : "No, 5 + 9 doesn't belong [10, 20]");
        isPositiveOrNegative(i);
        if (isPositive(i)) {
            System.out.println(i + " is positive number");
        } else {
            System.out.println(i + " is negative number");
        }
        greetings("Wolfram");
        isLeap(2021);
    }

    //Задание №3
    private static float calculate(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    //Задание №4
    private static boolean task10and20(int x, int y) {
        int sum = x + y;
        return sum <= 20 && sum >= 10;
    }

    //Задание №5
    private static void isPositiveOrNegative(int x) {
        System.out.println((x >= 0) ? "Положительное" : "Отрицательное");
    }

    //Задание №6
    private static boolean isPositive(int x) {
        return x >= 0;
    }

    //Задание №7
    private static void greetings(String name) {
        System.out.println("Привет, " + name + "!");
    }

    //Задание №8
    private static void isLeap(int year) {
        if (year % 4 != 0 || year % 100 == 0 && year % 400 != 0) {
            System.out.println(year + "г. невисокосный");
        } else {
            System.out.println(year + "г. високосный");
        }
    }
}
