package ru.android.race;

import ru.android.concurrent.SingleSemaphore;
import ru.android.factory.StageFactory;
import ru.android.organization.Organizer;
import ru.android.organization.Standings;
import ru.android.race.stages.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;

import static ru.android.factory.StageType.ROAD;
import static ru.android.factory.StageType.TUNNEL;

public class Race implements Runnable {
    private final SingleSemaphore semaphore;
    private final Organizer organizer;

    private final ArrayList<Stage> stages;
    private final int CARS_COUNT = 5;

    public Race() {
        this.semaphore = SingleSemaphore.getInstance(CARS_COUNT / 2);
        this.stages = (ArrayList<Stage>) createStages();
        this.organizer = new Organizer(stages, CARS_COUNT);
    }

    @Override
    public void run() {
        System.out.println("Важное объявление. Подготовка!");
        organizer.run();
        try {
            organizer.ready();
            System.out.println("Гонка началась!");
            organizer.finish();
            System.out.println("Гонка завершилась.");
        } catch (BrokenBarrierException | InterruptedException e) {
            e.printStackTrace();
        }

        printStandings();
    }

    private void printStandings() {
        organizer.getStandings().readStandings();
    }

    private List<Stage> createStages() {
        final StageFactory stageFactory = new StageFactory();
        List<Stage> stages = new ArrayList<>();

        stages.add(stageFactory.getStage(semaphore, 60, ROAD));
        stages.add(stageFactory.getStage(semaphore, 80, TUNNEL));
        stages.add(stageFactory.getStage(semaphore, 120, ROAD));

        return stages;
    }
}
