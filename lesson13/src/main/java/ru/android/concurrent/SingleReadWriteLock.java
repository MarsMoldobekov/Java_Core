package ru.android.concurrent;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SingleReadWriteLock {
    private static SingleReadWriteLock instance;
    private final ReadWriteLock lock;

    public SingleReadWriteLock() {
        lock = new ReentrantReadWriteLock();
    }

    public static SingleReadWriteLock getInstance() {
        if (instance == null) {
            instance = new SingleReadWriteLock();
        }

        return instance;
    }

    public void readLock() {
        lock.readLock().lock();
    }

    public void readUnlock() {
        lock.readLock().unlock();
    }

    public void writeLock() {
        lock.writeLock().lock();
    }

    public void writeUnlock() {
        lock.writeLock().unlock();
    }
}
