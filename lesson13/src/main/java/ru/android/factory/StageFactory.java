package ru.android.factory;

import ru.android.concurrent.SingleSemaphore;
import ru.android.race.stages.Road;
import ru.android.race.stages.Stage;
import ru.android.race.stages.Tunnel;

public class StageFactory {
    public Stage getStage(SingleSemaphore semaphore, int length, StageType stageType) {
        return switch (stageType) {
            case TUNNEL -> new Tunnel(semaphore, length);
            case ROAD -> new Road(semaphore, length);
        };
    }
}
