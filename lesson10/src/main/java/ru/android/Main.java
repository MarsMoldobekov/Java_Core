package ru.android;

import java.io.*;
import java.util.*;

public class Main {
    private static final int SIZE = 3;

    private static final String[] lastNames = {
            "Ivanov", "Petrov", "Karpov"
    };

    private static final String[][] numbers = {
            {"+5(099)83-09", "+5(097)87-10", "+5(777)33-39"},
            {"+999(078)00-09", "+999(078)87-10", "+999(490)44-39"},
            {"+0-4500-09-45", "+0-4500-10-99", "+0-4900-44-39"}
    };

    public static void main(String[] args) {
        ArrayList<String> array = readFile("./lesson10/src/main/java/ru/android/Test.txt");
        System.out.println(deleteDuplicates(array));
        countDuplicates(array);

        Phonebook phonebook = new Phonebook();

        for (int i = 0; i < SIZE; i++) {
            for (String number : numbers[i]) {
                phonebook.add(lastNames[i], number);
            }
        }

        for (int i = 0; i < SIZE; i++) {
            System.out.println(phonebook.getNumbers(lastNames[i]));
        }
    }

    private static ArrayList<String> readFile(String file) {
        ArrayList<String> array = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                array.add(String.valueOf(reader.readLine()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return array;
    }

    private static Set<String> deleteDuplicates(ArrayList<String> array) {
        return new HashSet<>(array);
    }

    private static void countDuplicates(ArrayList<String> arrayList) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : arrayList) {
            int i = map.getOrDefault(word, 0) + 1;
            map.put(word, i);
        }

        for (Map.Entry<String, Integer> entry: map.entrySet()){
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }
    }
}
