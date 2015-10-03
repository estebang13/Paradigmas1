/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Brayan
 */
public class Modelo extends Observable {

    private static Modelo modelo;
    private Markov1 markov;
    private Gramatica gramatica;

    private Modelo() {
        //gramaticas = new ArrayList<>();
        gramatica = new Gramatica("1");
        markov = new Markov1();
    }

    public static Modelo obtenerInstancia() {
        return (modelo == null) ? modelo = new Modelo() : modelo;
    }
    
    public Gramatica getGramatica(){
        return gramatica;
    }
    
    public boolean comprobarGramatica(String original){
        boolean bandera = gramatica.comprobarGramatica(original);
        if(bandera){
            markov.setAlfabeto(gramatica.getAlfabeto());
            markov.setMarcadores(gramatica.getMarcadores());
            markov.setVariables(gramatica.getVariables());
            markov.iniciarListaVariables();
        }
        return bandera;
    }
    
    public void aplicarAlgoritmo(String entrada){
        markov.setEntrada(entrada);
        markov.aplicarAlgoritmo();
    }

    public String getEntradaModificada() {
        return markov.getEntrada();
    }

    public void actualizar() {
        setChanged();
        notifyObservers();
    }
}
