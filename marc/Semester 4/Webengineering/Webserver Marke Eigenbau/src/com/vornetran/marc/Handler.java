package com.vornetran.marc;

import java.io.*;
import java.net.Socket;

/**
 * Created by Marc on 21.05.2015.
 */
public class Handler implements Runnable {

    private final String CONTENT_START = "HTTP/1.1 200 OK\r\nContent-Type: text/html; charset=UTF-8\r\n\r\n<!doctype><html><head><meta charset='utf-8'><title>Hello World!</title></head><body><h1>Hello World!</h1><h2>Sie sind der ";
    private final String CONTENT_END = ". Besucher.</h2></body></html>";
    private Socket socket;

    public Handler(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try{
            handleRequest();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    private void handleRequest() throws IOException {
        System.out.println("- - - BEGIN REQUEST - - -");
        Visitors.count();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        readHeaders(in);
        sendResponse(out);
        socket.close();
        System.out.println("- - - END REQUEST - - -");
    }

    private void readHeaders(BufferedReader in) throws IOException {
        String line;

        while ((line = in.readLine()) != null) {
            System.out.println(line);

            if (line.isEmpty()) {
                break;
            }
        }
    }

    private void sendResponse(BufferedWriter out) throws IOException {
        out.write(CONTENT_START);
        out.write("" + Visitors.get());
        out.write(CONTENT_END);
        out.flush();
    }

}
