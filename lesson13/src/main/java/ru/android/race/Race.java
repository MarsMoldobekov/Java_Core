package ru.android.race;

import ru.android.race.stages.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    private final ArrayList<Stage> stages;

    public Race(Stage ... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    public ArrayList<Stage> getStages() {
        return stages;
    }
}