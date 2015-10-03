/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.Control;
import Modelo.ArchivoFiltro;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Brayan
 */
public class Ventana extends JFrame implements Observer {

    private Control control;

    private JMenuBar barra1;
    private JMenu menu1;
    private JMenu menu2;
    private JMenuItem cargarAlgol;
    private JMenuItem cargarEnt;
    private JMenu menu3;
    private JMenuItem guardarAlgol;
    private JMenuItem guardarEnt;
    private JMenuItem guardarEjec;
    private JPanel panel1;
    private JButton compAlgol;
    private JButton ejecutar;
    private JLabel label1;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;
    private JTextArea textArea1;
    private JTextArea textArea2;

    public Ventana(Control control) {
        super("Proyecto 1 Paradigmas");
        this.control = control;
        configuracionInicial();
        ajustarMenu();
        cargarPanel();
        ajustarEventos();
        this.setVisible(true);
    }

    private void configuracionInicial() {
        this.setLayout(null);
        this.setSize(1366, 768);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1266, 740));
    }

    private void ajustarMenu() {
        barra1 = new JMenuBar();
        menu1 = new JMenu("Archivo");
        menu2 = new JMenu("Cargar");
        cargarAlgol = new JMenuItem("Cargar Algoritmos");
        cargarEnt = new JMenuItem("Cargar Entradas");
        menu2.add(cargarAlgol);
        menu2.add(cargarEnt);
        menu3 = new JMenu("Guardar");
        guardarAlgol = new JMenuItem("Guardar Algoritmos");
        guardarEnt = new JMenuItem("Guardar Entradas");
        guardarEjec = new JMenuItem("Guardar Traza");
        menu3.add(guardarAlgol);
        menu3.add(guardarEnt);
        menu3.add(guardarEjec);
        menu1.add(menu2);
        menu1.add(menu3);
        barra1.add(menu1);
        setJMenuBar(barra1);
    }

    private void cargarPanel() {
        panel1 = new JPanel(new GridBagLayout());

        compAlgol = new JButton("Compilar Gramatica");
        ejecutar = new JButton("Ejecutar");
        ejecutar.setEnabled(false);
        label1 = new JLabel("Gramática");
        label2 = new JLabel("Entradas");
        scrollPane1 = new JScrollPane();
        scrollPane2 = new JScrollPane();
        textArea1 = new JTextArea();
        textArea2 = new JTextArea();

        textArea1.setColumns(50);
        textArea1.setRows(40);
        scrollPane1.setViewportView(textArea1);

        textArea2.setColumns(50);
        textArea2.setRows(40);
        scrollPane2.setViewportView(textArea2);

        GridBagConstraints ajustador = new GridBagConstraints();

        ajustador.gridx = 0;
        ajustador.gridy = 0;
        panel1.add(label1, ajustador);

        ajustador.gridy = 1;
        panel1.add(scrollPane1, ajustador);

        ajustador.gridy = 41;
        panel1.add(compAlgol, ajustador);

        ajustador.gridx = 55;
        ajustador.gridy = 0;
        panel1.add(label2, ajustador);

        ajustador.insets = new Insets(0, 50, 0, 0);
        ajustador.gridy = 1;
        panel1.add(scrollPane2, ajustador);

        ajustador.insets = new Insets(0, 0, 0, 0);
        ajustador.gridy = 41;
        panel1.add(ejecutar, ajustador);

        Container c = this.getContentPane();
        c.removeAll();
        c.setLayout(new BorderLayout());
        c.add(panel1, BorderLayout.CENTER);
        panel1.setVisible(true);

        pack();
    }

    private void ajustarEventos() {
        cargarAlgol.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                File fi = new File("gramactica.txt");
                try {
                    String linea = "";
                    FileReader fr = new FileReader(fi);
                    String val = "";
                    BufferedReader br = new BufferedReader(fr);
                    while ((linea = br.readLine()) != null) {
                        val += linea + "\n";
                    }
                    textArea1.setText(val);
                    br.close();
                    fr.close();
                } catch (Exception ex) {
                    System.err.println("error: " + "\n" + ex.getMessage());
                }
            }
        });
        cargarEnt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("listener cargar entradas");
            }
        });
        guardarAlgol.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (textArea1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe de escribir la gramatica a guardar");
                } else {
                    File fi = new File("gramactica.txt");
                    try {
                        FileWriter fw = new FileWriter(fi);
                        fw.write(textArea1.getText());
                        fw.flush();
                        fw.close();
                    } catch (Exception ex) {
                        System.err.println("error: " + ex.getMessage());
                    }
                }
            }
        });
        guardarEnt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        guardarEjec.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("listener cargar entradas");
            }
        });
        compAlgol.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (textArea1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe de escribir una gramatica");
                } else {
                    if (control.getGramatica().comprobarGramatica(textArea1.getText())) {
                        JOptionPane.showMessageDialog(null, "Gramatica correcta");
                        ejecutar.setEnabled(true);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Gramatica incorrecta");
                }
            }
        });
        ejecutar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
