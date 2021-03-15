package ru.android.race;

import ru.android.car.Car;
import ru.android.concurrent.SingleCountDownLatch;
import ru.android.concurrent.SingleCyclicBarrier;
import ru.android.concurrent.SingleSemaphore;
import ru.android.race.stages.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Math.random;

public class Race implements Runnable {
    private final ExecutorService executorService;
    private final SingleCyclicBarrier cyclicBarrier;
    private final SingleCountDownLatch countDownLatch;
    private final SingleSemaphore semaphore;

    private final ArrayList<Stage> stages;
    private final ArrayList<Car> cars;

    private final int CARS_COUNT = 5;
    private final int THREADS_COUNT = CARS_COUNT;

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        this.executorService = Executors.newFixedThreadPool(THREADS_COUNT);
        this.cyclicBarrier = SingleCyclicBarrier.getInstance(THREADS_COUNT + 1);
        this.countDownLatch = SingleCountDownLatch.getInstance(THREADS_COUNT);
        this.semaphore = SingleSemaphore.getInstance(THREADS_COUNT / 2);
        this.cars = (ArrayList<Car>) createCars();
    }

    private List<Car> createCars() {
        List<Car> cars = new ArrayList<>(CARS_COUNT);

        for (int i = 0; i < CARS_COUNT; i++) {
            Car car = Car.getBuilder()
                    .setSingleCyclicBarrier(cyclicBarrier)
                    .setSingleCountDownLatch(countDownLatch)
                    .setSingleSemaphore(semaphore)
                    .setRaceStages(getStages())
                    .setSpeed(20 + (int) (random() * 10))
                    .build();

            cars.add(car);
        }

        return cars;
    }

    public List<Stage> getStages() {
        return Collections.unmodifiableList(stages);
    }

    @Override
    public void run() {
        System.out.println("Важное объявление. Подготовка!");

        for (int i = 0; i < THREADS_COUNT; i++) {
            executorService.execute(cars.get(i));
        }

        try {
            cyclicBarrier.await();
            System.out.println("Гонка началась!");
            countDownLatch.await();
            System.out.println("Гонка завершилась.");
        } catch (BrokenBarrierException | InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
