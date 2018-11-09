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


public class afficher_resto extends JFrame {

	private JPanel contentPane;
	private Photo im = new Photo("");
	
	public static void main(String[] args) {

		Restaurant r = new Restaurant("restau",5,"resto2.jpg");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					afficher_resto frame = new afficher_resto(r);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public afficher_resto(Restaurant r) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 894, 797);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelAnimaux = new JPanel();
		contentPane.add(panelAnimaux, BorderLayout.WEST);
		panelAnimaux.setLayout(new BoxLayout(panelAnimaux, BoxLayout.Y_AXIS));
		
		
		JPanel panelTitre = new JPanel();
		contentPane.add(panelTitre, BorderLayout.NORTH);
		
		JPanel panelCentre = new JPanel();
		contentPane.add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(null);
		
				
		JLabel ENom = new JLabel("Nom Restaurant");
		ENom.setFont(new Font("Calibri", Font.BOLD, 18));
		ENom.setBounds(355, 56, 270, 25);
		panelCentre.add(ENom);
		
		JLabel labelOrigines = new JLabel("superficie");
		labelOrigines.setFont(new Font("Calibri", Font.BOLD, 18));
		labelOrigines.setBounds(225, 536, 115, 50);
		panelCentre.add(labelOrigines);
		
		JLabel EAdr = new JLabel("");
		EAdr.setFont(new Font("Tahoma", Font.PLAIN, 18));
		EAdr.setBounds(447, 536, 320, 50);
		panelCentre.add(EAdr);
		
		
			Restaurant esp = r;
			
			
					im.setVisible(false);
					ENom.setText(esp.getNom());
					EAdr.setText(String.valueOf((esp.getSuperficie())));
					
					im = new Photo((esp.getUrl()));
					im.setBounds(138, 130, 591, 393);
					im.setVisible(true);
					panelCentre.add(im);
					im.repaint();
				
			
		}
		
	

}
