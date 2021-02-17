package ru.android.participants;

import ru.android.obstacles.Obstacle;
import ru.android.obstacles.Treadmill;

public abstract class Participant {
    protected String name;

    public Participant(String name) {
        this.name = name;
    }

    public void passObstacles(Obstacle[] obstacles) {
        for (Obstacle obstacle : obstacles) {
            if (obstacle instanceof Treadmill) {
                jump();
            } else {
                run();
            }
        }
    }

    public abstract void run();

    public abstract void jump();
}
