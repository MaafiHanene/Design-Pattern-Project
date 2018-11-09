import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import Enum.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;


public class Menu_Principal extends JFrame {
    private JPanel panel1;


    public static void main(String[] args) {

        Enclos e1 = new Aquarium(001, 3, 2, 10, 60, TypeEau.Douce);
        Enclos e2 = new Insectarium(2, 5, 2, 20);
        Enclos e3 = new Aquarium(3, 4, 2, 12, 80, TypeEau.Sale);
        Enclos e4 = new Cage(4, 20, 10, 3, TypeSol.Plantes);
        Enclos e5 = new Paludarium(5, 30, 10, 4, TypeSol.Argile, 100);
        Enclos e6 = new Voliere(6, 10, 12, 10, 10);
        Enclos e7 = new Cage(7, 50, 10, 6, TypeSol.Roches);
        Enclos e8 = new Cage(8, 35, 10, 4, TypeSol.Plantes);
        Enclos e9 = new Paludarium(9, 50, 10, 3, TypeSol.Glaces, 200);

        formulaireZoo.enclos.add(e1);
        formulaireZoo.enclos.add(e2);
        formulaireZoo.enclos.add(e3);
        formulaireZoo.enclos.add(e4);
        formulaireZoo.enclos.add(e5);
        formulaireZoo.enclos.add(e6);
        formulaireZoo.enclos.add(e7);
        formulaireZoo.enclos.add(e8);
        formulaireZoo.enclos.add(e9);

        Animal a1 = new Animal(new Espece("lion.esp"));
        Animal a2 = new Animal(new Espece("lion.esp"));
        Animal a3 = new Animal(new Espece("lion.esp"));
        Animal a4 = new Animal(new Espece("mouton.esp"));
        Animal a5 = new Animal(new Espece("abeille.esp"));
        Animal a6 = new Animal(new Espece("abeille.esp"));
        Animal a7 = new Animal(new Espece("abeille.esp"));

        placer_animal.animaux.add(a1);
        placer_animal.animaux.add(a2);
        placer_animal.animaux.add(a3);
        placer_animal.animaux.add(a4);
        placer_animal.animaux.add(a5);
        placer_animal.animaux.add(a6);
        placer_animal.animaux.add(a7);


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu_Principal frame = new Menu_Principal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private Panneau panel;


    public Menu_Principal() {
        //this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        setBounds(100, 100, 985, 550);


        panel1 = new Panneau();
        getContentPane().add(panel1);
        panel1.setBackground(new Color(20, 180, 140));
        panel1.setLayout(null);


        JButton nouveauZoo = new JButton(" Nouveau Zoo ");
        nouveauZoo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JFrame form = new formulaireZoo();
            }
        });
        nouveauZoo.setBackground(Color.GRAY);
        nouveauZoo.setIcon(new ImageIcon("icon1.png"));
        nouveauZoo.setBounds(100, 150, 200, 200);
        panel1.add(nouveauZoo);

        JButton chargerZoo = new JButton("Charger Zoo ");
        chargerZoo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Zoo Files", "zoo");
                fc.setFileFilter(filter);
                JFrame choix = new JFrame();
                choix.setVisible(true);
                choix.setBounds(100, 100, 900, 500);
                choix.getContentPane().add(fc);
                fc.setVisible(true);
            }
        });
        chargerZoo.setIcon(new ImageIcon("icon2.png"));
        chargerZoo.setBackground(Color.GRAY);
        chargerZoo.setBounds(370, 150, 200, 200);
        panel1.add(chargerZoo);

        JButton visiteur = new JButton("Visiteur");
        visiteur.setIcon(new ImageIcon("icon3.png"));
        visiteur.setBackground(Color.GRAY);
        visiteur.setBounds(650, 150, 200, 200);
        panel1.add(visiteur);


    }
}
