import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Image extends JPanel {
    private BufferedImage image;

    public Image(String nomImage) {
        try {
            image = ImageIO.read(new File(nomImage));
        } catch (IOException ex) {

        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

}
