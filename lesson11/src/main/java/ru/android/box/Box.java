package ru.android.box;

import ru.android.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final ArrayList<T> box;

    public Box() {
        box = new ArrayList<>();
    }

    public List<T> getBox() {
        return box;
    }
}
