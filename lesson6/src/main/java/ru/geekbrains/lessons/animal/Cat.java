package ru.geekbrains.lessons.animal;

public class Cat extends Animal {
    public static int objectCatCount;

    public Cat(String name) {
        super(name);
        swimmingRestrictions = 0;
        runningRestrictions = 200;
        objectCatCount++;
    }

    @Override
    public void run(int distance) {
        if (distance > runningRestrictions) {
            System.out.printf("%s пробежать %dм не может.\n", name, distance);
        } else {
            System.out.printf("%s пробежал %dм.\n", name, distance);
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Коты плавать не умеют.");
    }
}
