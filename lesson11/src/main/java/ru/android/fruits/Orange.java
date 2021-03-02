package ru.android.fruits;

public class Orange extends Fruit {
    public Orange() {
        weight = 1.5F;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "weight=" + weight +
                '}';
    }
}
