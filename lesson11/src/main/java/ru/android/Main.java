package ru.android;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

    }

    private static <T> void swap(ArrayList<T> list, int index1, int index2) {
        T obj = list.get(index1);
        list.set(index2, list.get(index1));
        list.set(index2, obj);
    }

    private static <T> ArrayList<T> createArrayList(T[] array) {
        return (ArrayList<T>) Arrays.asList(array);
    }
}
