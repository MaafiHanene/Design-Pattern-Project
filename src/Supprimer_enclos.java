import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Supprimer_enclos extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JComboBox comboBox;
    Zoo z;


    public Supprimer_enclos(Zoo zoo) {
        this.z = z;
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel titre = new JLabel("Choisissez un enclos pour l'animal");
        panel.add(titre);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(0, 0));

        JPanel panel_2 = new JPanel();
        panel_1.add(panel_2, BorderLayout.WEST);

        Component horizontalStrut = Box.createHorizontalStrut(20);
        panel_2.add(horizontalStrut);

        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3, BorderLayout.NORTH);

        Component verticalStrut = Box.createVerticalStrut(20);
        panel_3.add(verticalStrut);

        JPanel panel_4 = new JPanel();
        panel_1.add(panel_4, BorderLayout.EAST);

        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        panel_4.add(horizontalStrut_1);

        JPanel panel_5 = new JPanel();
        panel_1.add(panel_5, BorderLayout.SOUTH);

        Component verticalStrut_1 = Box.createVerticalStrut(20);
        panel_5.add(verticalStrut_1);

        comboBox = new JComboBox();
        panel_1.add(comboBox, BorderLayout.CENTER);

        Component horizontalStrut_2 = Box.createHorizontalStrut(20);
        contentPane.add(horizontalStrut_2, BorderLayout.WEST);

        Component horizontalStrut_3 = Box.createHorizontalStrut(20);
        contentPane.add(horizontalStrut_3, BorderLayout.EAST);

        Component verticalStrut_2 = Box.createVerticalStrut(20);
        contentPane.add(verticalStrut_2, BorderLayout.SOUTH);

        Iterator<Enclos> it = formulaireZoo.enclos.iterator();
        while (it.hasNext()) {
            comboBox.addItem(it.next());
        }

        comboBox.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent arg0) {

        formulaireZoo.enclos.remove(comboBox.getSelectedItem());
        JOptionPane.showMessageDialog(null, "Enclos supprime avec succes");
        this.dispose();

    }

}
