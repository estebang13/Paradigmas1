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

    public void aplicarAlgoritmo() {
        for (Regla regla : listaReglas) {
            m1 = regexMarks.matcher(entrada);
            m2 = regexMarks.matcher(regla.getInicio());
            boolean banderaM1 = m1.find();
            boolean banderaM2 = m2.find();
            if (banderaM1 && banderaM2) {
                for (int i = 0; i < regla.getInicio().length(); i++) {
                    String palabra = String.valueOf(regla.getInicio().charAt(i));
                    if (regexMarks.matcher(palabra).find()) {
                        if (entrada.contains(palabra)) {
                            boolean bandera = aplicarRega(regla, i);

                        }
                    }
                }
            }
            if (!banderaM2) {
            }

        }

    }

    public boolean aplicarRega(Regla regla, int posMarca) {
        boolean bandera = false;
        int posMarcaEntrada = -1;
        for (int i = 0; i < entrada.length(); i++) {
            if (entrada.charAt(i) == regla.getInicio().charAt(posMarca)) {
                posMarcaEntrada = i;
                break;
            }
        }
        if (posMarcaEntrada != -1) {
            int tamEntrada = entrada.length();
            int tamRegla = regla.getInicio().length();
            if (((posMarcaEntrada - posMarca) >= 0)
                    && ((posMarcaEntrada + ((tamRegla - 1) - posMarca)) < tamEntrada)) {
                listaVariables = new ArrayList<>();
                for (int i = posMarcaEntrada - posMarca, j = 0; i < (posMarcaEntrada + (tamRegla - posMarca)); i++, j++) {
                    listaVariables.add(new Variable(String.valueOf(regla.getInicio().charAt(j)),
                            String.valueOf(entrada.charAt(i))));
                }
                if (comprobarVariables()) {

                }
            }

        }
        return bandera;
    }

    public boolean comprobarVariables() {
        boolean bandera = true;
        int j = 0;
        for (Variable variable : listaVariables) {
            m1 = regexMarks.matcher(variable.getVar());
            if (m1.find()) {
                if (!variable.getVar().equals(variable.getValor())) {
                    bandera = false;
                    break;
                }
            } else {
                for (int i = j + 1; i < listaVariables.size(); i++) {
                    if (variable.getVar().equals(listaVariables.get(i).getVar())) {
                        if (!variable.getValor().equals(listaVariables.get(i).getValor())) {
                            bandera = false;
                            break;
                        }
                    }
                }
            }
            j++;
        }
        return bandera;
    }
}
