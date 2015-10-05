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
    }

    String TurnLine(String a) {
        String sResult = "";
        for (int x = a.length() - 1; x >= 0; x--) {
            sResult = sResult + a.charAt(x);
        }
        return sResult;
    }

    String DuplicateLine(String a) {
        String sResult1 = "";
        for (int x = 0; x < a.length(); x++) {
            sResult1 = sResult1 + a.charAt(x);
        }
        return a + sResult1;
    }

    Boolean Palindromo(String a) {
        String sResult = TurnLine(a);
        sResult = sResult.toLowerCase();
        a = a.toLowerCase();
        if (a.equals(sResult)) {
            return true;
        }
        return false;
    }
    
     public static String BinarySuma(String a, String b) {
        int a1 = Integer.parseInt(a, 2);
        int b1 = Integer.parseInt(b, 2);
        int c1 = a1 + b1;
        String result = Integer.toString(c1, 2);
        return result;
    }
     
         public static double DecimalSuma(double n,double m){
             double c=n+m;
             return c; 
    }
  

    public static void main(String args[]) {
        String sCadena = "LineaDeCodigo";
        String B1="1111";
        String B2="1110";
        String B3="1101";
        Algorithms a = new Algorithms();
        System.out.println(a.TurnLine(sCadena));
        System.out.println(a.DuplicateLine(sCadena));
        System.out.println("Ana es Palindromo:"+a.Palindromo("Ana"));
        System.out.println("Luis es Palindromo:"+a.Palindromo("Luis"));
        System.out.println("Suma"+B1+""+"+"+B2+"="+a.BinarySuma(B1,B2));
        System.out.println("Suma"+B1+""+"+"+B3+"="+a.BinarySuma(B1,B3));
        System.out.println("Suma: "+"2.0"+""+"+"+"5.0"+"="+a.DecimalSuma(2.0,5.0));
    }
}
