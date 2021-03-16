package ru.android.race.stages;

import ru.android.race.car.Car;
import ru.android.concurrent.SingleSemaphore;

public abstract class Stage {
    protected final SingleSemaphore semaphore;
    protected int length;
    protected String description;

    public Stage(SingleSemaphore semaphore, int length) {
        this.semaphore = semaphore;
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public abstract void go(Car car);
}
