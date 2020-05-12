package com.ziozyun;

public class SumContainer {
    private static int sum = 0;

    public static synchronized void setSum(int sum) {
        SumContainer.sum = sum;
    }

    public static synchronized void addToSum(int number) {
        SumContainer.sum += number;
    }

    public static synchronized int getSum() {
        return sum;
    }
}
