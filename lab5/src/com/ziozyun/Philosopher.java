package com.ziozyun;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

class Philosopher extends Thread
{
    Semaphore sem;
    int num = 0;
    int id;

    Philosopher(Semaphore sem, int id)
    {
        this.sem=sem;
        this.id=id;
    }

    public void run()
    {
        try
        {
            while(num < 3)
            {
                sem.acquire();
                System.out.printf ("Філософ %s сідає за стіл\r\n", id);
                sleep(500);
                num++;

                System.out.printf ("Філософ %s встає із-за стола\r\n", id);
                sem.release();
                sleep(500);
            }
        }
        catch(InterruptedException e)
        {
            System.out.println (Arrays.toString(e.getStackTrace()));
        }
    }
}