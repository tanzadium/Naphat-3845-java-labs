package phadungkit.naphat.lab11;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * A JPanel subclass designed to read and display image files. This class
 * provides two constructors for loading images: 1. A default constructor that
 * loads a specific image (S25-ultra.jpg) 2. A parameterized constructor that
 * allows loading an image by filename
 *
 * The class overrides paintComponent to render the loaded image on the panel.
 *
 * Author: Naphat Phadungkit Student ID: 673040384-5 Sec: 1 Last updated date:
 * 27 January 2025
 */

public class ReadImage extends JPanel {

    BufferedImage img;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }

    public ReadImage() {
        try {
            img = ImageIO.read(getClass().getResource("phadungkit/naphat/lab9/images/S25-ultra.jpg"));
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    public ReadImage(String fileName) {
        String name = "./phadungkit/naphat/lab9/images/" + fileName;
        try {
            img = ImageIO.read(getClass().getResource(name));
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }
}
