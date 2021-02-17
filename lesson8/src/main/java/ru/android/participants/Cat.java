package ru.android.participants;

public class Cat extends Participant {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Кот пробежал.");
    }

    @Override
    public void jump() {
        System.out.println("Кот прыгнул.");
    }
}
