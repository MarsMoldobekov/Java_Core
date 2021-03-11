package ru.android.car;

import ru.android.race.Race;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private final Race race;
    private final int speed;
    private final String name;

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится.");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов.");
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}
