package ru.geekbrains.lessons.animal;

public class Animal {
    public static int objectAnimalCount;

    protected int runningRestrictions;
    protected int swimmingRestrictions;

    protected String name;

    public Animal(String name) {
        this.name = name;

        objectAnimalCount++;
    }

    public static int count() {
        return objectAnimalCount;
    }

    public String getName() {
        return name;
    }

    public void run(int distance) {
        System.out.printf("%s пробежал %dм.\n", name, distance);
    }

    public void swim(int distance) {
        System.out.printf("%s проплыл %dм.\n", name, distance);
    }
}
