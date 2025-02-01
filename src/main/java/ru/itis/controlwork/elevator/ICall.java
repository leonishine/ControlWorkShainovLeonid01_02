package ru.itis.controlwork.elevator;

public interface ICall {
    /*
    3. Интерфейс Вызов, описывающий вызов лифта, в зависимости от ситуации
    (Перечисление: нужен четный этаж, нечетный, сотрудник), этаж назначения
    Все вызовы осуществляются с 1-го этажа
     */
    void call(Situation situation, int destination, Elevator[] elevators) throws NoFreeElevatorsException;
}
