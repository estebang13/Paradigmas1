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
    private ArrayList<String> alfabeto;
    private ArrayList<String> variables;
    private ArrayList<String> marcadores;
    private static String expresionRegular = "";
    private String entradaSustitucion = "";
    
    
    public Markov1(){
        reglas = new ArrayList<>();
        alfabeto = new ArrayList<>();
        variables = new ArrayList<>();
        marcadores = new ArrayList<>();
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
            for (int j = 0; j < entrada.length(); j++) {
                
            }
        }
        return bandera;
    }
}
