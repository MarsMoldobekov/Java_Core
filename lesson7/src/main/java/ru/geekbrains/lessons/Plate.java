package ru.geekbrains.lessons;

public class Plate {
    private final int CAPACITY = 100;
    private int food;

    public Plate(int food) {
        int temp = food;

        if (temp > CAPACITY) {
            temp = CAPACITY;
        }

        this.food = temp;
    }

    public int getFood() {
        return food;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "CAPACITY=" + CAPACITY +
                ", food=" + food +
                '}';
    }

    public void decreaseFood(int food) {
        changeFood(food, false);
    }

    public void addFood(int food) {
        changeFood(food, true);
    }

    private void changeFood(int food, boolean whetherToAdd) {
        int temp = this.food;

        if (whetherToAdd) {
            temp += food;

            if (temp > CAPACITY) {
                temp = CAPACITY;
            }
        } else {
            temp -= food;

            if (temp < 0) {
                temp = 0;
            }
        }

        this.food = temp;
    }
}
