import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class FormulaireAnimal extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JButton ajout = new JButton("Ajouter"); //bouton de validation de l'ajout d'un animal 
	private JTextField race = new JTextField();// recuperer la race de l'animal 
	private JTextField date_naiss = new JTextField();// recuperer la date de naissance de l'animal 
	private JTextField parents = new JTextField();// recuperer le nom du pere 
	private JTextField poids = new JTextField();// recuperer le poids de l'animal
	private JComboBox<String> espece = new JComboBox<String>(new String[]{"abeille", "addax","araignee","autruche","crapaud_commun","escargot","fourmi","lion","mouton","poisson_mandarin"});
	private JComboBox<String> etat_sante = new JComboBox<String>(new String[]{"Gravement malade", "Malade", "Bonne sante"});
	private Zoo z ; 
	private Animal nvAnimal = new Animal(); 
	private int numero_enclos ; // le numero de l'enclos ou l'animal a été ajouté que je vais utiliser dans l'interface du 
									// plan pour montrer en rouge la case coresspendante 
	private Enclos enclos; 
	private ChoisirEmplacement choisirEmplacement ; 
	
	
	public FormulaireAnimal(Zoo zoo,ChoisirEmplacement cE) 
	{
		choisirEmplacement = cE; 
		z= zoo; 
		this.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setBounds(400,60,600, 600);
		contentPane.setLayout(null);
		
		JLabel titre = new JLabel("Veuillez remplir ce formulaire s'i vous plait"); 
		titre.setBounds(75,15,399,20); 
		contentPane.add(titre);
		// changer les caracteristiques du titre la taille, le type d'ecriture ... 
		Font font = new Font("Arial",Font.BOLD,18);
        titre.setFont(font);
        
		// choisir l''espece de l'animal 
        JLabel titre_espece = new JLabel("Selectionnez l'espece à laquelle appartient l'animal"); 
        titre_espece.setBounds(10,78,300,20); 
        contentPane.add( titre_espece); 
        
		espece.setBounds( 400, 70, 150, 20 );
		contentPane.add( espece );
		
		// donner la race de l'naimal 
		 JLabel titre_race = new JLabel("Entrez la race de l'animal"); 
	     titre_race.setBounds(10,120,300,20); 
	     contentPane.add( titre_race);
	     
	     race.setText("");
	     race.setBounds( 400, 120, 150, 20 );
	     contentPane.add(race);
	  
	    // donner la date de naissance de l'animal 
	   JLabel titre_date = new JLabel("Entrez la date de naissance de l'animal"); 
	   titre_date.setBounds(10,170,300,20); 
	   contentPane.add(titre_date);
	 	
	   date_naiss.setText("");
	   date_naiss.setBounds( 400, 170, 150, 20 );
	   contentPane.add(date_naiss);
	    
	   // choisir l'etat de santé de l'animal 
       JLabel titre_sante = new JLabel("Selectionnez l'etat de santé de l'animal"); 
       titre_sante.setBounds(10,218,300,20); 
       contentPane.add(titre_sante); 
       
	   etat_sante.setBounds( 400, 220, 150, 20 );
	   contentPane.add(etat_sante);
	    

	   // donner le nom du pere de l'animal
	   JLabel titre_parents = new JLabel("Entrez le nom du pere de l'animal"); 
	   titre_parents.setBounds(10,272,300,20); 
	   contentPane.add(titre_parents);

	   parents.setText(""); 
	   parents.setBounds( 400, 290, 150, 20 );
	   contentPane.add(parents);
	   
	   // donner le poids de l'animal 
	   JLabel titre_poids = new JLabel("Entrez le poids de l'animal"); 
	   titre_poids.setBounds(10,339,300,20); 
	   contentPane.add(titre_poids);
	 	    
	   poids.setText("");
	   poids.setBounds( 400, 360, 150, 20 );
	   contentPane.add(poids);
	   
	   // le bouton de validation de l'ajout
	  
	   ajout.setBounds(314,470, 135, 42);
	   ajout.addActionListener(this);
	   contentPane.add(ajout); 
	}
	/** getter */
	public int getNumero_enclos()
	{
		return enclos.getAdresse(); 
		
	}

	public void actionPerformed(ActionEvent a) 
	{
		if (a.getSource()== ajout)
		{
			if (!(race.getText()).equals("") && (!(date_naiss.getText()).equals("")) && (!(parents.getText()).equals("")) && (!(poids.getText()).equals("")))
			{
				nvAnimal.setRace(race.getText());
				nvAnimal.setDate_de_naissance(date_naiss.getText()); 
				nvAnimal.setParents(parents.getText());
				nvAnimal.setPoids(Integer.parseInt(poids.getText()));
				// recuperer l'espece 
				String s = espece.getSelectedItem().toString(); 
				switch (s)
				{
					case "abeille" :
						ArrayList<String> orig = new ArrayList<String>(); 
						orig.add("Afrique"); 
						orig.add("Amérique"); 
						orig.add(" Asie"); 
						orig.add("Europe"); 
						orig.add("Océanie");
						Espece esp1 = new Invertebre("Abeille",orig, 4,1,Habitat.Air, RegimeAlimentaire.Herbivore,6,TypeInvertebre.Insecte);   
						nvAnimal.setEspece(esp1);
						break; 
					case "addax" :
						ArrayList<String> orig2 =  new ArrayList<String>(); 
						orig2.add("Afrique"); 
						Espece esp2 = new Mammifere("Addax", orig2,28,2,Habitat.Terre, RegimeAlimentaire.Herbivore,10); 
						nvAnimal.setEspece(esp2);
						break; 
					case "araignee" :
						ArrayList<String> orig3 =  new ArrayList<String>(); 
						orig3.add("Afrique"); 
						orig3.add("Amérique"); 
						orig3.add(" Asie"); 
						orig3.add("Europe"); 
						orig3.add("Océanie");
						Espece esp3 = new Invertebre("Araignee",orig3, 2,3,Habitat.Terre, RegimeAlimentaire.Carnivore,8,TypeInvertebre.Arachnide); 
						nvAnimal.setEspece(esp3); 
						break; 
					case "autruche":
						ArrayList<String> orig4 =  new ArrayList<String>(); 
						orig4.add("Afrique"); 
						Espece esp4 = new Oiseau("Autruche", orig4,40,4,Habitat.Terre, RegimeAlimentaire.Omnivore,false) ;
						nvAnimal.setEspece(esp4); 
						break; 
					case "crapaud_commun":
						ArrayList<String> orig5 =  new ArrayList<String>(); 
						orig5.add("Afrique");
						orig5.add("Asie"); 
						orig5.add("Europe");
						Espece esp5 = new Amphibien("Crapaud commun(Bufobufo)",orig5, 12, 5,Habitat.EauEtTerre, RegimeAlimentaire.Carnivore,true); 
						nvAnimal.setEspece(esp5); 
						break; 
					case "escargot" :
						ArrayList<String> orig6 =  new ArrayList<String>(); 
						orig6.add("Afrique"); 
						orig6.add("Amérique"); 
						orig6.add(" Asie"); 
						orig6.add("Europe"); 
						orig6.add("Océanie");
						Espece esp6 = new Invertebre("Escargot",orig6,7,6,Habitat.Terre,RegimeAlimentaire.Herbivore,0,TypeInvertebre.Mollusque); 
						nvAnimal.setEspece(esp6); 
						break ; 
					case "fourmi" :
						ArrayList<String> orig7 =  new ArrayList<String>(); 
						orig7.add("Afrique"); 
						orig7.add("Amérique"); 
						orig7.add(" Asie"); 
						orig7.add("Europe"); 
						orig7.add("Océanie");
						Espece esp7 = new Invertebre("Fourmi",orig7,(int) (28.67),7,Habitat.Terre, RegimeAlimentaire.Omnivore,6,TypeInvertebre.Insecte); 
						nvAnimal.setEspece(esp7); 
						break; 
					case "lion" : 
						ArrayList<String> orig8 =  new ArrayList<String>();
						orig8.add("Afrique"); 
						orig8.add("Asie"); 
						Espece esp8 = new  Mammifere("Lion", orig8,14,8,Habitat.Terre, RegimeAlimentaire.Carnivore,4); 
						nvAnimal.setEspece(esp8); 
						break ; 
					case "mouton" :
						ArrayList<String> orig9=  new ArrayList<String>();
						orig9.add("Afrique"); 
						orig9.add("Amérique"); 
						orig9.add(" Asie"); 
						orig9.add("Europe"); 
						orig9.add("Océanie"); 
						Espece esp9 = new Mammifere("Mouton",orig9,12,9,Habitat.Terre,RegimeAlimentaire.Herbivore,5); 
						nvAnimal.setEspece(esp9); 
						break ; 
					case "poisson_mandarin" :
						ArrayList<String> orig10 =  new ArrayList<String>(); 
						orig10.add("Amérique"); 
						orig10.add("Asie");
						orig10.add("Océanie");
						Espece esp10 = new Poisson("poisson mandarin",orig10, 4,10,Habitat.Eau, RegimeAlimentaire.Carnivore,20,TypeEau.Douce); 
						nvAnimal.setEspece(esp10); 
						break;
			
				}
				//recuperer l'etat de sante
				String e= etat_sante.getSelectedItem().toString(); 
				switch (e)
				{
				case "Gravement malade" : 
					EtatDeSante etat1 = EtatDeSante.Gravement_malade; 
				    nvAnimal.setEtat_sante(etat1);
				    System.out.println("Gravement malade"); 
					break ; 
				case  "Malade" :
					EtatDeSante etat2 = EtatDeSante.Malade; 
					 nvAnimal.setEtat_sante(etat2);
					 System.out.println("Malade"); 
					 break; 
				case "Bonne sante":
					EtatDeSante etat3 = EtatDeSante.Bonne_sante; 
					 nvAnimal.setEtat_sante(etat3);
					 System.out.println("Bonne_sante");
					 break; 
					
				}
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "remplir tout les champs s'il vous plait");
		    }
			if (z.EnclosConvenant(nvAnimal) == null)
			{
				this.dispose();
				JOptionPane.showMessageDialog(null, "L'ajout a échoué ! Y a pas d'enclos convenant a cet animal ! ");
			}
			
			else 
			{
				
				enclos = z.EnclosConvenant(nvAnimal); 
				numero_enclos = (z.EnclosConvenant(nvAnimal)).ajouter(nvAnimal);
				ArrayList<JButton> liste = choisirEmplacement.getListeBoutons(); 
				java.util.Iterator<JButton> it = liste.iterator(); 
				Color ancienne_couleur = null ;JButton btn_actuel = null;
				boolean boo = false; 
				while (it.hasNext() && boo == false)
				{
					btn_actuel =it.next() ;
				    if (Integer.parseInt(btn_actuel.getText()) == enclos.getAdresse())
				    {
				    	ancienne_couleur = btn_actuel.getBackground(); 
				    	btn_actuel.setBackground(Color.RED);
				    	boo = true; 
				    }
				}
				this.dispose();
				JOptionPane.showMessageDialog(null, "l'animal a été ajouté avec succes !");
				btn_actuel.setBackground(ancienne_couleur);
				
			}
			
		}
	}

}
