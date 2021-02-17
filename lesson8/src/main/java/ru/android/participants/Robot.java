package ru.android.participants;

public class Robot extends Participant {
    public Robot(String name, int runningRestriction, int jumpingRestriction) {
        super(name, runningRestriction, jumpingRestriction);
    }

    @Override
    public void run(int distance) {
        System.out.printf("Робот %s пробежал дистанцию в %dм. Поздравляю.\n", name, distance);
    }

    @Override
    public void jump(int height) {
        System.out.printf("Робот %s перепрыгнул стену высотой в %dм. Поздравляю.\n", name, height);
    }
}
