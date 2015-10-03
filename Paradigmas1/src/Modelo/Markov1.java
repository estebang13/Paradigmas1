/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Brayan
 */
public class Markov1 {

    private ArrayList<Regla> listaReglas;
    private ArrayList<Variable> listaVariables;
    private String alfabeto;
    private String variables;
    private String marcadores;

    public Markov1() {
        this.listaReglas = new ArrayList<>();
        this.listaVariables = new ArrayList<>();
        this.alfabeto = "";
        this.variables = "";
        this.marcadores = "";
    }

    public ArrayList<Regla> getListaReglas() {
        return listaReglas;
    }

    public void setListaReglas(ArrayList<Regla> listaReglas) {
        this.listaReglas = listaReglas;
    }

    public ArrayList<Variable> getListaVariables() {
        return listaVariables;
    }

    public void setListaVariables(ArrayList<Variable> listaVariables) {
        this.listaVariables = listaVariables;
    }

    public String getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(String alfabeto) {
        this.alfabeto = alfabeto;
    }

    public String getVariables() {
        return variables;
    }

    public void setVariables(String variables) {
        this.variables = variables;
    }

    public String getMarcadores() {
        return marcadores;
    }

    public void setMarcadores(String marcadores) {
        this.marcadores = marcadores;
    }
    
    public void iniciarListaVariables(){
        for (int i = 0; i < variables.length(); i++) {
            listaVariables.add(new Variable(String.valueOf(variables.charAt(i)), ""));
        }
    }
}
