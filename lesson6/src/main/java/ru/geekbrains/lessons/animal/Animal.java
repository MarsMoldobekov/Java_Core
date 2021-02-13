package ru.geekbrains.lessons.animal;

public abstract class Animal {
    protected int runningRestrictions;
    protected int swimmingRestrictions;

    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);
}
