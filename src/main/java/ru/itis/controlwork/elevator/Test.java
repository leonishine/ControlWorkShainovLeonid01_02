package ru.itis.controlwork.elevator;

public class Test {
    public static void main(String[] args) throws NoFreeElevatorsException {
        Elevator[] elevators = {new ElevatorEven(ElevatorState.STAYS), new ElevatorEven(ElevatorState.STAYS), new ElevatorEven(ElevatorState.STAYS), new ElevatorOdd(ElevatorState.STAYS), new ElevatorOdd(ElevatorState.STAYS), new ElevatorOdd(ElevatorState.BROKEN), new ElevatorTeacher(ElevatorState.STAYS)};
        int floors = 16;
        //Процесс - по сути здание, например двойка
        ElevatorsWorkProcess dvoyka = new ElevatorsWorkProcess(floors, elevators);
        dvoyka.process();
    }
}
