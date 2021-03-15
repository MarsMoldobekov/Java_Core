package ru.android;

import ru.android.race.Race;
import ru.android.race.stages.Road;
import ru.android.race.stages.Tunnel;

public class Main {
    public static void main(String[] args) {
        new Thread(new Race(new Road(60), new Tunnel(80), new Road(120))).start();
    }
}
