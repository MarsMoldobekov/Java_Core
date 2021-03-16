package ru.android.race.stages;

import ru.android.race.car.Car;
import ru.android.concurrent.SingleSemaphore;

public class Tunnel extends Stage {
    public Tunnel(SingleSemaphore semaphore, int length) {
        super(semaphore, length);
        this.description = "Тоннель " + length + " метров.";
    }

    @Override
    public void go(Car car) {
        try {
            System.out.println(car.getName() + " готовится к этапу(ждёт): " + description);
            semaphore.acquire();
            System.out.println(car.getName() + " начал этап: " + description);
            Thread.sleep(length / car.getSpeed() * 1000L);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        } finally {
            System.out.println(car.getName() + " закончил этап: " + description);
            semaphore.release();
        }
    }
}
