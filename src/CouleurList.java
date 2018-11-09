import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JOptionPane;


public class CouleurList implements ActionListener {

    private JButton b;
    private Espece esp;

    public CouleurList(JButton b, Espece e) {
        this.b = b;
        this.esp = e;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {


        Iterator<Enclos> it = FormZoo.enclos.iterator();
        while (it.hasNext()) {
            Enclos e = it.next();
            if (e.contient(this.esp)) {
                PlanZoo.cases.get(e.getAdr()).setBackground(Color.RED);
            } else {
                e.colorier();
            }
        }

    }

}
