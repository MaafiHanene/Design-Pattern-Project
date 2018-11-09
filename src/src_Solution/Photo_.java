package src_Solution;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Photo_ extends JPanel {
    private BufferedImage image;

    public Photo_(String nomImage) {
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
