package ru.geekbrains.lessons;

public class Cat {
    private final String name;
    private final int appetite;

    private boolean isFull;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isFull = false;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", isFull=" + isFull +
                '}';
    }

    public String isFull() {
        if (isFull) {
            return "Кот " + name + " ссыт.";
        } else {
            return "Кот " + name + " голоден.";
        }
    }

    public void eat(Plate plate) {
        if (isFull) {
            return;
        }

        if (isEnough(plate)) {
            plate.decreaseFood(appetite);
            isFull = true;
        }
    }

    private boolean isEnough(Plate plate) {
        return appetite <= plate.getFood();
    }
}
