package ru.android.race.stages;

import ru.android.car.Car;

public class Tunnel extends Stage {
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров.";
    }

    @Override
    public void go(Car car) {
        try {
            System.out.println(car.getName() + " готовится к этапу(ждёт): " + description);
            System.out.println(car.getName() + " начал этап: " + description);
            Thread.sleep(length / car.getSpeed() * 1000L);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        } finally {
            System.out.println(car.getName() + " закончил этап.");
        }
    }
}
