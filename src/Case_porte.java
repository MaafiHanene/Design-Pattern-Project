import java.awt.Color;

import javax.swing.*;

public class Case_porte extends JButton {

    private Porte porte;

    public Case_porte(Porte porte) {
        this.porte = porte;
        this.setVisible(true);
        if (porte instanceof Porte_entree)
            this.setBackground(Color.GREEN);
        else if (porte instanceof Porte_sortie)
            this.setBackground(Color.RED);
    }

}
