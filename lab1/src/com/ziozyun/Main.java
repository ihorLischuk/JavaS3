/* Створіть сто потоків які будуть обчислювати факторіал числа
рівного номеру цього потоку і виводити результат на екран.*/

package com.ziozyun;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 100; i++) {
            BigInteger n = BigInteger.valueOf(i);
            new FactorialThread(n).start();
        }
    }
}
