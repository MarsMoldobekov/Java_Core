package ru.android.participants;

public class Human extends Participant {
    public Human(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Человек пробежал.");
    }

    @Override
    public void jump() {
        System.out.println("Человек прыгнул.");
    }
}
