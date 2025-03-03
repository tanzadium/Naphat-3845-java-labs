package phadungkit.naphat.lab11;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class extends MobileDeviceCompleteV2 to create an advanced mobile device
 * form with additional configuration and color customization features. It
 * introduces a new configuration menu with a color submenu that allows users to
 * customize the text color of device information fields.
 *
 * Author: Naphat Phadungkit 
 * Student ID: 673040384-5 
 * Sec: 1 
 * Last updated date: 3 March 2025
 */

public class MobileDeviceCompleteV4 extends MobileDeviceCompleteV2 {

    JMenu configMenu, colorMenu;
    JMenuItem customMenu = new JMenuItem("Custom");

    @Override
    protected void addComponents() {
        super.addComponents();
        addListeners();
    }

    public static void createAndShowGUI() {
        MobileDeviceCompleteV4 mdcv4 = new MobileDeviceCompleteV4("Mobile Device Complete V4");
        mdcv4.addComponents();
        mdcv4.addMenus();
        mdcv4.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater((new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        }));
    }

    public MobileDeviceCompleteV4(String title) {
        super(title);
    }

    @Override
    public void addMenus() {
        super.addMenus();
        configMenu = new JMenu("Config");
        colorMenu = new JMenu("Color");

        colorMenu.add(customMenu);
        configMenu.add(colorMenu);
        menuBar.add(configMenu);
    }

    @Override
    public void addListeners() {
        super.addListeners();
        customMenu.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object src = e.getSource();
        if (src == customMenu) { 
            Color color = JColorChooser.showDialog(null, "Choose Text Color", getForeground());

            deviceNameField.setForeground(color);
            brandField.setForeground(color);
            priceField.setForeground(color);
        }
    }

}
