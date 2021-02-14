package ru.geekbrains.lessons;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.printf("В тарелке осталось %s еды.\n", food);
    }

    public boolean isEnough(int n) {
        return food >= n;
    }

    public void decreaseFood(int n) {
        food -= n;

        if (food < 0) {
            food = 0;
        }
    }

    public void addFood(int n) {
        food += n;
    }
}
