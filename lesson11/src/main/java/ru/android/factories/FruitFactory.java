package ru.android.factories;

import ru.android.fruits.Apple;
import ru.android.fruits.Fruit;
import ru.android.fruits.Orange;

public class FruitFactory {
    public Fruit getFruit(FruitType fruitType) {
        return switch (fruitType) {
            case APPLE -> new Apple();
            case ORANGE -> new Orange();
        };
    }
}
