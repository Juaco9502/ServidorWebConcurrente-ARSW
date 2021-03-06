/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package co.edu.escuelaing.concurrentServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juaco
 */
public class WebServerAdministrator {
    public static Integer threads= 1;
    
    public static void main(String[] args) throws IOException {
        
        SocketConnection sC = new SocketConnection();        
        ServerSocket serverSocket = sC.getServerConnection();
        
        boolean isCompleted=false;
        
        ExecutorService executor = Executors.newFixedThreadPool(threads);
        while (!isCompleted){
            Socket clientSocket = serverSocket.accept();
            executor.execute(new MyWebServer(serverSocket,clientSocket));
        }
        
        try {
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(WebServerAdministrator.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    
    
    static int getPort() {
            if (System.getenv("PORT") != null) {
                return new Integer(System.getenv("PORT"));
            }
            return 35000; //returns default port if heroku-port isn't set (i.e. on localhost)
    } 
    
    
    
}
