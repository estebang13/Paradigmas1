/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Modelo;
import java.util.Observer;

/**
 *
 * @author ubuntu
 */
public class Control {

    private static Control control;
    private Modelo modelo;

    private Control() {
        this.modelo = Modelo.obtenerInstancia();
    }

    public static Control obtenerInstancia() {
        return (control == null) ? control = new Control() : control;
    }

    public void agregarObservable(Observer o) {
        modelo.addObserver(o);
    }
}
