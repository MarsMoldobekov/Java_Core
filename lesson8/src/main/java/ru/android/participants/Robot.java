package ru.android.participants;

public class Robot extends Participant {
    public Robot(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Робот пробежал.");
    }

    @Override
    public void jump() {
        System.out.println("Робот прыгнул.");
    }
}
