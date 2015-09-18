/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.Control;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JMenu menu3;
    private JMenuItem menuItem4;
    private JMenuItem menuItem5;
    private JPanel panel1;
    private JButton boton1;
    private JButton boton2;
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
        menuItem1 = new JMenuItem("Cargar Algoritmos");
        menuItem2 = new JMenuItem("Cargar Entradas");
        menu2.add(menuItem1);
        menu2.add(menuItem2);
        menu3 = new JMenu("Guardar");
        menuItem3 = new JMenuItem("Guardar Algoritmos");
        menuItem4 = new JMenuItem("Guardar Entradas");
        menuItem5 = new JMenuItem("Guardar Traza");
        menu3.add(menuItem3);
        menu3.add(menuItem4);
        menu3.add(menuItem5);
        menu1.add(menu2);
        menu1.add(menu3);
        barra1.add(menu1);
        setJMenuBar(barra1);
    }
    
    private void cargarPanel(){
        panel1 = new JPanel(new GridBagLayout());
        
        boton1 = new JButton("Compilar Gramatica");
        boton2 = new JButton("Ejecutar");
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
        panel1.add(label1,ajustador);
        
        ajustador.gridy = 1;
        panel1.add(scrollPane1,ajustador);
        
        ajustador.gridy = 41;
        panel1.add(boton1,ajustador);
        
        ajustador.gridx = 55;
        ajustador.gridy = 0;
        panel1.add(label2,ajustador);
        
        ajustador.insets = new Insets(0, 50, 0, 0);
        ajustador.gridy = 1;
        panel1.add(scrollPane2,ajustador);
        
        ajustador.insets = new Insets(0, 0, 0, 0);
        ajustador.gridy = 41;
        panel1.add(boton2,ajustador);
        
        Container c = this.getContentPane();
        c.removeAll();
        c.setLayout(new BorderLayout());
        c.add(panel1, BorderLayout.CENTER);
        panel1.setVisible(true);
        
        pack();
    }
    
    private void ajustarEventos(){
        menuItem1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("listener cargar granatica");
            }
        });
        menuItem2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("listener cargar entradas");
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
