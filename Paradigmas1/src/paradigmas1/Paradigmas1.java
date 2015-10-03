/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paradigmas1;

import Control.Control;
import Vista.Ventana;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ubuntu
 */
public class Paradigmas1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Control control = Control.obtenerInstancia();
        Ventana ventana1 = new Ventana(control);
        control.agregarObservable(ventana1);
//        System.out.println("\u03B1");
//        Pattern pattern = Pattern.compile("^([^#]*?)\\s+->\\s+(\\.?)(.*)(.|([^#]*?));");
//        Pattern pattern1 = Pattern.compile("[\u0391\u0392\u0393\u0394\u0395\u0396\u0397\u0398"
//                + "\u0399\u039A\u039B\u039C\u039D\u039E\u039F\u03A0\u03A1\u03A3\u03A4"
//                + "\u03A5\u03A6\u03A7\u03A8\u03A9\u03B1\u03B2\u03B3\u03B4\u03B5\u03B6"
//                + "\u03B7\u03B8\u03B9\u03BA\u03BB\u03BC\u03BD\u03BE\u03BF\u03C0\u03C1"
//                + "\u03C2\u03C3\u03C4\u03C5\u03C6\u03C7\u03C8\u03C9]");
//        Pattern pattern2 = Pattern.compile("[Α-ω]");
//        System.out.println("\u0391\u0392\u0393\u0394\u0395\u0396\u0397\u0398"
//                + "\u0399\u039A\u039B\u039C\u039D\u039E\u039F\u03A0\u03A1\u03A3\u03A4"
//                + "\u03A5\u03A6\u03A7\u03A8\u03A9\u03B1\u03B2\u03B3\u03B4\u03B5\u03B6"
//                + "\u03B7\u03B8\u03B9\u03BA\u03BB\u03BC\u03BD\u03BE\u03BF\u03C0\u03C1"
//                + "\u03C2\u03C3\u03C4\u03C5\u03C6\u03C7\u03C8\u03C9");
//        Pattern pattern3 = Pattern.compile("(^a-z)|(^0-9)");
//        Pattern pattern4 = Pattern.compile("[^abc]");
//        Matcher m = pattern4.matcher("ΑΒΓΔΕΖΗΘΙΚΛΜΝΞΟΠΡΣΤΥΦΧΨΩαβγδεζηθικλμνξοπρςστυφχψω");
//        if (m.find()) {
//            System.out.println("aceptada");
//        } else {
//            System.out.println("no aceptada");
//        }
    }

}
