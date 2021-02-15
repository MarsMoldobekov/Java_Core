package ru.geekbrains.lessons.animal;

public class Dog extends Animal {
    private static int objectDogCount;

    public Dog(String name) {
        super(name);
        swimmingRestrictions = 10;
        runningRestrictions = 500;
        objectDogCount++;
    }

    public static int getObjectDogCount() {
        return objectDogCount;
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
        if (distance > swimmingRestrictions) {
            System.out.printf("%s проплыть %dм не может.\n", name, distance);
        } else {
            System.out.printf("%s проплыл %dм.\n", name, distance);
        }
    }
}
