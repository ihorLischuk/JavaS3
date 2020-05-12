package com.ziozyun;

public class ArraySumThread extends Thread {
    private int[] array;
    private int startIndex, endIndex;

    ArraySumThread(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = startIndex; i < endIndex; i++) {
            sum += array[i];
        }
        SumContainer.addToSum(sum);
    }
}
