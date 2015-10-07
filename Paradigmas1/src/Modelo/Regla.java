/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author brayan
 */
public class Regla {

    private String id;
    private String inicio;
    private String trans;
    private String sig;

    public Regla(String inicio, String trans) {
        this.inicio = inicio;
        this.trans = trans;
    }

    public Regla(String id, String inicio, String trans, String sig) {
        this.id = id;
        this.inicio = inicio;
        this.trans = trans;
        this.sig = sig;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    public String toString() {
        return id + " " + inicio + " -> " + trans + " " + sig;
    }
}
