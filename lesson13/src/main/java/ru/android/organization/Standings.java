package ru.android.organization;

import ru.android.concurrent.SingleReadWriteLock;

import java.util.ArrayList;
import java.util.List;

public class Standings {
    private final SingleReadWriteLock lock;
    private final List<String> standings;

    public Standings() {
        this.lock = SingleReadWriteLock.getInstance();
        this.standings = new ArrayList<>();
    }

    public void writeStandings(String carName) {
        lock.writeLock();
        standings.add(carName);
        lock.writeUnlock();
    }

    public void readStandings() {
        lock.readLock();

        for (int i = 0; i < standings.size(); i++) {
            int position = i + 1;
            System.out.println(position + " место: " + standings.get(i));
        }

        lock.readUnlock();
    }
}
