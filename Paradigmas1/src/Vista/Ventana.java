/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Modelo;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

/**
 *
 * @author Brayan
 */
public class Ventana extends JFrame implements Observer{

    private Modelo modelo;
    
    public Ventana(Modelo modelo){
        super("Proyecto 1 Paradigmas");
        this.modelo = modelo;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        
    }
    
}
