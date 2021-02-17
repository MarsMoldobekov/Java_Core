package ru.android.participants;

public class Human extends Participant {
    public Human(String name, int runningRestriction, int jumpingRestriction) {
        super(name, runningRestriction, jumpingRestriction);
    }

    @Override
    public void run(int distance) {
        System.out.printf("Человек %s пробежал дистанцию в %dм. Поздравляю.\n", name, distance);
    }

    @Override
    public void jump(int height) {
        System.out.printf("Человек %s перепрыгнул стену высотой в %dм. Поздравляю.\n", name, height);
    }
}
