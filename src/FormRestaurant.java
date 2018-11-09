import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FormRestaurant extends JFrame implements ActionListener {

    private JPanel contentPane;

    private JTextField entrerNom;
    private JTextField entrerSuperficie;
    private JButton creerResto = new JButton("Creer");
    private JLabel titre = new JLabel("Formulaire d'un nouveau Restaurant");
    private JLabel labelNom = new JLabel("Nom");
    private JLabel labelSuperficie = new JLabel("Superficie");
    private JLabel labelUrl = new JLabel("Nom du fichier image:");
    private JTextField entrerUrl;
    private JButton leboutonfleplan;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormRestaurant frame = new FormRestaurant(new JButton("="));
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FormRestaurant(JButton butt) {
        this.leboutonfleplan = butt;
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 616, 567);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));


        titre.setFont(new Font("Calibri", Font.BOLD, 18));
        contentPane.add(titre, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        Box verticalBox = Box.createVerticalBox();
        verticalBox.setBounds(28, 16, 0, 0);
        panel.add(verticalBox);


        labelNom.setBounds(48, 79, 57, 16);
        panel.add(labelNom);

        entrerNom = new JTextField();
        entrerNom.setBounds(220, 76, 116, 22);
        panel.add(entrerNom);
        entrerNom.setColumns(10);


        entrerSuperficie = new JTextField();
        entrerSuperficie.setBounds(220, 111, 116, 22);
        panel.add(entrerSuperficie);
        entrerSuperficie.setColumns(10);


        creerResto.setBounds(448, 406, 95, 25);
        panel.add(creerResto);


        labelSuperficie.setBounds(48, 114, 95, 16);
        panel.add(labelSuperficie);


        labelUrl.setBounds(48, 149, 177, 16);
        panel.add(labelUrl);

        entrerUrl = new JTextField();
        entrerUrl.setColumns(10);
        entrerUrl.setBounds(220, 146, 116, 22);
        panel.add(entrerUrl);

        //----------------------------------------------------------------------------------------------------

        creerResto.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        Restaurant resto = new Restaurant(entrerNom.getText(), Double.parseDouble(entrerSuperficie.getText()), entrerUrl.getText());
        if (resto.getSuperficie() + Zoo.getWinLa79a() <= Zoo.getSuperficie() && resto.count + 1 < 6) {
            Zoo.setWinLa79a(Zoo.getWinLa79a() + resto.getSuperficie());
            resto.count++;
            leboutonfleplan.setBackground(Color.PINK);
            leboutonfleplan.setForeground(Color.BLACK);
            leboutonfleplan.setText("R");
            this.dispose();
        } else {
            if (resto.count + 1 == 6)
                JOptionPane.showMessageDialog(null, "Pas plus de 5 Restaurants");
            else
                JOptionPane.showMessageDialog(null, "Surface insuffisante");
        }
    }


}
