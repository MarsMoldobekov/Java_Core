package ru.android.participants;

import ru.android.obstacles.Obstacle;
import ru.android.obstacles.Treadmill;
import ru.android.obstacles.Wall;

public abstract class Participant {
    protected String name;
    protected int runningRestriction;
    protected int jumpingRestriction;

    public Participant(String name, int runningRestriction, int jumpingRestriction) {
        this.name = name;
        this.runningRestriction = runningRestriction;
        this.jumpingRestriction = jumpingRestriction;
    }

    public void info() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                ", runningRestriction=" + runningRestriction +
                ", jumpingRestriction=" + jumpingRestriction +
                '}';
    }

    public void passObstacles(Obstacle[] obstacles) {
        for (Obstacle obstacle : obstacles) {
            if (obstacle instanceof Treadmill) {
                int distance = ((Treadmill) obstacle).getDistance();

                if (checkDistance(distance)) {
                    run(distance);
                } else {
                    System.out.printf("Участник %s не сможет пробежать дистанцию в %dм. " +
                            "Дисквалификация.\n", name, distance);
                    break;
                }
            } else if (obstacle instanceof Wall) {
                int height = ((Wall) obstacle).getHeight();

                if (checkHeight(height)) {
                    jump(height);
                } else {
                    System.out.printf("Участник %s не сможет перепрыгнуть стену высотой в %dм. " +
                            "Дисквалификация.\n", name, height);
                    break;
                }
            }
        }

        System.out.println();
    }

    private boolean checkDistance(int distance) {
        return distance <= runningRestriction;
    }

    private boolean checkHeight(int height) {
        return height <= jumpingRestriction;
    }

    public abstract void run(int length);

    public abstract void jump(int height);
}
