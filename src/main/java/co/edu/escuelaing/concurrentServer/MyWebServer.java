/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.concurrentServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juaco
 */
public class MyWebServer implements Runnable{

  
     Socket myClientSocket;
     ServerSocket serverSocket;
   

    MyWebServer(ServerSocket serverSocket) {
    
        this.serverSocket=serverSocket;
    }

    MyWebServer(ServerSocket serverSocket, Socket clientSocket) {
        this.serverSocket = serverSocket;
        this.myClientSocket = clientSocket;
    }
    

    @Override
    public void run() {                   
            try {
                
                
                RequestHandler rH = new RequestHandler(myClientSocket);
                DataManager dM = new DataManager();   
                dM.sendResource(rH.getRequest(),myClientSocket);
                myClientSocket.close();
                
            } catch (IOException ex) {
                Logger.getLogger(MyWebServer.class.getName()).log(Level.SEVERE, null, ex);

        }       
    }
       
}
