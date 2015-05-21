package com.vornetran.marc;

import java.net.Socket;

/**
 * Created by Marc on 21.05.2015.
 */
public class ThreadStrategy implements WorkerStrategy {

    @Override
    public void handleRequest(Handler handler){
        Thread thread = new Thread(handler);

        System.out.println("Starting thread " + thread.hashCode());
        thread.start();
    }

}
