package ru.android.obstacles;

public record Wall(int height) implements Obstacle {
    @Override
    public void info() {
        System.out.println(toString());
    }
}
