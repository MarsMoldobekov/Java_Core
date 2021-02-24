package ru.android.obstacles;

public record Treadmill(int distance) implements Obstacle {
    @Override
    public void info() {
        System.out.println(toString());
    }
}
