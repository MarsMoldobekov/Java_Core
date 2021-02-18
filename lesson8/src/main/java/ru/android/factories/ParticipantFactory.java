package ru.android.factories;

import ru.android.participants.Cat;
import ru.android.participants.Human;
import ru.android.participants.Participant;
import ru.android.participants.Robot;

public class ParticipantFactory {
    public Participant getParticipant(
            ParticipantType participantType,
            String name,
            int runningRestriction,
            int jumpingRestriction) {

        return switch (participantType) {
            case CAT -> new Cat(name, runningRestriction, jumpingRestriction);
            case HUMAN -> new Human(name, runningRestriction, jumpingRestriction);
            case ROBOT -> new Robot(name, runningRestriction, jumpingRestriction);
            default -> null;
        };
    }
}
