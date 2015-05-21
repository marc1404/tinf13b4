package com.vornetran.marc;

import com.vornetran.marc.beans.Counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Marc on 21.05.2015.
 */
public class Start {

    public static void main(String[] args){
        Counter counter = new Counter();
        ExecutorService thread1 = Executors.newSingleThreadExecutor();
        ExecutorService thread2 = Executors.newSingleThreadExecutor();
        Runnable task1 = createTask(counter, "thread1");
        Runnable task2 = createTask(counter, "thread2");

        thread1.submit(task1);
        thread2.submit(task2);
    }

    private static Runnable createTask(Counter counter, String name){
        return () -> {
            for(int i = 0; i < 10; i++){
                counter.increase();
                System.out.println(name + " " + counter.getCounter());
            }
        };
    }

}
