package paradigmas1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Simbols {

    public static void main(String args[]) {
        String[] tableData = {"Α α", "Β β", "Γ γ", "Δ δ", "Ε ε", "Ζ ζ", "Η η", "Θ θ", "Ι ι", "Κ κ", "Λ λ", "Μ μ", "Ν ν", "Ξ ξ", "Ο ο", "Π π", "Ρ ρ", "Σ σ ς", "Τ τ", "Υ υ", "Φ φ", "Χ χ", "Ψ ψ", "Ω ω"};
        JFrame frame = new JFrame("Simbols");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        JList jlist = new JList(tableData);
        JScrollPane scrollPane1 = new JScrollPane(jlist);
        contentPane.add(scrollPane1, BorderLayout.WEST);
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
                        ///Meta aqui el TextArea.
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
        frame.setSize(350, 200);
        frame.setVisible(true);
    }
}
