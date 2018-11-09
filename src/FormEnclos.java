import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JComboBox;

import Enum.*;


public class FormEnclos extends JFrame {

    protected Zoo zoo;
    private JPanel contentPane;
    private JTextField entrerID;
    private JTextField entrerLng;
    private JTextField entrerLrg;
    private JTextField entrerMax;

    JComboBox<String> comboBox;
    JComboBox entrerTypeEau;
    JComboBox entrerTypeSol;

    private JTextField entrerChamp1;
    private JTextField entrerChamp2;
    private JLabel labelChamp1;
    private JLabel labelChamp2;

    JButton enregistrer;
    JPanel panel;


    public FormEnclos(Zoo zoo) {
        this.zoo = zoo;
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 616, 567);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JLabel titre = new JLabel("Formulaire d'un nouveau Enclos");
        titre.setFont(new Font("Calibri", Font.BOLD, 18));
        contentPane.add(titre, BorderLayout.NORTH);

        panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel labelID = new JLabel("Identifiant");
        labelID.setBounds(43, 37, 57, 16);
        panel.add(labelID);

        entrerID = new JTextField();
        entrerID.setBounds(155, 34, 116, 22);
        panel.add(entrerID);
        entrerID.setColumns(10);

        JLabel labelLng = new JLabel("Longueur ");
        labelLng.setBounds(43, 98, 57, 16);
        panel.add(labelLng);

        entrerLng = new JTextField();
        entrerLng.setBounds(155, 95, 116, 22);
        panel.add(entrerLng);
        entrerLng.setColumns(10);

        JLabel labelLrg = new JLabel("Largeur");
        labelLrg.setBounds(311, 98, 57, 16);
        panel.add(labelLrg);

        entrerLrg = new JTextField();
        entrerLrg.setBounds(399, 95, 116, 22);
        panel.add(entrerLrg);
        entrerLrg.setColumns(10);

        JLabel labelMax = new JLabel("Max d'animaux");
        labelMax.setBounds(43, 153, 85, 16);
        panel.add(labelMax);

        entrerMax = new JTextField();
        entrerMax.setBounds(155, 150, 116, 22);
        panel.add(entrerMax);
        entrerMax.setColumns(10);

        JLabel labelType = new JLabel("Type de l'Enclos");
        labelType.setBounds(39, 203, 92, 16);
        panel.add(labelType);

        comboBox = new JComboBox(new String[]{"Cage", "Aquarium", "Voliere", "Insectarium", "Paludarium"});
        comboBox.setBounds(155, 200, 116, 22);
        comboBox.setSelectedIndex(-1);
        comboBox.addActionListener(new Combo());

        panel.add(comboBox);


        enregistrer = new JButton("Ajouter");
        enregistrer.setBounds(448, 406, 95, 25);
        panel.add(enregistrer);


        class Ajout implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                Enclos enclos = null;
                String selectionne = (String) comboBox.getSelectedItem();


