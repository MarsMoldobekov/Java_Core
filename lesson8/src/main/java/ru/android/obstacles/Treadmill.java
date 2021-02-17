package ru.android.obstacles;

public class Treadmill implements Obstacle {
    private final int distance; //meters

    public Treadmill(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public void info() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Treadmill{" +
                "length=" + distance +
                '}';
    }
}
