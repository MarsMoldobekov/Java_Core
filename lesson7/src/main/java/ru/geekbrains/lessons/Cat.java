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

    public void printCat() {
        System.out.println(toString());
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
