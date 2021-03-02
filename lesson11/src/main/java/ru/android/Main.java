package ru.android;

import ru.android.factories.FruitFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static final FruitFactory factory = new FruitFactory();

    public static void main(String[] args) {

    }

    private static <T> void swap(ArrayList<T> list, int index1, int index2) {
        if (list != null) {
            T obj = list.get(index1);
            list.set(index2, list.get(index1));
            list.set(index2, obj);
        }
    }

    private static <T> ArrayList<T> createArrayList(T[] array) throws NullPointerException {
        return (ArrayList<T>) Arrays.asList(array);
    }
}
