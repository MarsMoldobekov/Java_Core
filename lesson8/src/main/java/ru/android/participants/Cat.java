package ru.android.participants;

public class Cat extends Participant {
    public Cat(String name, int runningRestriction, int jumpingRestriction) {
        super(name, runningRestriction, jumpingRestriction);
    }

    @Override
    public void run(int distance) {
        System.out.printf("Кот %s пробежал дистанцию в %dм. Поздравляю.\n", name, distance);
    }

    @Override
    public void jump(int height) {
        System.out.printf("Кот %s перепрыгнул стену высотой в %dм. Поздравляю.\n", name, height);
    }
}
