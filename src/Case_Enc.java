import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Case_Enc extends JButton {

    Enclos enclos;

    public Case_Enc(JButton b, Enclos e) {
        this.setAlignmentX(b.getAlignmentX());
        this.setAlignmentY(b.getAlignmentY());
        this.setSize(b.getSize());
        this.setVisible(true);
        this.setBackground(b.getBackground());

        this.enclos = e;
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                afficher_enclos affiche = new afficher_enclos(e);
            }
        });
    }
}

