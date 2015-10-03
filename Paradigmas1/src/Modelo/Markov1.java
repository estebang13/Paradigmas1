/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Brayan
 */
public class Markov1 {
    
    private ArrayList<String> reglas;
    private String alfabeto;
    private String variables;
    private String marcadores;
    
    
    public Markov1(){
    }
    
    public void aplicarAlgoritmo(String entrada){
        boolean bandera = true;
        while(bandera){
           bandera = aplicarRegla(entrada);
        }
    }
    
    public boolean aplicarRegla(String entrada){
        boolean bandera = false;
        int i = 0;
        for (String regla : reglas) {
            int tamanioRegla = regla.length();
            i=0;
            while(i+3!=entrada.length()){
            }
        }
        return bandera;
    }
}
