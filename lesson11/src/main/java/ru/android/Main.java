package ru.android;

import ru.android.basket.Basket;
import ru.android.factories.FruitFactory;
import ru.android.fruits.Apple;
import ru.android.fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

import static ru.android.factories.FruitType.*;

public class Main {
    private static final FruitFactory factory = new FruitFactory();

    private static final int NUMBER_OF_FRUIT = 10;

    public static void main(String[] args) {
        // Apple basket
        Basket<Apple> appleBasket = new Basket<>();
        ArrayList<Apple> fruitArrayList = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_FRUIT; i++) {
            fruitArrayList.add((Apple) factory.getFruit(APPLE));
        }

        appleBasket.addFruit(fruitArrayList);
        System.out.println(appleBasket.getBasket());

        // orange basket
        Basket<Orange> orangeBasket = new Basket<>();
        ArrayList<Orange> orangeArrayList = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_FRUIT; i++) {
            orangeArrayList.add((Orange) factory.getFruit(ORANGE));
        }

        orangeBasket.addFruit(orangeArrayList);
        System.out.println(orangeBasket.getBasket());

        // comparing apple and orange baskets
        System.out.println(appleBasket.compareTo(orangeBasket));

        // putting fruits from one basket to another
        Basket<Apple> secondAppleBasket = new Basket<>();
        secondAppleBasket.putFromBasket(appleBasket);

        System.out.println(appleBasket.getBasket());
        System.out.println(secondAppleBasket.getBasket());
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
