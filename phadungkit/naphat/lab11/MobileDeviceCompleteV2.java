package phadungkit.naphat.lab11;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * This class extends MobileDeviceComplete to add action listeners and menu
 * shortcuts. It adds functionality to text fields and configures menu item
 * shortcuts.
 *
 * Author: Naphat Phadungkit 
 * Student ID: 673040384-5 
 * Sec: 1 
 * Last updated date: 03 March 2025
 */
public class MobileDeviceCompleteV2 extends MobileDeviceComplete implements ActionListener {

    public MobileDeviceCompleteV2(String title) {
        super(title);
    }

    /**
     * Main method to launch the mobile device application.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater((new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        }));
    }

    /**
     * Creates and displays the GUI for the mobile device form.
     */
    public static void createAndShowGUI() {
        MobileDeviceCompleteV2 mdc2 = new MobileDeviceCompleteV2("Mobile Device Complete V2");
        mdc2.addComponents();
        mdc2.addMenus();
        mdc2.setFrameFeatures();
        mdc2.addListeners();
    }

    /**
     * Adds action listeners to the text fields.
     */
    public void addListeners() {
        deviceNameField.addActionListener(this);
        brandField.addActionListener(this);
        priceField.addActionListener(this);
    }

    /**
     * Adds menus and configures menu item shortcuts. Extends the parent class
     * method to add keyboard shortcuts.
     */
    @Override
    public void addMenus() {
        super.addMenus();
        exitMI.setMnemonic(KeyEvent.VK_X);
        exitMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    }

    /**
     * Handles action events from text fields. Shows a message dialog when the
     * user presses Enter in a text field.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == deviceNameField) {
            JOptionPane.showMessageDialog(this, "You pressed enter in Device Name field: " + deviceNameField.getText(), "Notification", JOptionPane.INFORMATION_MESSAGE);
        } else if (src == brandField) {
            JOptionPane.showMessageDialog(this, "Brand field says: " + brandField.getText(), "Notification", JOptionPane.INFORMATION_MESSAGE);
        } else if (src == priceField) {
            JOptionPane.showMessageDialog(this, "Price entered: " + priceField.getText(), "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
