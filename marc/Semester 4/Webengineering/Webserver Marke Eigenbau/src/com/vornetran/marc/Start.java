package com.vornetran.marc;

import java.net.ServerSocket;
import java.net.Socket;

public class Start {

    private static final int PORT = 80;
    private static final WorkerStrategy STRATEGY = new ThreadStrategy();
    //private static final WorkerStrategy STRATEGY = new PoolStrategy();
    //private static final WorkerStrategy STRATEGY = new BalancerStrategy();
	
	public static void main(String[] args){
		try(ServerSocket server = new ServerSocket(PORT)){
			System.out.println("Server listening on port " + PORT);
			
			for(;;){
				Socket socket = server.accept();
				Handler handler = new Handler(socket);

				STRATEGY.handleRequest(handler);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		System.out.println("Stopped accepting connections");
	}
	
}