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
    private String bug = "";

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
        bug = "";
        boolean cumple = true;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == '%') {
                while (original.charAt(i) != '\n') {
                    i++;
                }
            } else {
                if (original.charAt(i) == '#') {
                    String valor = "";
                    while (original.charAt(i) != '\n') {
                        valor += original.charAt(i);
                        i++;
                    }
                    if (valor.contains("#symbols")) {
                        String[] aux = valor.split("#symbols");
                        bug += "Estos son los simbolos ";
                        valor = "";
                        for (int j = 0; j < aux[1].length(); j++) {
                            if (aux[1].charAt(j) != ' ') {
                                valor += aux[1].charAt(j);
                            }
                        }
                        bug += valor + "\n";
                        this.alfabeto = valor;
                    } else {
                        if (valor.contains("#vars")) {
                            String[] aux = valor.split("#vars");
                            bug += "Estas son las variables ";
                            valor = "";
                            for (int j = 0; j < aux[1].length(); j++) {
                                if (aux[1].charAt(j) != ' ') {
                                    valor += aux[1].charAt(j);
                                }
                            }
                            bug += valor + "\n";
                            this.variables = valor;
                        } else {
                            if (valor.contains("#markers")) {
                                String[] aux = valor.split("#markers");
                                bug += "Estos son los marcadores ";
                                valor = "";
                                for (int j = 0; j < aux[1].length(); j++) {
                                    if (aux[1].charAt(j) != ' ') {
                                        valor += aux[1].charAt(j);
                                    }
                                }
                                bug += valor + "\n";
                                this.marcadores = valor;
                            }
                        }
                    }
                } else {
                    if (original.charAt(i) != ' ' && original.charAt(i) != '\n') {
                        String aux = "";
                        try {
                            while (original.charAt(i) != ';') {
                                if (original.charAt(i) != ' ' && original.charAt(i) != '\n') {
                                    aux += original.charAt(i);
                                }
                                i++;
                            }
                            aux += original.charAt(i);
                            cumple = crearRegla(aux);
                            if (!cumple) {
                                break;
                            }
                        } catch (Exception ex) {
                            cumple = false;
                        }
                    }
                }
            }
        }
        if (cumple) {
            for (Regla regla : reglas) {
                bug += "regla: " + regla.toString();
            }
        }
        Matcher m = ExprGrieg.matcher(alfabeto);
        if ((!m.find()) && cumple) {
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
                    if (alfa.matcher(marcadores).find()) {
                        cumple = false;
                    }
                }
            } else {
                cumple = false;
            }
        } else {
            cumple = false;
        }
        return cumple;
    }

    public String getBug() {
        return bug;
    }

    public boolean crearRegla(String reglaProgra) {
        String[] aux = reglaProgra.split("→");
        Pattern regEti = Pattern.compile("^[P][0-9]+:[" + marcadores + variables + "]+");
        Pattern regSin = Pattern.compile("[" + marcadores + variables + "]+");
        Regla regla = new Regla("", "", "", "");
        boolean bandera = true;
        if (regEti.matcher(aux[0]).find()) {
            int i = 0;
            while (aux[0].charAt(i) != ':') {
                regla.setId(regla.getId() + aux[0].charAt(i));
                i++;
            }
            i++;
            while (i < aux[0].length()) {
                regla.setInicio(regla.getInicio() + aux[0].charAt(i));
                i++;
            }
        } else {
            if (regSin.matcher(aux[0]).find()) {
                regla.setInicio(aux[0]);
            } else {
                bandera = false;
            }
        }
        if (bandera) {
            Pattern regTran1 = Pattern.compile("[" + marcadores + variables + "Λλ]+[.]{0,1}[\\(][P][0-9][\\)];");
            Pattern regTran2 = Pattern.compile("[" + marcadores + variables + "Λλ]+[.]{0,1}[P][0-9];");
            Pattern regTran3 = Pattern.compile("[" + marcadores + variables + "Λλ][.]{0,1};");
            if (regTran1.matcher(aux[1]).find()) {
                int i = 0;
                while (aux[1].charAt(i) != '(') {
                    regla.setTrans(regla.getTrans() + aux[1].charAt(i));
                    i++;
                }
                i++;
                while (aux[1].charAt(i) != ')') {
                    regla.setSig(regla.getSig() + aux[1].charAt(i));
                    i++;
                }
            } else {
                if (regTran2.matcher(aux[1]).find()) {
                    int i = 0;
                    while (aux[1].charAt(i) != 'P') {
                        regla.setTrans(regla.getTrans() + aux[1].charAt(i));
                        i++;
                    }
                    while (aux[1].charAt(i) != ';') {
                        regla.setSig(regla.getSig() + aux[1].charAt(i));
                        i++;
                    }
                } else {
                    if (regTran3.matcher(aux[1]).find()) {
                        int i = 0;
                        while (aux[1].charAt(i) != ';') {
                            regla.setTrans(regla.getTrans() + aux[1].charAt(i));
                            i++;
                        }
                    } else {
                        bandera = false;
                    }
                }
            }
        }
        if (bandera) {
            reglas.add(regla);
        }
        return bandera;
    }
}
