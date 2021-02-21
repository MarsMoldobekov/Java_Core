package ru.geekbrains.lessons;

public class Main {

    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Барсик", 5),
                new Cat("Леопольд", 5),
                new Cat("Том", 20),
                new Cat("Масяня", 10),
                new Cat("Гарфилд", 15)
        };

        Plate plate = new Plate(50);

        makeCatsToEat(cats, plate);
        System.out.println(plate.toString());

        plate.addFood(10);

        makeCatsToEat(cats, plate);
        System.out.println(plate.toString());
    }

    private static void makeCatsToEat(Cat[] cats, Plate plate) {
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat.isFull());
        }
    }
}
