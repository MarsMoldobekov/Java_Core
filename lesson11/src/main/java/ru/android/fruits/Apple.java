package ru.android.fruits;

public class Apple extends Fruit {
    public Apple() {
        weight = 1.0F;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }
}
