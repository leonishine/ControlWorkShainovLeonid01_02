package ru.itis.controlwork.elevator;

public class ElevatorTeacher extends Elevator {
    private static final Situation type = Situation.TEACHER;

    public ElevatorTeacher(ElevatorState state) {
        this.elevatorState = state;
    }

    public Situation getType() {
        return type;
    }

    @Override
    public void step(ElevatorState state) {
        if (currentFloor == destinationFloor) {
            destinationFloor = null;
            elevatorState = ElevatorState.STAYS;
        }

        if (currentFloor == 1 && destinationFloor != null) {
            elevatorState = ElevatorState.GOESUP;
        }

        if (elevatorState == ElevatorState.GOESUP) {
            ++currentFloor;
        }

        if (elevatorState == ElevatorState.GOESDOWN) {
            --currentFloor;
        }
    }
}
