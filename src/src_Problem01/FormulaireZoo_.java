package src_Problem01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FormulaireZoo_ extends JFrame implements ActionListener{

	private ArrayList<Porte_> portes = new ArrayList<Porte_>();
	private JPanel contentPane;
	private JTextField entrerNom;
	private JTextField entrerDate;
	private JTextField entrerSurface;
	private JTextField entrerVille;
	private JTextField entrernbmax = new JTextField();
	private JButton creerZoo = new JButton("Creer");
	private JLabel titre = new JLabel("Formulaire d'un nouveau Zoo");
	private JLabel labelNom = new JLabel("Nom");
	private JLabel labelDate = new JLabel("Date d'Ouverture");
	private JLabel labelSurface = new JLabel("Surface");
	private JLabel labelVille = new JLabel("Ville");
	private JButton PlacerPortes = new JButton("Placer Portes et Resaurants");
	private JLabel labelNombreMax = new JLabel("Nombre max de cases");
	private JLabel labelMaximum = new JLabel("Maximum 40 !");
	private Placement_ placer;
	public static TreeSet<Enclos_> enclos = new TreeSet<Enclos_>();



	public FormulaireZoo_() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 616, 567);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		titre.setBackground(Color.DARK_GRAY);


		titre.setFont(new Font("Century Gothic", Font.BOLD, 18));
		contentPane.add(titre, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);


		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(28, 16, 0, 0);



		labelNom.setBounds(66, 79, 57, 16);
		panel.add(labelNom);

		entrerNom = new JTextField();
		entrerNom.setText("");
		entrerNom.setBounds(220, 76, 116, 22);
		entrerNom .setColumns(10);


		labelDate.setBounds(66, 153, 128, 16);


		entrerDate = new JTextField();
		entrerDate.setText("");
		entrerDate.setBounds(220, 150, 116, 22);
		entrerDate.setColumns(10);


		labelSurface.setBounds(66, 188, 85, 16);


		entrerSurface = new JTextField();
		entrerSurface.setText("");
		entrerSurface.setBounds(220, 185, 116, 22);
		entrerSurface.setColumns(10);


		labelVille.setBounds(66, 116, 85, 16);


		entrerVille = new JTextField();
		entrerVille.setText("");
		entrerVille.setBounds(220, 111, 116, 22);
		entrerVille.setColumns(10);

		creerZoo.setForeground(Color.WHITE);
		creerZoo.setBackground(Color.BLACK);
		creerZoo.setEnabled(false);
		creerZoo.setBounds(398, 406, 145, 25);

		PlacerPortes.setBackground(Color.BLACK);

		PlacerPortes.setForeground(Color.LIGHT_GRAY);
		PlacerPortes.setBounds(318, 316, 225, 48);

		panel.setLayout(null);
		panel.add(verticalBox);
		panel.add(entrerNom);
		panel.add(labelDate);
		panel.add(entrerDate);
		panel.add(labelSurface);
		panel.add(entrerSurface);
		panel.add(labelVille);
		panel.add(entrerVille);
		panel.add(creerZoo);
		panel.add(PlacerPortes);

		entrernbmax.setText("");
		entrernbmax.setColumns(10);
		entrernbmax.setBounds(220, 218, 116, 22);

		panel.add(entrernbmax);
		labelNombreMax.setBounds(66, 221, 154, 16);
		panel.add(labelNombreMax);
		labelMaximum.setForeground(Color.RED);
		labelMaximum.setBounds(350, 221, 116, 16);
		panel.add(labelMaximum);


		//------------------------------------------------------------------------------------------------------


		PlacerPortes.addActionListener(this);
		creerZoo.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == PlacerPortes){
			if(entrernbmax.getText() == "") JOptionPane.showMessageDialog(null,"Entrer le nombre de cases !");
			else{
			placer = new Placement_(Integer.parseInt(entrernbmax.getText()));
			placer.setVisible(true);
			creerZoo.setEnabled(true);
			}
		}

		if(e.getSource() == creerZoo){
			if (entrerNom.getText().compareTo("") == 0 || entrerVille.getText().compareTo("") == 0 || entrerSurface.getText().compareTo("") == 0 || entrerDate.getText().compareTo("")== 0 ){
				JOptionPane.showMessageDialog(null,"Veuillez completer tout les champs");
			}
			else{
				try{
				Zoo_ z = new Zoo_(entrerNom.getText(),entrerDate.getText(),Double.parseDouble(entrerSurface.getText()),entrerVille.getText());
				GestionZoo_.gestionPortes.ajouterPorte();
				InterfaceGestion_ g = new InterfaceGestion_(null);
				}
				catch (Exception excep){JOptionPane.showMessageDialog(null,"Veuillez revoir les donnees");}

				//PlanZoo p = new PlanZoo(Integer.parseInt(entrernbmax.getText()));
				//p.placerEnclos(enclos);
				this.dispose();
				//JFrame f = new InterfaceGestion(new Zoo(entrerNom.getText(),entrerDate.getText(),Double.parseDouble(entrerSurface.getText()),entrerVille.getText(),portes));
			}
		}

	}
}
