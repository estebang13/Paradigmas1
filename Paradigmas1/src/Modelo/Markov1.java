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
    private ArrayList<Variable> listaVariablesTransi;
    private String alfabeto;
    private String variables;
    private String marcadores;
    private String entrada;
    private Pattern regexAlfa;
    private Pattern regexMarks;
    private Pattern regexLambda = Pattern.compile("[Λλ]");
    private Matcher m1;
    private Matcher m2;
    private boolean reglaFinal;

    public Markov1() {
        this.listaReglas = new ArrayList<>();
        this.alfabeto = "";
        this.variables = "";
        this.marcadores = "";
        this.entrada = "";
        this.reglaFinal = false;
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
        for (int j = 0; j < listaReglas.size(); j++) {
            Regla regla = listaReglas.get(j);
            m1 = regexMarks.matcher(entrada);
            m2 = regexMarks.matcher(regla.getInicio());
            boolean banderaM1 = m1.find();
            boolean banderaM2 = m2.find();
            if (banderaM1 && banderaM2) {
                for (int i = 0; i < regla.getInicio().length(); i++) {
                    String palabra = String.valueOf(regla.getInicio().charAt(i));
                    if (regexMarks.matcher(palabra).find()) {
                        if (entrada.contains(palabra)) {
                            boolean bandera = aplicarReglaMark(regla, i);
                            if (bandera) {
                                j = -1;
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println("algoritmo final: " + entrada);
            if (reglaFinal) {
                reglaFinal = false;
                break;
            }
            if (!banderaM2) {
                boolean bandera = aplicarReglaSinMark(regla);
                if (bandera) {
                    j = -1;
                }
            }
            System.out.println("algoritmo final: " + entrada);
            if (reglaFinal) {
                reglaFinal = false;
                break;
            }

        }
        System.out.println("algoritmo final: " + entrada);

    }

    public boolean aplicarReglaMark(Regla regla, int posMarca) {
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
                    listaVariablesTransi = new ArrayList<>();
                    String aux = aplicarTransitividad(regla);
                    String entradaModificada = entrada.substring(0, (posMarcaEntrada - posMarca))
                            + aux + entrada.substring((posMarcaEntrada + (tamRegla - posMarca)));
                    entrada = entradaModificada;
                    bandera = true;
                }
            }

        }
        return bandera;
    }

    public boolean aplicarReglaSinMark(Regla regla) {
        boolean bandera = false;
        int posMarcaEntrada = -1;
        listaVariables = new ArrayList<>();
        for (int i = 0; i < entrada.length(); i++) {
            if (i + (regla.getInicio().length() - 1) < entrada.length()) {
                String auxSub = entrada.substring(i, i + regla.getInicio().length());
                if (!regexMarks.matcher(auxSub).find()) {
                    for (int j = 0; j < auxSub.length(); j++) {
                        listaVariables.add(new Variable(String.valueOf(regla.getInicio().charAt(j)),
                                String.valueOf(auxSub.charAt(j))));
                    }
                    if (comprobarVariables()) {
                        listaVariablesTransi = new ArrayList<>();
                        String aux = aplicarTransitividad(regla);
                        String entradaModificada = entrada.substring(0, i)
                                + aux + entrada.substring(i + auxSub.length());
                        entrada = entradaModificada;
                        bandera = true;
                        break;
                    } else {
                        listaVariables = new ArrayList<>();
                    }
                } else {
                    i += (regla.getInicio().length() - 1);
                }
            } else {
                break;
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

    public String aplicarTransitividad(Regla regla) {
        String aux = "";
        for (int i = 0; i < regla.getTrans().length(); i++) {
            listaVariablesTransi.add(new Variable(String.valueOf(regla.getTrans().charAt(i)), ""));
        }
        // asignarValores a las variables de la transitividad
        for (Variable variableTrans : listaVariablesTransi) {
            if (regexLambda.matcher(variableTrans.getVar()).find()) {
                for (Variable variable : listaVariables) {
                    if (!regexMarks.matcher(variableTrans.getVar()).find()) {
                        aux += variable.getValor();
                        break;
                    }
                }
            } else {
                if (!regexMarks.matcher(variableTrans.getVar()).find()) {
                    if (!variableTrans.getVar().equals(".")) {
                        for (Variable variable : listaVariables) {
                            if (variableTrans.getVar().equals(variable.getVar())) {
                                variableTrans.setValor(variable.getValor());
                                aux += variableTrans.getValor();
                                break;
                            }
                        }
                    } else {
                        reglaFinal = true;
                    }
                } else {
                    variableTrans.setValor(variableTrans.getVar());
                    aux += variableTrans.getValor();
                }
            }
        }
        return aux;
    }
}
