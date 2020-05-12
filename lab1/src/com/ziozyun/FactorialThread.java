package com.ziozyun;

import java.math.BigInteger;

public class FactorialThread extends Thread {
    private BigInteger number;

    FactorialThread(BigInteger number) throws Exception {
        if (number.compareTo(BigInteger.valueOf(0)) < 0) {
            throw new Exception(String.format("Число %d < 1", number));
        }
        this.number = number;
    }

    public void run() {
        System.out.printf("[%s] factorial(%s) = %s\r\n", this.getName(), number, this.getFactorial(number));
    }

    private BigInteger getFactorial(BigInteger n) {
        BigInteger result = BigInteger.ONE;

        while (!n.equals(BigInteger.ZERO)) {
            result = result.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }

        return result;
    }
}
