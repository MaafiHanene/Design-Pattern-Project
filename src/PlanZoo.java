

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Enum.Barriere;
import Enum.TypeEau;
import Enum.TypeSol;
import Exceptions.NonCompatible;

import javax.swing.Box;

import java.awt.Component;

public class PlanZoo extends JFrame {

    private JPanel panel;
    private int indicePrincipale = 26;
    static public ArrayList<JButton> cases = new ArrayList<JButton>();

    public static void main(String[] args) {

        Modif p = new Modif(40);


        Paludarium palu = new Paludarium(1, 5, 8, 9, TypeSol.Argile, 5);
        Voliere v = new Voliere(2, 3, 1, 8, 5);

        Aquarium a = new Aquarium(3, 5, 6, 100, 15, TypeEau.Sale);
        Cage c2 = new Cage(6, 5, 58, 5, null);

        Insectarium i = new Insectarium(4, 2, 5, 6);
        Cage c = new Cage(1, 12, 25, 2, null);

        FormZoo.enclos.add(c);
        FormZoo.enclos.add(v);
        FormZoo.enclos.add(c2);
        FormZoo.enclos.add(a);
        FormZoo.enclos.add(i);
        FormZoo.enclos.add(palu);

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PlanZoo frame = new PlanZoo(40);
                    frame.setVisible(true);
                    frame.placerEnclos(FormZoo.enclos);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }


    public PlanZoo(int nb_max) {
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel();
        panel.setSize(new Dimension(1100, 500));
        panel.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(panel);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(Color.LIGHT_GRAY);
        panel.add(panel2);

        panel2.setLayout(null);

        JPanel panelespeces = new JPanel();
        panelespeces.setBounds(210, 144, 210, -80);

        panel2.add(panelespeces);

        JPanel panelEsp = new JPanel();
        panel.add(panelEsp, BorderLayout.SOUTH);

        Box pileEspeces = Box.createHorizontalBox();
        panelEsp.add(pileEspeces);

        JButton Abeille = new JButton("Abeille");
        pileEspeces.add(Abeille);

        JButton Addax = new JButton("Addax");
        pileEspeces.add(Addax);

        JButton Araignee = new JButton("Araignee");
        pileEspeces.add(Araignee);

        JButton Autruche = new JButton("Autruche");
        pileEspeces.add(Autruche);

        JButton Crapaud_commun = new JButton("Crapaud_commun");
        pileEspeces.add(Crapaud_commun);

        JButton Escargot = new JButton("Escargot");
        pileEspeces.add(Escargot);

        JButton Fourmi = new JButton("Fourmi");
        pileEspeces.add(Fourmi);

        JButton Lion = new JButton("Lion");
        pileEspeces.add(Lion);

        JButton Mouton = new JButton("Mouton");
        pileEspeces.add(Mouton);

        JButton Poisson_mandarin = new JButton("Poisson_mandarin");
        pileEspeces.add(Poisson_mandarin);

        Poisson_mandarin.addActionListener(new CouleurList(Poisson_mandarin, new Espece("poisson_mandarin.esp")));
        Mouton.addActionListener(new CouleurList(Mouton, new Espece("mouton.esp")));
        Lion.addActionListener(new CouleurList(Lion, new Espece("lion.esp")));
        Fourmi.addActionListener(new CouleurList(Fourmi, new Espece("fourmi.esp")));
        Escargot.addActionListener(new CouleurList(Escargot, new Espece("escargot.esp")));
        Crapaud_commun.addActionListener(new CouleurList(Crapaud_commun, new Espece("crapaud_commun.esp")));
        Autruche.addActionListener(new CouleurList(Autruche, new Espece("autruche.esp")));
        Araignee.addActionListener(new CouleurList(Araignee, new Espece("araignee.esp")));
        Addax.addActionListener(new CouleurList(Addax, new Espece("addax.esp")));
        Abeille.addActionListener(new CouleurList(Abeille, new Espece("abeille.esp")));


        for (int i = 0; i < cases.size(); i++) {

            for (ActionListener al : cases.get(i).getActionListeners())
                cases.get(i).removeActionListener(al);
            cases.get(i).addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                }
            });
            panel2.add(cases.get(i));
            if (cases.get(i).getText() == "P") indicePrincipale = i;
        }
    }

    public void placerEnclos(TreeSet<Enclos> enclos) {

        Iterator<Enclos> it = enclos.iterator();
        JButton b = null;
        int j;
        while (it.hasNext()) {
            Enclos e = it.next();
            if (e instanceof Cage) {
                j = ProchainePlace(indicePrincipale);
                e.setAdr(j);
                b = cases.get(j);
                b.setBackground(new Color(139, 69, 19));
                for (ActionListener al : cases.get(j).getActionListeners())
                    cases.get(j).removeActionListener(al);
                cases.get(j).addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        afficher_enclos af = new afficher_enclos(e);
                    }
                });
            } else if (e instanceof Voliere) {
                j = ProchainePlace(indicePrincipale);
                e.setAdr(j);
                b = cases.get(j);
                b.setBackground(Color.YELLOW);
                b.setForeground(Color.BLACK);
                for (ActionListener al : cases.get(j).getActionListeners())
                    cases.get(j).removeActionListener(al);
                cases.get(j).addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        afficher_enclos af = new afficher_enclos(e);
                    }
                });
            } else if (e instanceof Aquarium) {
                j = ProchainePlace(indicePrincipale);
                e.setAdr(j);
                b = cases.get(j);
                b.setBackground(Color.BLUE);
                for (ActionListener al : cases.get(j).getActionListeners())
                    cases.get(j).removeActionListener(al);
                cases.get(j).addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        afficher_enclos af = new afficher_enclos(e);
                    }
                });
            } else if (e instanceof Paludarium) {
                j = ProchainePlace(indicePrincipale);
                e.setAdr(j);
                b = cases.get(j);
                b.setBackground(Color.GREEN);
                for (ActionListener al : cases.get(j).getActionListeners())
                    cases.get(j).removeActionListener(al);
                cases.get(j).addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        afficher_enclos af = new afficher_enclos(e);
                    }
                });
            } else if (e instanceof Insectarium) {
                j = ProchainePlace(indicePrincipale);
                e.setAdr(j);
                b = cases.get(j);
                b.setBackground(Color.ORANGE);
                b.setForeground(Color.BLACK);
                for (ActionListener al : cases.get(j).getActionListeners())
                    cases.get(j).removeActionListener(al);
                cases.get(j).addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        afficher_enclos af = new afficher_enclos(e);
                    }
                });
            }
        }
    }

    public static int ProchainePlace(int principale) {
        int resultat = 0, i = 1;
        boolean boo1, boo2;
        while ((i < cases.size() / 2)) {
            boo1 = true;
            boo2 = true;
            if (principale + i < cases.size()) {
                if (cases.get(principale + i).getBackground() == Color.BLACK) {
                    boo1 = false;
                    resultat = principale + i;
                    break;
                } else {
                    if (principale - i >= 0) {
                        if (cases.get(principale - i).getBackground() == Color.BLACK) {
                            boo2 = false;
                            resultat = principale - i;
                            break;
                        }
                    }

                }
            }
            if (boo1 == true && boo2 == true) {
                i++;
            }
        }
        return resultat;
    }
}
