package ru.android.basket;

import ru.android.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Basket<T extends Fruit> {
    private final ArrayList<T> basket;

    public Basket() {
        basket = new ArrayList<>();
    }

    public List<T> getBasket() {
        return basket;
    }

    public void putFromBasket(Basket<? extends T> basket) {
        if (basket != null) {
            this.basket.addAll(basket.basket);
            basket.basket.clear();
        }
    }

    public void addFruit(List<? extends T> fruits) {
        if (fruits != null) {
            basket.addAll(fruits);
        }
    }

    public boolean compare(Basket<?> basket) {
        return basket != null && getWeight() == basket.getWeight();
    }

    public float getWeight() {
        return basket.size() * basket.get(0).getWeight();
    }
}
