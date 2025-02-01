package ru.itis.controlwork.elevator;

public class ElevatorsWorkProcess {
    private int floors;
    private Elevator[] elevators;

    public ElevatorsWorkProcess(int floors, Elevator[] elevators) {
        this.floors = floors;
        this.elevators = elevators;
    }
    /*
    Класс описывающий динамику процесса работы лифтов, запустить 10000 итераций,
    на каждой 20-й осуществлять вызов на случайный этаж, в обработке исключения
    выводить в консоль ошибку с описанием типа лифта и заказанного этажа.
     */

    public void process() throws NoFreeElevatorsException {
        Call caller = new Call();

        for (int i = 0; i < 10000; i++) {
            if (i%20 == 0) {

                int destEven = (int) (Math.random() * (floors/2) + 1) * 2;
                int destOdd = (int) (Math.random() * (floors/2) + 1) * 2 - 1;
                int destTeacher = (int) (Math.random() * floors + 1);
                /*
                if ((int) (Math.random()*5) < 4) {
                    if (dest%2 == 0) {
                        Situation situation = Situation.EVEN;
                    } else {
                        Situation situation = Situation.ODD;
                    }
                } else {
                    Situation situation
                */
                try {
                    caller.call(Situation.EVEN, destEven, elevators);
                } catch (NoFreeElevatorsException e1) {
                    System.out.println("Нет свободных нечётных лифтов, ожидайте");
                }

                try {
                    caller.call(Situation.ODD, destOdd, elevators);
                } catch (NoFreeElevatorsException e2) {
                    System.out.println("Нет свободных чётных лифтов, ожидайте");
                }

                try {
                    caller.call(Situation.TEACHER, destTeacher, elevators);
                } catch (NoFreeElevatorsException e3) {
                    System.out.println("Нет свободных преподавательских лифтов, ожидайте");
                }

            } else {
                for (int j = 0; j < elevators.length; j++) {
                    elevators[j].step();
                }
            }
        }
    }
}
