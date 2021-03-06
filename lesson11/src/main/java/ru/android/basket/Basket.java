package ru.android.basket;

import org.jetbrains.annotations.NotNull;
import ru.android.fruits.Fruit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket<T extends Fruit> implements Comparable<Basket<?>> {
    private final ArrayList<T> basket;

    public Basket() {
        basket = new ArrayList<>();
    }

    public List<T> getBasket() {
        return Collections.unmodifiableList(basket);
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

    public float getWeight() {
        return basket.size() * basket.get(0).getWeight();
    }

    @Override
    public int compareTo(@NotNull Basket<?> basket) {
        return (int) (getWeight() - basket.getWeight());
    }
}
