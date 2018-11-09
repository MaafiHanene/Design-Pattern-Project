import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box;


public class placer_animal extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JComboBox comboBox;
    private Animal a;

    public static ArrayList<Animal> animaux = new ArrayList<Animal>();

    public placer_animal(Zoo zoo, Animal a) {
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.a = a;
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
        try {
            ((Enclos) comboBox.getSelectedItem()).ajouterAnimal(a);
            placer_animal.animaux.add(a);
            this.dispose();
            JOptionPane.showMessageDialog(null, "Animal ajoute avec succes");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Animal incompatible");
        }

    }


}
