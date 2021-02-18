package ru.android;

import ru.android.factories.ObstacleFactory;
import ru.android.factories.ParticipantFactory;
import ru.android.obstacles.Obstacle;
import ru.android.participants.Participant;

import static ru.android.factories.ObstacleType.*;
import static ru.android.factories.ParticipantType.*;

public class Main {
    private static final ObstacleFactory obstacleFactory = new ObstacleFactory();
    private static final ParticipantFactory participantFactory = new ParticipantFactory();

    public static void main(String[] args) {
        Participant[] participants = {
                participantFactory.getParticipant(HUMAN, "Пётр", 150, 2),
                participantFactory.getParticipant(ROBOT, "Тесла", 200, 0),
                participantFactory.getParticipant(HUMAN, "Катерина", 150, 2),
                participantFactory.getParticipant(ROBOT, "Андроид", 200, 0),
                participantFactory.getParticipant(CAT, "Лео", 100, 3)
        };

        Obstacle[] obstacles = {
                obstacleFactory.getObstacle(WALL, 1),
                obstacleFactory.getObstacle(TREADMILL, 60),
                obstacleFactory.getObstacle(WALL, 2),
                obstacleFactory.getObstacle(TREADMILL, 100),
                obstacleFactory.getObstacle(WALL, 3),
                obstacleFactory.getObstacle(TREADMILL, 120)
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
