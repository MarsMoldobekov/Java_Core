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

    public void info() {
        String info = "Кот: " + name +
                "\nАппетит: " + appetite;
        System.out.println(info);
    }

    public String isFull() {
        String catName = "Кот " + name;
        return isFull ? catName + " ссыт." : catName + " голоден.";
    }

    public void eat(Plate plate) {
        if (plate.isEnough(appetite)) {
            plate.decreaseFood(appetite);
            isFull = true;
        }
    }
}
