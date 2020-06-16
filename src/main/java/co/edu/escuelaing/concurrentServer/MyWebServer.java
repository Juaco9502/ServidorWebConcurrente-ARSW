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
     MapperAdministrator mA;

    MyWebServer(ServerSocket serverSocket,MapperAdministrator mA) {
        
        this.serverSocket=serverSocket;
        this.mA=mA;
    }
    

    @Override
    public void run() {

            try {
                System.err.println("READY:");
                this.myClientSocket=serverSocket.accept();
            }catch (IOException e) {
                System.err.println("Accept failed.");
            }
            
            
            try {
                
                
                RequestHandler rH = new RequestHandler(myClientSocket);
                DataManager dM = new DataManager();   
                dM.sendResource(rH.getRequest(),myClientSocket,mA);
                
            } catch (IOException ex) {
                Logger.getLogger(MyWebServer.class.getName()).log(Level.SEVERE, null, ex);

        }


        
        
            

 
        
        
    }
       

}
