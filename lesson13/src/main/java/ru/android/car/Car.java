package ru.android.car;

import ru.android.concurrent.SingleCountDownLatch;
import ru.android.concurrent.SingleCyclicBarrier;
import ru.android.concurrent.SingleSemaphore;
import ru.android.race.stages.Stage;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;

public class Car implements Runnable {
    private SingleCyclicBarrier cyclicBarrier;
    private SingleCountDownLatch countDownLatch;
    private SingleSemaphore semaphore;

    private static int CARS_COUNT;
    private List<Stage> stages;
    private int speed;
    private final String name;

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    private Car() {
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится.");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов.");
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException exception) {
            exception.printStackTrace();
        }

        //TODO --- stage.go(this) with the tunnel
        /*for (Stage stage : stages) {
            stage.go(this);
        }*/

        System.out.println(this.name + " завершил гонку.");
        countDownLatch.countDown();
    }

    public static Builder getBuilder() {
        return new Car().new Builder();
    }

    public class Builder {
        public Builder setSingleCyclicBarrier(final SingleCyclicBarrier cyclicBarrier) {
            Car.this.cyclicBarrier = cyclicBarrier;
            return this;
        }

        public Builder setSingleCountDownLatch(final SingleCountDownLatch countDownLatch) {
            Car.this.countDownLatch = countDownLatch;
            return this;
        }

        public Builder setSingleSemaphore(final SingleSemaphore semaphore) {
            Car.this.semaphore = semaphore;
            return this;
        }

        public Builder setRaceStages(final List<Stage> stages) {
            Car.this.stages = stages;
            return this;
        }

        public Builder setSpeed(int speed) {
            Car.this.speed = speed;
            return this;
        }

        public Car build() {
            return Car.this;
        }
    }
}
