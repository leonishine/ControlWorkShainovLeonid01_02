package ru.itis.controlwork.elevator;
/*
2. Абстрактный класс, описывающие  лифт, реализующий интерфейс п.1, с атрибутами:
состояние, текущий этаж (1 вначале и для неисправного), этаж назначения (может быть null);
наследники: лифт для четных этажей, лифт для нечетных этажей, лифт для сотрудников
 */



public abstract class Elevator implements IElevatorState, IStep{
    protected ElevatorState elevatorState;
    protected int currentFloor = 1;
    protected Integer destinationFloor = null;
    protected Situation type;

    public ElevatorState state() {
        return elevatorState;
    }

    public void setState(ElevatorState state) {
        this.elevatorState = state;
    }

    public Situation getType() {
        return type;
    }

    public void setDestinationFloor(Integer destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public void step() {
        if (destinationFloor != null && currentFloor == destinationFloor) {
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
