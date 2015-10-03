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
public class Gramatica {

    private String id;
    private static final String ALFABETOFINAL = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final String VARIABLESFINAL = "wxyz";
    private static final String MARCADORES = "αβγδ";
    private Pattern ExprGrieg = Pattern.compile("[Α-ω]");
    private String alfabeto = "";
    private String variables = "";
    private String marcadores = "";
    private ArrayList<Regla> reglas;

    public Gramatica(String id) {
        this.id = id;
        this.reglas = new ArrayList<>();
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

    public ArrayList<Regla> getReglas() {
        return reglas;
    }

    public void setReglas(ArrayList<Regla> reglas) {
        this.reglas = reglas;
    }
    
    public boolean comprobarGramatica(String original) {
        boolean cumple = true;
        String[] vec = original.split("\n");
        for (int i = 0; i < vec.length; i++) {
            if (!vec[i].equals("")) {
                if (vec[i].contains("#symbols")) {
                    alfabeto = vec[i].substring(8);
                    System.out.println("contiene secuencia y alfabeto es: " + alfabeto);
                }
                if (vec[i].contains("#vars")) {
                    variables = vec[i].substring(5);
                    System.out.println("contiene secuencia y variables son: " + variables);
                }
                if (vec[i].contains("#markers")) {
                    marcadores = vec[i].substring(8);
                    System.out.println("contiene secuencia y marcadores son: " + marcadores);
                }
                if ((!marcadores.equals("")) && (!alfabeto.equals("")) && (!variables.equals(""))) {
                    break;
                }
            }
        }
        if (alfabeto.equals("")) {
            alfabeto = ALFABETOFINAL;
        }
        if (variables.equals("")) {
            variables = VARIABLESFINAL;
        }
        if (marcadores.equals("")) {
            marcadores = MARCADORES;
        }

        Matcher m = ExprGrieg.matcher(alfabeto);
        if (!m.find()) {
            m = ExprGrieg.matcher(variables);
            if (!m.find()) {
                for (int i = 0; i < variables.length(); i++) {
                    if (!alfabeto.contains(String.valueOf(variables.charAt(i)))) {
                        cumple = false;
                        break;
                    }
                }
                if (cumple) {
                    Pattern alfa = Pattern.compile("[a-z0-9]");
                    m = alfa.matcher(marcadores);
                    if (!m.find()) {
                        //m = alfa.matcher(marcadores);////////////////////////////////////////////7
                        for (int i = 0; i < vec.length; i++) {
                            if (!vec[i].equals("")) {
                                if ((!vec[i].contains("#symbols")) && (!vec[i].contains("#vars"))
                                        && (!vec[i].contains("#markers"))) {
                                    System.out.println(vec[i]);
                                    String[] reg = vec[i].split("→");
                                    reglas.add(new Regla(reg[0], reg[1]));
                                }
                            }
                        }
                    } else {
                        cumple = false;
                    }
                }
            } else {
                cumple = false;
            }
        } else {
            cumple = false;
        }
        for (int i = 0; i < reglas.size(); i++) {
            System.out.println("reglas "+ i +" "+reglas.get(i).getInicio()+" -> "+
                    reglas.get(i).getTrans());
        }
        return cumple;
    }
}
