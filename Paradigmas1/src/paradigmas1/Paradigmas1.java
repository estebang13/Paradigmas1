/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paradigmas1;

import Control.Control;
import Vista.Ventana;

/**
 *
 * @author ubuntu
 */
public class Paradigmas1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Control control = Control.obtenerInstancia();
        Ventana ventana1 = new Ventana(control);
        control.agregarObservable(ventana1);
    }
    
}
