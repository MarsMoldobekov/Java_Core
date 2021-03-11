package ru.android.race.stages;

import ru.android.car.Car;

public abstract class Stage {
    protected int length;
    protected String description;

    public String getDescription() {
        return description;
    }

    public abstract void go(Car car);
}
