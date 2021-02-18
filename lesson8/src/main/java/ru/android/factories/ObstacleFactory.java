package ru.android.factories;

import ru.android.obstacles.Obstacle;
import ru.android.obstacles.Treadmill;
import ru.android.obstacles.Wall;

public class ObstacleFactory {
    public Obstacle getObstacle(ObstacleType obstacleType, int length) {
        return switch (obstacleType) {
            case TREADMILL -> new Treadmill(length);
            case WALL -> new Wall(length);
        };
    }
}
