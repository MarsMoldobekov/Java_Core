package ru.android;

import ru.android.race.Race;

public class Main {
    public static void main(String[] args) {
        new Thread(new Race()).start();
    }
}
