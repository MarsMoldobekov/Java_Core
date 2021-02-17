package ru.android;

import ru.android.obstacles.Obstacle;
import ru.android.obstacles.Treadmill;
import ru.android.obstacles.Wall;
import ru.android.participants.Cat;
import ru.android.participants.Human;
import ru.android.participants.Participant;
import ru.android.participants.Robot;

public class Main {
    public static void main(String[] args) {
        Participant[] participants = {
                new Human("Пётр"),
                new Robot("Тесла"),
                new Human("Катерина"),
                new Robot("Андроид"),
                new Cat("Лео")
        };

        Obstacle[] obstacles = {
                new Wall(1),
                new Treadmill(60),
                new Wall(2),
                new Treadmill(100),
                new Wall(3),
                new Treadmill(120)
        };

        for (Participant participant : participants) {
            participant.passObstacles(obstacles);
        }
    }
}
