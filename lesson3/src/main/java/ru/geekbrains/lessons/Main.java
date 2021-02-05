package ru.geekbrains.lessons;

import java.util.Random;
import java.util.Scanner;

import org.jetbrains.annotations.NotNull;

public class Main {

    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    private static final String HELP_WORD_INIT = "###############";

    public static void main(String[] args) {
        boolean flag = true;

        do {
            String message = "Здравствуйте. В какую игру хотите сыграть?\n" +
                    "1 - \"Угадай число\"\n" +
                    "2 - \"Угадай слово\"\n" +
                    "3 - выйти.\n" +
                    "Ваш выбор: ";
            System.out.print(message);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Запуск игры \"Угадай число\".");
                    guessTheNumber();
                }
                case 2 -> {
                    System.out.println("Запуск игры \"Угадай слово\".");
                    guessTheWord();
                }
                case 3 -> {
                    System.out.println("Программа завершила свою работу.");
                    flag = false;
                }
            }
        } while (flag);

        scanner.close();
    }

    private static void guessTheNumber() {
        int secretNumber;
        int userNumber;
        int attempts;
        int repeatRequest;

        System.out.println("Программа загадывает число от 0 до 9 включительно.\n" +
                "Пользователю необходимо угадать это число за 3 попытки");

        do {
            attempts = 3;

            secretNumber = random.nextInt(10);
            System.out.println("Компьютер загадал число.");

            do {
                System.out.print("Ваш вариант: ");
                userNumber = scanner.nextInt();

                if (userNumber == secretNumber) {
                    System.out.println("\nИ это правильный ответ. Поздравляю!");
                    break;
                } else {
                    attempts--;

                    if (attempts == 0) {
                        System.out.printf("Ответ неправельный. Загаданное число = %d. " +
                                "К сожалению, у вас закончились попытки.", secretNumber);
                        break;
                    }

                    StringBuilder builder = new StringBuilder();

                    builder.append("Ответ неправельный. ")
                            .append(String.format("Осталось %d попыток. ", attempts));

                    if (secretNumber < userNumber) {
                        builder.append("ПОДСКАЗКА: ваше число больше загаданного.");
                    } else {
                        builder.append("ПОДСКАЗКА: ваше число меньше загаданного.");
                    }

                    System.out.println(builder.toString());
                }
            } while (true);

            System.out.print("Повторить игру ещё раз? 1 - да/ 0 - нет.\nВаш ответ: ");

            repeatRequest = scanner.nextInt();

            if (repeatRequest == 0) {
                System.out.println("\nИгра завершина.");
                break;
            } else if (repeatRequest == 1) {
                System.out.println("\nИгра продолжается.");
            }
        } while (true);
    }

    private static void guessTheWord() {
        String[] words = {
                "apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"
        };

        int index = random.nextInt(words.length);
        String secretWord = words[index];
        String userWord;
        String helpWord = HELP_WORD_INIT;

        System.out.println("Программа загадывает слово.\n" +
                "Игра не закончится, пока пользователь не угадает это слово.");

        do {
            System.out.print("Ваш вариант: ");
            userWord = scanner.next();

            if (userWord.equals(secretWord)) {
                System.out.println("Слово отгадано. Поздравляю!");
                break;
            }

            helpWord = writeHelpWord(secretWord, userWord, helpWord);
            System.out.println("Ответ неправельный. ПОДСКАЗКА: " + helpWord);
        } while (true);
    }

    @NotNull
    private static String writeHelpWord(String secretWord, String userWord, String helpWord) {
        StringBuilder builder = new StringBuilder(helpWord);

        int secretWordLength = secretWord.length();
        int userWordLength = userWord.length();

        for (int i = 0; i < secretWordLength && i < userWordLength; i++) {
            char c1 = secretWord.charAt(i);
            char c2 = userWord.charAt(i);

            if (c1 == c2) {
                builder.setCharAt(i, c1);
            }
        }

        return builder.toString();
    }
}
