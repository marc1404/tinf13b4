package com.vornetran.marc;

import java.net.Socket;

/**
 * Created by Marc on 21.05.2015.
 */
public interface WorkerStrategy {

    void handleRequest(Handler handler);

}
