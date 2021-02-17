package ru.android.obstacles;

public class Wall extends Obstacle {
    private final int height; //meters

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void info() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Wall{" +
                "height=" + height +
                '}';
    }
}
