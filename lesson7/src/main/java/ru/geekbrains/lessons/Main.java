package ru.geekbrains.lessons;

public class Main {

    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Кiт", 5),
                new Cat("Котометр", 5),
                new Cat("Котитзе", 20),
                new Cat("Котан", 10),
                new Cat("Котострофа", 15)
        };

        Plate plate = new Plate(50);

        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat.isFull());
        }

        plate.info();
    }
}
