/* Существуют три корабля. На каждом из них 10 ящиков груза. Они одновременно прибыли
в порт в котором только два дока. Скорость разгрузки 1 ящик в 0.5 сек. Напишите программу
которая управляя кораблями позволит им правильно разгрузить груз. */

package com.ziozyun;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Dock[] docks = {
            new Dock("Перша коробка", 0),
            new Dock("Друга коробка", 0)
        };

        Ship shipOne = new Ship("Перший корабель", 10, docks);
        Ship shipTwo = new Ship("Другий корабель", 10, docks);
        Ship shipThree = new Ship("Третій корабель", 10, docks);

        ExecutorService dock = Executors.newFixedThreadPool(2);
        dock.execute(shipOne);
        dock.execute(shipTwo);
        dock.execute(shipThree);
        dock.shutdown();
    }
}
