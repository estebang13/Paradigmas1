/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paradigmas1;

import Control.Control;
import Vista.Ventana;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ubuntu
 */
public class Paradigmas1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Control control = Control.obtenerInstancia();
        //Ventana ventana1 = new Ventana(control);
        //control.agregarObservable(ventana1);
        Pattern pattern = Pattern.compile("^([^#]*?)\\s+->\\s+(\\.?)(.*)(.|([^#]*?));");
        Pattern pattern1 = Pattern.compile("");
        Matcher m = pattern.matcher("_A Absc -> apple _A;");
        if(m.find()){
            System.out.println("aceptada");
        }else{
            System.out.println("no aceptada");
        }
    }
    
}
