/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Observable;

/**
 *
 * @author Brayan
 */
public class Modelo extends Observable {

    private static Modelo modelo;

    private Modelo() {

    }

    public static Modelo obtenerInstancia() {
        return (modelo == null) ? modelo = new Modelo() : modelo;
    }

    public void actualizar() {
        setChanged();
        notifyObservers();
    }
}
