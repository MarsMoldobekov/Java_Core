package ru.android.participants;

import ru.android.obstacles.Obstacle;

public interface Participant {
    void passObstacles(Obstacle[] obstacles);

    boolean checkDistance(int distance);
    boolean checkHeight(int height);

    void run(int distance);
    void jump(int height);
}
