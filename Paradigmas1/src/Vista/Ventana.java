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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

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
    private JTextArea textArea3;
    private JScrollPane scrollPane5;

    public Ventana(Control control) {
        super("Proyecto 1 Paradigmas");
        this.control = control;
        configuracionInicial();
        ajustarMenu();
        cargarPanel();
        ajustarEventos();
        this.setVisible(true);
    }

    private String abrirArchivo() {
        String aux = "";
        String texto = "";
        try {
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(this);
            File abre = file.getSelectedFile();
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);
                while ((aux = lee.readLine()) != null) {
                    texto += aux + "\n";
                }
                lee.close();
            }
        } catch (IOException ex) {
            textArea3.setText(ex + "" + "\nNo se ha encontrado el archivo");
        }
        return texto;//El texto se almacena en el JTextArea
    }

    private void guardarArchivo(JTextArea textArea) {
        try {
            String nombre = "";
            JFileChooser file = new JFileChooser();
            file.showSaveDialog(this);
            File guarda = file.getSelectedFile();

            if (guarda != null) {
                /*guardamos el archivo y le damos el formato directamente,
                 * si queremos que se guarde en formato doc lo definimos como .doc*/
                FileWriter save = new FileWriter(guarda + ".txt");
                save.write(textArea.getText());
                save.close();
                textArea3.setText("El archivo se a guardado Exitosamente");
            }
        } catch (IOException ex) {
            textArea3.setText(ex + "" + "\nNo se ha encontrado el archivo");
        }
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
        scrollPane5 = new JScrollPane();
        textArea1 = new JTextArea();
        textArea2 = new JTextArea();
        textArea3 = new JTextArea();

        textArea1.setColumns(30);
        textArea1.setRows(20);
        scrollPane1.setViewportView(textArea1);

        textArea2.setColumns(30);
        textArea2.setRows(20);
        scrollPane2.setViewportView(textArea2);

        textArea3.setColumns(40);
        textArea3.setRows(10);
        scrollPane5.setViewportView(textArea3);

        textArea3.setEditable(false);
        textArea2.setEditable(false);

        GridBagConstraints ajustador = new GridBagConstraints();

        ajustador.gridx = 0;
        ajustador.gridy = 0;
        panel1.add(label1, ajustador);

        ajustador.gridy = 1;
        panel1.add(scrollPane1, ajustador);

        ajustador.gridy = 21;
        panel1.add(compAlgol, ajustador);

        ajustador.gridx = 31;
        ajustador.gridy = 1;

        String[] tableData = {"Α α", "Β β", "Γ γ", "Δ δ", "Ε ε", "Ζ ζ", "Η η", "Θ θ", "Ι ι", "Κ κ", "Λ λ", "Μ μ", "Ν ν", "Ξ ξ", "Ο ο", "Π π", "Ρ ρ", "Σ σ ς", "Τ τ", "Υ υ", "Φ φ", "Χ χ", "Ψ ψ", "Ω ω"};
        JList jlist = new JList(tableData);
        JScrollPane scrollPane3 = new JScrollPane(jlist);
        panel1.add(scrollPane3, ajustador);
        ListSelectionListener listSelectionListener;
        listSelectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                boolean adjust = listSelectionEvent.getValueIsAdjusting();
                if (!adjust) {
                    JList list = (JList) listSelectionEvent.getSource();
                    int selections[] = list.getSelectedIndices();
                    Object selectionValues[] = list.getSelectedValues();
                    for (int i = 0, n = selections.length; i < n; i++) {
                        if (i == 0) {
                        }
                        System.out.print(selectionValues[i]);
                        textArea1.setText(textArea1.getText() + selectionValues[i]);
                    }
                }
            }
        };
        jlist.addListSelectionListener(listSelectionListener);
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
                JList theList = (JList) mouseEvent.getSource();
                if (mouseEvent.getClickCount() == 2) {
                    int index = theList.locationToIndex(mouseEvent.getPoint());
                    if (index >= 0) {
                        Object o = theList.getModel().getElementAt(index);
                    }
                }
            }
        };
        jlist.addMouseListener(mouseListener);

        ajustador.gridx = 80;
        ajustador.gridy = 0;
        panel1.add(label2, ajustador);

        ajustador.insets = new Insets(0, 50, 0, 0);
        ajustador.gridy = 1;
        panel1.add(scrollPane2, ajustador);

        ajustador.insets = new Insets(0, 0, 0, 0);
        ajustador.gridy = 21;
        panel1.add(ejecutar, ajustador);

        ajustador.gridx = 81;
        ajustador.gridy = 1;

        JList jlist1 = new JList(tableData);
        JScrollPane scrollPane4 = new JScrollPane(jlist1);
        panel1.add(scrollPane4, ajustador);
        ListSelectionListener listSelectionListener1;
        listSelectionListener1 = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                boolean adjust = listSelectionEvent.getValueIsAdjusting();
                if (!adjust) {
                    JList list = (JList) listSelectionEvent.getSource();
                    int selections[] = list.getSelectedIndices();
                    Object selectionValues[] = list.getSelectedValues();
                    for (int i = 0, n = selections.length; i < n; i++) {
                        if (i == 0) {
                        }
                        System.out.print(selectionValues[i]);
                        textArea2.setText(textArea2.getText() + selectionValues[i]);
                    }
                }
            }
        };
        jlist1.addListSelectionListener(listSelectionListener1);
        MouseListener mouseListener1 = new MouseAdapter() {
            public void mouseClicked(MouseEvent mouseEvent) {
                JList theList = (JList) mouseEvent.getSource();
                if (mouseEvent.getClickCount() == 2) {
                    int index = theList.locationToIndex(mouseEvent.getPoint());
                    if (index >= 0) {
                        Object o = theList.getModel().getElementAt(index);
                    }
                }
            }
        };
        jlist1.addMouseListener(mouseListener1);

        ajustador.insets = new Insets(0, 0, 0, 0);
        ajustador.gridx = 90;
        ajustador.gridy = 40;
        panel1.add(scrollPane5, ajustador);

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
                String a = abrirArchivo();
                try {
                    textArea1.setText(a);
                } catch (Exception ex) {
                    textArea3.setText("");
                    textArea3.setText("error: " + "\n" + ex.getMessage());
                }
            }
        });
        cargarEnt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String a = abrirArchivo();
                try {
                    textArea2.setText(a);
                } catch (Exception ex) {
                    textArea3.setText("");
                    textArea3.setText("error: " + "\n" + ex.getMessage());
                }
            }
        });

        guardarAlgol.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    guardarArchivo(textArea1);
                } catch (Exception ex) {
                    textArea3.setText("");
                    textArea3.setText("error: " + "\n" + ex.getMessage());
                }
            }
        });

        guardarEnt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    guardarArchivo(textArea2);
                } catch (Exception ex) {
                    textArea3.setText("");
                    textArea3.setText("error: " + "\n" + ex.getMessage());
                }
            }
        });
        guardarEjec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    guardarArchivo(textArea3);
                } catch (Exception ex) {
                    textArea3.setText("");
                    textArea3.setText("error: " + "\n" + ex.getMessage());
                }
            }
        });
        compAlgol.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (textArea1.getText().equals("")) {
                    textArea3.setText("");
                    textArea3.setText("Debe de escribir una gramatica");
                } else {
                    if (control.comprobarGramatica(textArea1.getText())) {
                        ejecutar.setEnabled(true);
                        textArea2.setEditable(true);
                        textArea3.setText("");
                        textArea3.setText(control.getBug() + "\n Gramatica Correcta");
                    } else {
                        textArea3.setText("");
                        textArea3.setText(control.getBug() + "\n Gramatica Incorrecta");
                    }
                }
            }
        });
        ejecutar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (textArea2.getText().equals("")) {
                    textArea3.setText("");
                    textArea3.setText("Debe de escribir una hilera de entrada");
                } else {
                    control.aplicarAlgoritmo(textArea2.getText());
                    textArea3.setText("");
                    textArea3.setText(control.getEntradaModificada());
                }
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
