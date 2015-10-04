/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author mac
 */
public class Algorithms {

    public Algorithms() {
        this.sResult="";
    }
    
    String sCadena = "LineaDeCodigo";
    String sResult;
    
    String TurnLine(String a){
        for (int x=a.length()-1;x>=0;x--)
		sResult = sResult + a.charAt(x);
        return sResult;
    }
    
    public static void main(String args[]) {
    String sCadena = "LineaDeCodigo";
        Algorithms a = new Algorithms();
        System.out.println(a.TurnLine(sCadena));
    }
}
