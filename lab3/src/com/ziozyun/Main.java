/* Реалізуйте процес багатопотокового пошуку файлу в файловії системі.
Тобто ви вводите назву файлу і в якій частини файлової системи його шукати.
програма повинна вивести на екран всі адреси в файлової системі файлів з такою назвою. */

package com.ziozyun;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        String find = "unins000.dat";
        File path = new File("D:/Games");
        Manager search = new Manager(find, path);
    }
}
