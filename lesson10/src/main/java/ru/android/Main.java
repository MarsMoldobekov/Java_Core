package ru.android;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> array = readFile("./lesson10/src/main/resources/Test.txt");
        System.out.println(deleteDuplicates(array));
        countDuplicates(array);
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
            if (map.containsKey(word)) {
                Integer i = map.get(word) + 1;
                map.put(word, i);
            } else {
                map.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> entry: map.entrySet()){
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }
    }
}
