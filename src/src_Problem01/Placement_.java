package src_Problem01;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class Placement_ extends JFrame {

    JPanel panel, panel_droite;
    private JButton termine;
    private String typePorte;
    private int principale = 0;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Placement_ frame = new Placement_(40);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Placement_(int nb_max) {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1300, 700);

        panel = new JPanel();
        panel.setSize(new Dimension(1100, 500));
        panel.setBorder(new EmptyBorder(0, 0, 0, 0));
        panel.setLayout(new GridBagLayout());
        setContentPane(panel);

        panel_droite = new JPanel();
        panel_droite.setLayout(null);
        panel_droite.setBackground(Color.LIGHT_GRAY);

        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.5;
        c.weighty = 1;
        panel.add(panel_droite, c);

        JLabel titre = new JLabel("Veuillez indiquer les cases qui contiendront une porte ou un restaurant : ");
        titre.setFont(new Font("Century Gothic", Font.BOLD, 27));
        titre.setBounds(173, 41, 1000, 58);
        panel_droite.add(titre);

        termine = new JButton("Termin�");
        termine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                dispose();
            }
        });
        termine.setForeground(Color.WHITE);
        termine.setBackground(Color.DARK_GRAY);
        termine.setBounds(990, 532, 143, 52);
        panel_droite.add(termine);

        JLabel soustitre = new JLabel("La premi�re porte plac�e sera la porte principale");
        soustitre.setFont(new Font("Tahoma", Font.PLAIN, 16));
        soustitre.setForeground(Color.RED);
        soustitre.setBounds(598, 96, 383, 16);
        panel_droite.add(soustitre);

        JPanel entreeOUsortie = new JPanel();
        entreeOUsortie.setBounds(38, 605, 329, 35);
        panel_droite.add(entreeOUsortie);

        JRadioButton choixentree = new JRadioButton("entree");
        entreeOUsortie.add(choixentree);

        JRadioButton choixsortie = new JRadioButton("sortie");
        entreeOUsortie.add(choixsortie);

        JRadioButton choixresto = new JRadioButton("restaurant");
        entreeOUsortie.add(choixresto);

        ButtonGroup group = new ButtonGroup();
        group.add(choixsortie);
        group.add(choixentree);
        group.add(choixresto);


        int N = nb_max, x = 1200, y = 450, j = 1;
        int N2 = (int) (N * 0.1);
        int N1 = (N - N2) / 2;
        if ((N1 * 2) + N2 < N) N2++;
        int N3 = N1;


        for (int i = 1; i <= N1; i++) {
            JButton b = new JButton("" + j);
            b.setBackground(Color.BLACK);
            b.setForeground(Color.WHITE);
            PlanZoo_.cases.add(b);
            j++;
            b.setSize(50, 50);
            x = x - 60;
            b.setLocation(x, y);
            panel_droite.add(b);
        }

        for (int i = 1; i <= N2; i++) {
            JButton b = new JButton("" + j);
            b.setBackground(Color.BLACK);
            b.setForeground(Color.WHITE);
            PlanZoo_.cases.add(b);
            j++;
            b.setSize(50, 50);
            y = y - 60;
            b.setLocation(x, y);
            panel_droite.add(b);
        }
        y = y - 60;
        x = x - 60;
        for (int i = 1; i <= N3; i++) {
            JButton b = new JButton("" + j);
            b.setBackground(Color.BLACK);
            b.setForeground(Color.WHITE);
            PlanZoo_.cases.add(b);
            j++;
            b.setSize(50, 50);
            x = x + 60;
            b.setLocation(x, y);
            panel_droite.add(b);
        }

        Iterator<JButton> it = PlanZoo_.cases.iterator();

        while (it.hasNext()) {
            JButton bouton = it.next();
            bouton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {

                    if (choixentree.isSelected()) {
                        bouton.setBackground(Color.WHITE);
                        bouton.setForeground(Color.BLACK);
                        if (principale == 0) {
                            principale++;
                            bouton.setText("P");
                        } else {
                            bouton.setText("E");
                        }
                    } else if (choixsortie.isSelected()) {
                        bouton.setBackground(Color.LIGHT_GRAY);
                        bouton.setForeground(Color.BLACK);
                        bouton.setText("S");
                    } else if (choixresto.isSelected()) {
                    	FormulaireRestau_ fr = new FormulaireRestau_(bouton);
                    } else {
                        JOptionPane.showMessageDialog(null, "Choisissez entr�e/sortie svp");
                    }

                }

            });
        }
    }
}

