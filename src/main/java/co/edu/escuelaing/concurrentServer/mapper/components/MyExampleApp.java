/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.concurrentServer.mapper.components;

import co.edu.escuelaing.concurrentServer.mapper.Mapeo;
import co.edu.escuelaing.concurrentServer.mapper.Component;

/**
 *
 * @author juaco
 */
@Component
public class MyExampleApp {
    
    @Mapeo("/index")
    public Double resultado(){
        return Math.PI;
    }
    
    @Mapeo("/holamundo")
    public String hola(){
        return "Hola";
    }
    
}
