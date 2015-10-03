/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private String entrada;
    private Pattern regexAlfa;
    private Pattern regexMarks;
    private Matcher m1;
    private Matcher m2;

    public Markov1() {
        this.listaReglas = new ArrayList<>();
        this.listaVariables = new ArrayList<>();
        this.alfabeto = "";
        this.variables = "";
        this.marcadores = "";
        this.entrada = "";
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
        regexAlfa = Pattern.compile("[" + alfabeto + "]");
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
        regexMarks = Pattern.compile("[" + marcadores + "]");
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public void iniciarListaVariables() {
        for (int i = 0; i < variables.length(); i++) {
            listaVariables.add(new Variable(String.valueOf(variables.charAt(i)), ""));
        }
    }

    public void aplicarAlgoritmo() {
        for (Regla regla : listaReglas) {
            m1 = regexMarks.matcher(entrada);
            m2 = regexMarks.matcher(regla.getInicio());
            boolean banderaM1 = m1.find();
            boolean banderaM2 = m2.find();
            if (banderaM1 && banderaM2) {
                if (entrada.length() <= regla.getInicio().length()) {
                    for (int j = 0; j < entrada.length(); j++) {
                    }
                } else {
                    for (int j = 0; j < regla.getInicio().length(); j++) {
                    }
                }
            }
            if (!banderaM2) {
            }

        }

    }
}
