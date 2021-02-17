package ru.android.obstacles;

public class Treadmill extends Obstacle {
    private final int length; //meters

    public Treadmill(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void info() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Treadmill{" +
                "length=" + length +
                '}';
    }
}
