package src_Problem01;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Enum.EtatSante;

public class FormulaireAnimal_ extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JButton ajout = new JButton("Ajouter");
    private JTextField entrerRace = new JTextField();
    JTextField entrerPoids = new JTextField();
    private JTextField entrerDate = new JTextField();

    private JComboBox<String> espece = new JComboBox<String>(new String[]{"abeille", "addax", "araignee", "autruche", "crapaud_commun", "escargot", "fourmi", "lion", "mouton", "poisson_mandarin"});
    private JComboBox<String> etat_sante = new JComboBox<String>(new String[]{"Gravement malade", "Malade", "Bonne sante"});
    private GestionZoo_ z;
    private Animal_ nvAnimal = new Animal_();
    private int numero_enclos;
    private Enclos_ enclos;


    public FormulaireAnimal_(GestionZoo_ zoo) {
        z = zoo;
        this.setVisible(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        setBounds(400, 60, 600, 600);
        contentPane.setLayout(null);

        JLabel titre = new JLabel("Formulaire Animal");
        titre.setBounds(75, 15, 399, 20);
        contentPane.add(titre);
        Font font = new Font("Century Gothic", Font.BOLD, 18);
        titre.setFont(font);


        JLabel LabelEspece = new JLabel("Espece");
        LabelEspece.setBounds(10, 78, 300, 20);
        contentPane.add(LabelEspece);

        espece.setBounds(400, 70, 150, 20);
        contentPane.add(espece);


        JLabel LabelRace = new JLabel("Race");
        LabelRace.setBounds(10, 120, 300, 20);
        contentPane.add(LabelRace);

        entrerRace.setText("");
        entrerRace.setBounds(400, 120, 150, 20);
        contentPane.add(entrerRace);

        JLabel LabelDate = new JLabel("Date de naissance");
        LabelDate.setBounds(10, 170, 300, 20);
        contentPane.add(LabelDate);

        entrerDate.setText("");
        entrerDate.setBounds(400, 170, 150, 20);
        contentPane.add(entrerDate);

        JLabel LabelSante = new JLabel("Etat de sant� ");
        LabelSante.setBounds(10, 218, 300, 20);
        contentPane.add(LabelSante);

        etat_sante.setBounds(400, 220, 150, 20);
        contentPane.add(etat_sante);


        JLabel titre_poids = new JLabel("Entrez le poids de l'animal");
        titre_poids.setBounds(10, 339, 300, 20);
        contentPane.add(titre_poids);


        entrerPoids.setText("");
        entrerPoids.setBounds(400, 360, 150, 20);
        contentPane.add(entrerPoids);


        ajout.setBounds(314, 470, 135, 42);
        ajout.addActionListener(this);
        contentPane.add(ajout);
    }

    public int getNumero_enclos() {
        return enclos.getAdr();

    }

    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == ajout) {
            if (!(entrerRace.getText()).equals("") && (!(entrerDate.getText()).equals("")) && (!(entrerPoids.getText()).equals(""))) {
                nvAnimal.setRace(entrerRace.getText());
                nvAnimal.setDate(entrerDate.getText());
                nvAnimal.setPoids(Integer.parseInt(entrerPoids.getText()));

                String s = espece.getSelectedItem().toString();
              /*  switch (s) {
                    case "abeille":
                      //  Espece_ esp1 = new Insecte("abeille.esp");
                        nvAnimal.setEspece(esp1);
                        break;
                    case "addax":
                      //  Espece esp2 = new Mammifere("addax.esp");
                        nvAnimal.setEspece(esp2);
                        break;
                    case "araignee":
                      //  Espece esp3 = new Arachnide("araignee.esp");
                        nvAnimal.setEspece(esp3);
                        break;
                    case "autruche":
                        Espece esp4 = new Oiseau("autruche.esp");
                        nvAnimal.setEspece(esp4);
                        break;
                    case "crapaud_commun":
                        Espece esp5 = new Amphibien("crapaud_commun.esp");
                        nvAnimal.setEspece(esp5);
                        break;
                    case "escargot":
                        Espece esp6 = new Mollusque("escargot.esp");
                        nvAnimal.setEspece(esp6);
                        break;
                    case "fourmi":
                        Espece esp7 = new Insecte("fourmi.esp");
                        nvAnimal.setEspece(esp7);
                        break;
                    case "lion":
                        Espece esp8 = new Mammifere("lion.esp");
                        nvAnimal.setEspece(esp8);
                        break;
                    case "mouton":
                        Espece esp9 = new Mammifere("mouton.esp");
                        nvAnimal.setEspece(esp9);
                        break;
                    case "poisson_mandarin":
                        Espece esp10 = new Poisson("poisson_mandarin.esp");
                        nvAnimal.setEspece(esp10);
                        break;

                }

                String e = etat_sante.getSelectedItem().toString();
                switch (e) {
                    case "Gravement malade":
                        EtatSante etat1 = EtatSante.GravementMalade;
                        nvAnimal.setSante(etat1);
                        break;
                    case "Malade":
                        EtatSante etat2 = EtatSante.Malade;
                        nvAnimal.setSante(etat2);
                        break;
                    case "Bonne sante":
                        EtatSante etat3 = EtatSante.BonneSante;
                        nvAnimal.setSante(etat3);
                        break;

                }*/

            } else {
                JOptionPane.showMessageDialog(null, "veuillez revoir les donn�es");
            }

            //Orienteranim pA = new Orienteranim(z, nvAnimal);

        }
    }

}
