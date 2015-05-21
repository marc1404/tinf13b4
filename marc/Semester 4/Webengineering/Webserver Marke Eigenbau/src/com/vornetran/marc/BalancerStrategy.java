package com.vornetran.marc;

import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Marc on 21.05.2015.
 */
public class BalancerStrategy implements WorkerStrategy {

    private ExecutorService workerPool = Executors.newCachedThreadPool();

    @Override
    public void handleRequest(Handler handler) {
        Future future = workerPool.submit(handler);

        System.out.println("Request submitted to pool " + future.hashCode());
    }

}
