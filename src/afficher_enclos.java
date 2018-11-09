import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.util.Iterator;
import java.util.Set;

import javax.swing.Box;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;

import Enum.Habitat;
import Enum.RegimeAlimentaire;
import Enum.TypeSol;
import Exceptions.NonCompatible;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class afficher_enclos extends JFrame {

    private JPanel contentPane;
    private Photo im = new Photo("");

    public static void main(String[] args) {
        Enclos e = new Cage(1, 2, 3, 5, TypeSol.Argile);


        Espece e1 = new Mammifere("lion.esp");

        Espece e2 = new Mammifere("addax.esp");

        Espece e3 = new Insecte("abeille.esp");

        Espece e4 = new Arachnide("araignee.esp");

        Espece e5 = new Oiseau("autruche.esp");

        Espece e6 = new Mollusque("escargot.esp");

        Espece e7 = new Mammifere("mouton.esp");

        Espece e8 = new Insecte("fourmi.esp");

        Espece e9 = new Amphibien("crapaud_commun.esp");

        try {
            e.ajouterAnimal(new Animal(e1));
            e.ajouterAnimal(new Animal(e2));
            e.ajouterAnimal(new Animal(e3));
            e.ajouterAnimal(new Animal(e4));
            e.ajouterAnimal(new Animal(e5));
            e.ajouterAnimal(new Animal(e6));
            e.ajouterAnimal(new Animal(e7));
            e.ajouterAnimal(new Animal(e8));
            e.ajouterAnimal(new Animal(e9));
        } catch (NonCompatible ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    afficher_enclos frame = new afficher_enclos(e);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



    public afficher_enclos(Enclos e) {
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 894, 797);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panelAnim = new JPanel();
        contentPane.add(panelAnim, BorderLayout.WEST);
        panelAnim.setLayout(new BoxLayout(panelAnim, BoxLayout.Y_AXIS));

        JLabel labelesp = new JLabel("Especes dans cet enclos");
        labelesp.setFont(new Font("Calibri", Font.ITALIC, 14));
        labelesp.setForeground(Color.RED);
        panelAnim.add(labelesp);

        Component espace = Box.createVerticalStrut(50);
        panelAnim.add(espace);


        JPanel panelTitre = new JPanel();
        contentPane.add(panelTitre, BorderLayout.NORTH);

        JPanel panelCentre = new JPanel();
        contentPane.add(panelCentre, BorderLayout.CENTER);
        panelCentre.setLayout(null);


        JLabel ENom = new JLabel("Nom de l'Espece");
        ENom.setFont(new Font("Calibri", Font.BOLD, 18));
        ENom.setBounds(225, 92, 270, 25);
        panelCentre.add(ENom);

        JLabel labelOrigine = new JLabel("Origine");
        labelOrigine.setFont(new Font("Calibri", Font.BOLD, 18));
        labelOrigine.setBounds(120, 391, 86, 50);
        panelCentre.add(labelOrigine);

        JLabel EContinents = new JLabel("Continents d'origine");
        EContinents.setFont(new Font("Tahoma", Font.PLAIN, 18));
        EContinents.setBounds(351, 391, 320, 50);
        panelCentre.add(EContinents);

        JLabel labelDuree = new JLabel("Duree de Vie");
        labelDuree.setFont(new Font("Calibri", Font.BOLD, 18));
        labelDuree.setBounds(120, 426, 86, 50);
        panelCentre.add(labelDuree);

        JLabel EDuree = new JLabel("dur�e de vie moyenne");
        EDuree.setFont(new Font("Calibri", Font.PLAIN, 18));
        EDuree.setBounds(351, 426, 200, 50);
        panelCentre.add(EDuree);

        JLabel labelRegime = new JLabel("Regime Alimentaire");
        labelRegime.setFont(new Font("Calibri", Font.BOLD, 18));
        labelRegime.setBounds(120, 462, 200, 50);
        panelCentre.add(labelRegime);

        JLabel EspRegime = new JLabel("regime alimentaire");
        EspRegime.setFont(new Font("Calibri", Font.PLAIN, 18));
        EspRegime.setBounds(351, 462, 200, 50);
        panelCentre.add(EspRegime);

        JLabel labelHabitat = new JLabel("Habitat");
        labelHabitat.setFont(new Font("Calibri", Font.BOLD, 18));
        labelHabitat.setBounds(120, 498, 69, 50);
        panelCentre.add(labelHabitat);

        JLabel EHabitat = new JLabel("habitat naturel");
        EHabitat.setFont(new Font("Calibri", Font.PLAIN, 18));
        EHabitat.setBounds(351, 498, 200, 50);
        panelCentre.add(EHabitat);

        JLabel LabelGestation = new JLabel("Duree Gestation");
        LabelGestation.setVisible(false);
        LabelGestation.setFont(new Font("Calibri", Font.BOLD, 18));
        LabelGestation.setBounds(120, 535, 160, 50);
        panelCentre.add(LabelGestation);

        JLabel EGestation = new JLabel("duree de gestation moyenne");
        EGestation.setVisible(false);
        EGestation.setFont(new Font("Calibri", Font.PLAIN, 18));
        EGestation.setBounds(351, 535, 253, 50);
        panelCentre.add(EGestation);

        JLabel LabelPattes = new JLabel("Nombre Pattes");
        LabelPattes.setFont(new Font("Calibri", Font.BOLD, 18));
        LabelPattes.setVisible(false);
        LabelPattes.setBounds(120, 571, 160, 50);
        panelCentre.add(LabelPattes);

        JLabel EPattes = new JLabel("nombre pattes");
        EPattes.setFont(new Font("Calibri", Font.PLAIN, 18));
        EPattes.setVisible(false);
        EPattes.setBounds(351, 571, 200, 50);
        panelCentre.add(EPattes);

        JLabel LabelBool = new JLabel("Booleen");
        LabelBool.setFont(new Font("Calibri", Font.BOLD, 18));
        LabelBool.setVisible(false);
        LabelBool.setBounds(120, 607, 160, 50);
        panelCentre.add(LabelBool);

        JLabel EBool = new JLabel("dangereux/venimeux/volant");
        EBool.setFont(new Font("Tahoma", Font.PLAIN, 18));
        EBool.setVisible(false);
        EBool.setBounds(351, 607, 253, 50);
        panelCentre.add(EBool);

        Set<Espece> especes = e.getEspeces();
        Iterator<Espece> it = especes.iterator();
        while (it.hasNext()) {
            Espece esp = it.next();
            JButton EspBouton = new JButton(esp.getNom());
            panelAnim.add(EspBouton);
            panelAnim.add(Box.createVerticalStrut(20));
            EspBouton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    im.setVisible(false);
                    ENom.setText(esp.getNom());
                    EContinents.setText(esp.getContinents());
                    EDuree.setText(Integer.toString(esp.getDuree()));
                    EHabitat.setText(esp.getHabitat().toString());
                    EspRegime.setText(esp.getRegime().toString());
                    if (esp instanceof Mammifere) {
                        LabelBool.setVisible(false);
                        EBool.setVisible(false);
                        LabelGestation.setVisible(true);
                        EGestation.setVisible(true);
                        EGestation.setText(Integer.toString(((Mammifere) esp).getGestation()));
                    } else {
                        LabelGestation.setVisible(false);
                        EGestation.setVisible(false);
                    }
                    if (esp instanceof Insecte) {
                        LabelBool.setVisible(false);
                        EBool.setVisible(false);
                        LabelPattes.setVisible(true);
                        EPattes.setVisible(true);
                        EPattes.setText(Integer.toString(((Insecte) esp).getPattes()));
                    } else {
                        LabelPattes.setVisible(false);
                        EPattes.setVisible(false);
                    }
                    if (esp instanceof Arachnide) {
                        LabelBool.setVisible(false);
                        EBool.setVisible(false);
                        LabelPattes.setVisible(true);
                        EPattes.setVisible(true);
                        EPattes.setText(Integer.toString(((Arachnide) esp).getPattes()));
                    } else {
                        LabelPattes.setVisible(false);
                        EPattes.setVisible(false);
                    }
                    if (esp instanceof Reptile) {
                        LabelBool.setVisible(true);
                        LabelBool.setText("Dangereux");
                        EBool.setVisible(true);
                        if (((Reptile) esp).getDangereux()) EBool.setText("Oui");
                        else EBool.setText("Non");
                    }
                    if (esp instanceof Oiseau) {
                        LabelBool.setVisible(true);
                        LabelBool.setText("Volant");
                        EBool.setVisible(true);
                        if (((Oiseau) esp).getVolant()) EBool.setText("Oui");
                        else EBool.setText("Non");
                    }
                    if (esp instanceof Amphibien) {
                        LabelBool.setVisible(true);
                        LabelBool.setText("Venimeux");
                        EBool.setVisible(true);
                        if (((Amphibien) esp).getVenimeux()) EBool.setText("Oui");
                        else EBool.setText("Non");
                    }
                    if (esp instanceof Poisson) {
                        LabelBool.setVisible(true);
                        LabelBool.setText("Type Eau");
                        EBool.setVisible(true);
                        if (((Poisson) esp).getTypeEau()) EBool.setText("Douce");
                        else EBool.setText("Salee");
                    }
                    im = new Photo(unMaj(esp.getNom()));
                    im.setBounds(138, 130, 287, 248);
                    im.setVisible(true);
                    panelCentre.add(im);
                    im.repaint();
                }
            });
        }

    }

    public static String unMaj(String s) {
        String resultat;
        resultat = Character.toLowerCase(s.charAt(0)) + (s.length() > 1 ? s.substring(1) : "") + ".jpg";
        return resultat;
    }
}
