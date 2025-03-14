package phadungkit.naphat.lab9;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

/**
 * Custom JPanel class for displaying a mobile device image. Loads and renders
 * an image centered within the panel.
 *
 * Author: Naphat Phadungkit Student ID: 673040384-5 Sec: 1 Last updated date:
 * 10 February 2025
 */
public class ReadImage extends JPanel {

    protected BufferedImage img;
    protected Image deviceImage;

    // Constructs the image panel and Loads the device image from resources and sets a white background.
    public ReadImage() {
        ImageIcon icon = new ImageIcon(getClass().getClassLoader()
                .getResource("phadungkit/naphat/lab9/images/S25-ultra.jpg"));
        deviceImage = icon.getImage();
        setBackground(Color.WHITE);
    }

    public ReadImage(String fileName) {
        String name = "phadungkit/naphat/lab9/images/" + fileName;
        ImageIcon icon = new ImageIcon(getClass().getClassLoader()
                .getResource(name));
        deviceImage = icon.getImage();
        setBackground(Color.WHITE);
    }

    // Overrides paintComponent to custom render the image. Scales and centers the image within the panel.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (deviceImage != null) {
            int width = (int) (getWidth() * 0.8);
            int height = width * deviceImage.getHeight(this) / deviceImage.getWidth(this);

            int x = (getWidth() - width) / 2;
            int y = (getHeight() - height) / 2;

            g.drawImage(deviceImage, x, y, width, height, this);
        }
    }
}
