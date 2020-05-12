/* Написати код для багатопотокового підрахунку суми елементів
масиву цілих чисел. Порівняти швидкість підрахунку з простим алгоритмом.

* Напишіть багатопотоке сортування масиву методом Шелла. */

package com.ziozyun;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static int[] getRandomArray(int count, int min, int max) {
        int[] randomArray = new int[count];
        int diff = max - min;
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            randomArray[i] = min + random.nextInt(diff + 1);
        }
        return randomArray;
    }

    private static void printArray(int[] array) {
        int count = array.length, lastSeparator = count - 1;
        System.out.print("Array[] = {");
        for (int i = 0; i < count; i++) {
            System.out.print(array[i]);
            if (i < lastSeparator) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    public static int getSumFromArray(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    public static void shell(int[] array) {
        int length = array.length;
        int semi = length / 2;
        while (semi > 0) {
            for (int i = 0; i < length - semi; i++) {
                int j = i;
                while ((j >= 0) && array[j] > array[j + semi]) {
                    int temp = array[j];
                    array[j] = array[j + semi];
                    array[j + semi] = temp;
                    j--;
                }
            }
            semi /= 2;
        }
    }

    private static void sort() {
        long start;
        long end;
        Random rn = new Random();
        int[] array = new int[199_997];
        int semi = array.length / 2;
        int[] part1 = new int[semi];
        int[] part2;
        part2 = new int[semi + 1];

        for (int i = 0; i < array.length; i++) {
            array[i] = rn.nextInt(10);
            if (i < semi) {
                part1[i] = array[i];
            }
            if (i >= semi) {
                part2[i - semi] = array[i];
            }
        }

        try {
            start = System.currentTimeMillis();
            shell(array);
            end = System.currentTimeMillis();
            System.out.println("Single-threaded Shell sorting.\nTime: " + (end - start) + "ms. Array length is " + array.length + "\n");

            start = System.currentTimeMillis();
            MultithreadedShellSorting mss = new MultithreadedShellSorting(part1, part2);
            mss.getThr().join();
            array = mss.getArray();
            end = System.currentTimeMillis();
            System.out.println("Multithreaded Shell sorting.\nTime: " + (end - start) + "ms. Array length is " + array.length);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long time;
        int min = 1, max = 100, countNumbers = 50, threadArrayStep = 10;

        int[] array = getRandomArray(countNumbers, min, max);
        printArray(array);

        time = System.currentTimeMillis();
        System.out.printf("Сума елементів масиву: %d\r\n", getSumFromArray(array));
        System.out.printf("Час затрачений на підрахунок в одному потоці: %s ms.\r\n", (System.currentTimeMillis() - time));

        SumContainer.setSum(0);

        time = System.currentTimeMillis();
        ArrayList<ArraySumThread> arraySumThreads = new ArrayList<>();
        for (int step = 0, i = 0; step < countNumbers; step += threadArrayStep, i++) {
            arraySumThreads.add(new ArraySumThread(array, step, step + threadArrayStep));
            arraySumThreads.get(i).start();
        }

        int threads = 0;
        for (ArraySumThread a : arraySumThreads) {
            a.join();
            threads++;
        }

        System.out.printf("Сума елементів використовуючи потоки [Кількість потоків: %s]: %s\r\n", threads, SumContainer.getSum());
        System.out.printf("Час затрачений на підрахунок [Кількість потоків: %s]: %s ms.\r\n", threads, System.currentTimeMillis() - time);

        sort();
    }
}
