package ru.itis.controlwork.elevator;

public class Call implements ICall  {
    public void call(Situation situation, int destination, Elevator[] elevators) throws NoFreeElevatorsException {
        boolean flag = false;
        for (int i = 0; i < elevators.length; i++) {
            if (elevators[i].getType() == situation && elevators[i].state() == ElevatorState.STAYS) {
                elevators[i].setState(ElevatorState.GOESDOWN);
                elevators[i].setDestinationFloor(destination);
                flag = true;
                break;
            }
        }

        if (!flag) {
            throw new NoFreeElevatorsException();
        }
    }
}
