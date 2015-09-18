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
public class Gramatica {
    
    private int id;
    private ArrayList<String> comentarios;
    private ArrayList<String> simbolos;
    private ArrayList<String> variables;
    private ArrayList<String> marcadores;
    private ArrayList<String> patrones;
    
    public Gramatica(int id){
        this.id = id;
        comentarios = new ArrayList<>();
        simbolos = new ArrayList<>();
        variables = new ArrayList<>();
        marcadores = new ArrayList<>();
        patrones = new ArrayList<>();
    }
    
    public boolean insertarComentario(String comentario){
        return comentarios.add(comentario);
    }
    
    public boolean insertarSimbolo(String simbolo){
        return simbolos.add(simbolo);
    }
    
    public boolean insertarVariables(String variable){
        return variables.add(variable);
    }
    
    public boolean insertarMarcador(String marcador){
        return marcadores.add(marcador);
    }
    
    public boolean insertarPatron(String patron){
        return patrones.add(patron);
    }
    
    public String getComentarioPos(int pos){
        return comentarios.get(pos);
    }
    
    public String getSimboloPos(int pos){
        return simbolos.get(pos);
    }
    
    public String getVariablesPos(int pos){
        return variables.get(pos);
    }
    
    public String getMarcadorPos(int pos){
        return marcadores.get(pos);
    }
    
    public String getPatronPos(int pos){
        return patrones.get(pos);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<String> comentarios) {
        this.comentarios = comentarios;
    }

    public ArrayList<String> getSimbolos() {
        return simbolos;
    }

    public void setSimbolos(ArrayList<String> simbolos) {
        this.simbolos = simbolos;
    }

    public ArrayList<String> getVariables() {
        return variables;
    }

    public void setVariables(ArrayList<String> variables) {
        this.variables = variables;
    }

    public ArrayList<String> getMarcadores() {
        return marcadores;
    }

    public void setMarcadores(ArrayList<String> marcadores) {
        this.marcadores = marcadores;
    }

    public ArrayList<String> getPatrones() {
        return patrones;
    }

    public void setPatrones(ArrayList<String> patrones) {
        this.patrones = patrones;
    }
}
