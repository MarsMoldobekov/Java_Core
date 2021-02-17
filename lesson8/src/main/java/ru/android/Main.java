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
                new Human("Пётр", 150, 2),
                new Robot("Тесла", 200, 0),
                new Human("Катерина", 125, 2),
                new Robot("Андроид", 300, 0),
                new Cat("Лео", 100, 3)
        };

        Obstacle[] obstacles = {
                new Wall(1),
                new Treadmill(60),
                new Wall(2),
                new Treadmill(100),
                new Wall(3),
                new Treadmill(120)
        };

        printParticipantsInfo(participants);
        printObstaclesInfo(obstacles);

        runChallenge(participants, obstacles);
    }

    private static void printParticipantsInfo(Participant[] participants) {
        for (Participant participant : participants) {
            participant.info();
        }

        System.out.println();
    }

    private static void printObstaclesInfo(Obstacle[] obstacles) {
        for (Obstacle obstacle : obstacles) {
            obstacle.info();
        }

        System.out.println();
    }

    private static void runChallenge(Participant[] participants, Obstacle[] obstacles) {
        for (Participant participant : participants) {
            participant.passObstacles(obstacles);
        }
    }
}