                if (selectionne.equals("Paludarium")) {
                    String typeSol_enum = (String) entrerTypeSol.getSelectedItem();
                    TypeSol type = null;
                    if (typeSol_enum == "Sable") type = TypeSol.Sable;
                    else if (typeSol_enum == "Argile") type = TypeSol.Argile;
                    else if (typeSol_enum == "Roches") type = TypeSol.Roches;
                    else if (typeSol_enum == "Plantes") type = TypeSol.Plantes;
                    else if (typeSol_enum == "Glaces") type = TypeSol.Glaces;
                    try {
                        enclos = new Paludarium(Integer.parseInt(entrerID.getText()), Double.parseDouble(entrerLng.getText()), Double.parseDouble(entrerLrg.getText()), Integer.parseInt(entrerMax.getText()), type, Double.parseDouble(entrerChamp2.getText()));
                    } catch (Exception excep) {
                        JOptionPane.showMessageDialog(null, "Format incorrect");
                    }
                } else if (selectionne.equals("Voliere")) {

                    try {
                        enclos = new Voliere(Integer.parseInt(entrerID.getText()), Double.parseDouble(entrerLng.getText()), Double.parseDouble(entrerLrg.getText()), Integer.parseInt(entrerMax.getText()), Double.parseDouble(entrerChamp2.getText()));
                    } catch (Exception excep) {
                        JOptionPane.showMessageDialog(null, "Format incorrect");
                    }


                } else if (selectionne.equals("Cage")) {
                    String typeSol_enum1 = (String) entrerTypeSol.getSelectedItem();
                    TypeSol type = null;
                    if (typeSol_enum1 == "Sable") type = TypeSol.Sable;
                    else if (typeSol_enum1 == "Argile") type = TypeSol.Argile;
                    else if (typeSol_enum1 == "Roches") type = TypeSol.Roches;
                    else if (typeSol_enum1 == "Plantes") type = TypeSol.Plantes;
                    else if (typeSol_enum1 == "Glaces") type = TypeSol.Glaces;
                    try {
                        enclos = new Cage(Integer.parseInt(entrerID.getText()), Double.parseDouble(entrerLng.getText()), Double.parseDouble(entrerLrg.getText()), Integer.parseInt(entrerMax.getText()), type);
                    } catch (Exception excep) {
                        JOptionPane.showMessageDialog(null, "Format incorrect");
                    }
                } else if (selectionne.equals("Aquarium")) {
                    TypeEau type = null;
                    String typeEau_enum = (String) entrerTypeSol.getSelectedItem();

                    if (typeEau_enum == "Douce") type = TypeEau.Douce;
                    else if (typeEau_enum == "Sal�e") type = TypeEau.Sale;

                    try {
                        enclos = new Aquarium(Integer.parseInt(entrerID.getText()), Double.parseDouble(entrerLng.getText()), Double.parseDouble(entrerLrg.getText()), Integer.parseInt(entrerMax.getText()), Double.parseDouble(entrerChamp2.getText()), type);
                    } catch (Exception excep) {
                        JOptionPane.showMessageDialog(null, "Format incorrect");
                    }
                } else if (selectionne.equals("Insectarium")) {
                    try {
                        enclos = new Insectarium(Integer.parseInt(entrerID.getText()), Double.parseDouble(entrerLng.getText()), Double.parseDouble(entrerLrg.getText()), Integer.parseInt(entrerMax.getText()));
                    } catch (Exception excep) {
                        JOptionPane.showMessageDialog(null, "Format incorrect");
                    }
                }
                try {

                    zoo.ajouterEnclos(enclos);
                    FormZoo.enclos.add(enclos);
                    JOptionPane.showMessageDialog(null, "Enclos ajout� avec succes");
                } catch (Exception excep) {
                    JOptionPane.showMessageDialog(null, "Format Incorrect");
                }


            }
        }
        enregistrer.addActionListener(new Ajout());

    }

    class Combo implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String selected = (String) comboBox.getSelectedItem();

            if (selected.equals("Voliere") || selected.equals("Insectarium")) {

                if (entrerChamp1 != null) panel.remove(entrerChamp1);
                if (labelChamp1 != null) panel.remove(labelChamp1);
                if (entrerChamp2 != null) panel.remove(entrerChamp2);
                if (labelChamp2 != null) panel.remove(labelChamp2);
                if (entrerTypeEau != null) panel.remove(entrerTypeEau);
                if (entrerTypeSol != null) panel.remove(entrerTypeSol);
                entrerChamp1 = new JTextField();
                entrerChamp1.setColumns(10);
                entrerChamp1.setBounds(155, 258, 116, 22);
                panel.add(entrerChamp1);

                labelChamp1 = new JLabel("Hauteur");
                labelChamp1.setBounds(43, 262, 85, 16);
                panel.add(labelChamp1);

                panel.repaint();
            } else if (selected.equals("Cage")) {
                if (entrerChamp1 != null) panel.remove(entrerChamp1);
                if (labelChamp1 != null) panel.remove(labelChamp1);
                if (entrerChamp2 != null) panel.remove(entrerChamp2);
                if (labelChamp2 != null) panel.remove(labelChamp2);
                if (entrerTypeEau != null) panel.remove(entrerTypeEau);
                if (entrerTypeSol != null) panel.remove(entrerTypeSol);

                entrerTypeSol = new JComboBox(new String[]{"Argile", "Sable", "Roches", "Plantes", "Glaces"});
                entrerTypeSol.setSelectedIndex(-1);
                entrerTypeSol.setBounds(155, 258, 116, 22);
                panel.add(entrerTypeSol);


                labelChamp1 = new JLabel("Type de sol ");
                labelChamp1.setBounds(43, 262, 85, 16);
                panel.add(labelChamp1);
                panel.repaint();
            } else if (selected.equals("Aquarium")) {
                if (entrerChamp1 != null) panel.remove(entrerChamp1);
                if (labelChamp1 != null) panel.remove(labelChamp1);
                if (entrerChamp2 != null) panel.remove(entrerChamp2);
                if (labelChamp2 != null) panel.remove(labelChamp2);
                if (entrerTypeEau != null) panel.remove(entrerTypeEau);
                if (entrerTypeSol != null) panel.remove(entrerTypeSol);

                entrerTypeEau = new JComboBox(new String[]{"Douce", "Sal�e"});
                entrerTypeEau.setSelectedIndex(-1);
                entrerTypeEau.setBounds(155, 258, 116, 22);
                panel.add(entrerTypeEau);

                labelChamp1 = new JLabel("Type eau ");
                labelChamp1.setBounds(43, 262, 85, 16);
                panel.add(labelChamp1);

                entrerChamp2 = new JTextField();
                entrerChamp2.setColumns(10);
                entrerChamp2.setBounds(155, 311, 116, 22);
                panel.add(entrerChamp2);

                labelChamp2 = new JLabel("Contenance");
                labelChamp2.setBounds(43, 315, 85, 16);
                panel.add(labelChamp2);
                panel.repaint();
            } else if (selected.equals("Paludarium")) {
                if (entrerChamp1 != null) panel.remove(entrerChamp1);
                if (labelChamp1 != null) panel.remove(labelChamp1);
                if (entrerChamp2 != null) panel.remove(entrerChamp2);
                if (labelChamp2 != null) panel.remove(labelChamp2);
                if (entrerTypeEau != null) panel.remove(entrerTypeEau);
                if (entrerTypeSol != null) panel.remove(entrerTypeSol);

                entrerTypeSol = new JComboBox(new String[]{"Argile", "Sable", "Roches", "Plantes", "Glaces"});
                entrerTypeSol.setSelectedIndex(-1);
                entrerTypeSol.setBounds(155, 258, 116, 22);
                panel.add(entrerTypeSol);

                labelChamp1 = new JLabel("Type de sol ");
                labelChamp1.setBounds(43, 262, 85, 16);
                panel.add(labelChamp1);

                entrerChamp2 = new JTextField();
                entrerChamp2.setColumns(10);
                entrerChamp2.setBounds(155, 311, 116, 22);
                panel.add(entrerChamp2);

                labelChamp2 = new JLabel("Surface eau");
                labelChamp2.setBounds(43, 315, 85, 16);
                panel.add(labelChamp2);

                panel.repaint();
            }

        }
    }
}
