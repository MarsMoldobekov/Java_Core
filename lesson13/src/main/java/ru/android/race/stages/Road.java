package ru.android.race.stages;

import ru.android.race.car.Car;
import ru.android.concurrent.SingleSemaphore;

public class Road extends Stage {
    public Road(SingleSemaphore semaphore, int length) {
        super(semaphore, length);
        this.description = "Дорога " + length + " метров.";
    }

    @Override
    public void go(Car car) {
        try {
            System.out.println(car.getName() + " начал этап: " + description);
            Thread.sleep(length / car.getSpeed() * 1000L);
            System.out.println(car.getName() + " закончил этап: " + description);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}
