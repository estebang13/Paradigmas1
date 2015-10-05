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

    public static String BynaryUnary(String a) {
        int a1 = Integer.parseInt(a, 2);
        String sResult1 = "";
        for (int x = 0; x < a1; x++) {
            sResult1 = sResult1 + "|";
        }
        return sResult1;
    }

    public static String BinarySuma(String a, String b) {
        int a1 = Integer.parseInt(a, 2);
        int b1 = Integer.parseInt(b, 2);
        int c1 = a1 + b1;
        String result = Integer.toString(c1, 2);
        return result;
    }
    
    public static String TriplicateBinary(String a) {
        int a1 = Integer.parseInt(a, 2);
        int c1 = a1 * 3;
        String result = Integer.toString(c1, 2);
        return result;
    }

    public static double DecimalSuma(double n, double m) {
        double c = n + m;
        return c;
    }

    public static String DoubleChar(String a) {
        String sResult1 = "";
        char b = ' ';
        sResult1 = sResult1+a.charAt(0); 
        for (int x = 1; x < a.length(); x++) {   
        b = a.charAt(x-1);
        char c =  a.charAt(x);    
         if (b!=c)
            sResult1 = sResult1 + c;
        }
        return sResult1;
    }

    public static void main(String args[]) {
        String sCadena = "LineaDeCodigo";
        String sCadena1 = "aaaaabbbbbbcccckkkkkkkkkkkjsjsssss";
        String B1 = "1111";
        String B2 = "1110";
        String B3 = "1101";
        Algorithms a = new Algorithms();
        System.out.println(a.TurnLine(sCadena));
        System.out.println(a.DuplicateLine(sCadena));
        System.out.println(a.BynaryUnary(B1));
        System.out.println("Ana es Palindromo:" + a.Palindromo("Ana"));
        System.out.println("Luis es Palindromo:" + a.Palindromo("Luis"));
        System.out.println("Suma" + B1 + "" + "+" + B2 + "=" + a.BinarySuma(B1, B2));
        System.out.println("Triple: " + a.TriplicateBinary(B3));
        System.out.println("Suma: " + "2.0" + "" + "+" + "5.0" + "=" + a.DecimalSuma(2.0, 5.0));
        System.out.println(a.DoubleChar(sCadena1));
    }
}
