package ru.android.participants;

import ru.android.obstacles.Obstacle;
import ru.android.obstacles.Treadmill;
import ru.android.obstacles.Wall;

public class Robot implements Participant {
    private final String name;
    private final int runningRestriction; //meters
    private final int jumpingRestriction; //meters

    public Robot(String name, int runningRestriction, int jumpingRestriction) {
        this.name = name;
        this.runningRestriction = runningRestriction;
        this.jumpingRestriction = jumpingRestriction;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", runningRestriction=" + runningRestriction +
                ", jumpingRestriction=" + jumpingRestriction +
                '}';
    }

    @Override
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

    @Override
    public void run(int distance) {
        System.out.printf("Робот %s пробежал дистанцию в %dм. Поздравляю.\n", name, distance);
    }

    @Override
    public void jump(int height) {
        System.out.printf("Робот %s перепрыгнул стену высотой в %dм. Поздравляю.\n", name, height);
    }

    @Override
    public boolean checkDistance(int distance) {
        return distance <= runningRestriction;
    }

    @Override
    public boolean checkHeight(int height) {
        return height <= jumpingRestriction;
    }
}
