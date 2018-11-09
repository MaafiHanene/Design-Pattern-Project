import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Fond extends JPanel {

    private BufferedImage backgroundImage;


    public Fond(String fileName) throws IOException {
        backgroundImage = ImageIO.read(new File(fileName));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(backgroundImage,0,0,this);
    }
}