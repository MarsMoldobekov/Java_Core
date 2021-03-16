package ru.android.organization;

import ru.android.concurrent.SingleCountDownLatch;
import ru.android.concurrent.SingleCyclicBarrier;
import ru.android.race.car.Car;
import ru.android.race.stages.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Math.random;

public class Organizer {
    private final ExecutorService executorService;
    private final SingleCyclicBarrier cyclicBarrier;
    private final SingleCountDownLatch countDownLatch;
    private final Standings standings;

    private final ArrayList<Car> cars;
    private final ArrayList<Stage> stages;

    private final int CARS_COUNT;

    public Organizer(List<Stage> stages, int CARS_COUNT) {
        this.CARS_COUNT = CARS_COUNT;
        this.executorService = Executors.newFixedThreadPool(CARS_COUNT);
        this.cyclicBarrier = SingleCyclicBarrier.getInstance(CARS_COUNT + 1);
        this.countDownLatch = SingleCountDownLatch.getInstance(CARS_COUNT);
        this.standings = new Standings();
        this.stages = (ArrayList<Stage>) stages;
        this.cars = (ArrayList<Car>) createCars();
    }

    public Standings getStandings() {
        return standings;
    }

    public void run() {
        for (Car car : cars) {
            executorService.execute(car);
        }
    }

    public void ready() throws BrokenBarrierException, InterruptedException {
        cyclicBarrier.await();
    }

    public void finish() throws InterruptedException {
        countDownLatch.await();
        executorService.shutdown();
    }

    private List<Car> createCars() {
        List<Car> cars = new ArrayList<>(CARS_COUNT);

        for (int i = 0; i < CARS_COUNT; i++) {
            Car car = Car.getBuilder()
                    .setSingleCyclicBarrier(cyclicBarrier)
                    .setSingleCountDownLatch(countDownLatch)
                    .setRaceStages(stages)
                    .setStandings(standings)
                    .setSpeed(20 + (int) (random() * 10))
                    .build();

            cars.add(car);
        }

        return cars;
    }
}
