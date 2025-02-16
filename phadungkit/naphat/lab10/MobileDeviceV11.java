package phadungkit.naphat.lab10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class extends MobileDeviceV10 and adds keyboard shortcuts for menu items
 * and handling for device type selection. It enhances menu accessibility
 * through mnemonics and accelerators, and improves user interaction with radio
 * buttons for device type selection.
 *
 * Author: Naphat Phadungkit 
 * Student ID: 673040384-5 
 * Sec: 1 
 * Last updated date: 17 February 2025
 */
public class MobileDeviceV11 extends MobileDeviceV10 {

    // Main method to launch the mobile device form.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    // Creates and displays the mobile device form GUI.
    public static void createAndShowGUI() {
        MobileDeviceV11 mdv11 = new MobileDeviceV11("Mobile Device V11");
        mdv11.addComponents();
        mdv11.setFrameFeatures();
        mdv11.addListeners();
    }

    // Constructs a new mobile device form with the specified title.
    public MobileDeviceV11(String title) {
        super(title);
    }

    /**
     * Adds keyboard mnemonics and accelerators to menu items. Sets up keyboard
     * shortcuts for common menu operations: 
     * - New (Ctrl+N) 
     * - Open (Ctrl+O) 
     * - Save (Ctrl+S) 
     * - Exit (Ctrl+Q)
     */
    @Override
    public void addMenus() {
        super.addMenus();
        // Set up mnemonics (Alt + key) for menu items
        newMenu.setMnemonic(KeyEvent.VK_N);
        openMenu.setMnemonic(KeyEvent.VK_O);
        saveMenu.setMnemonic(KeyEvent.VK_S);
        exitMenu.setMnemonic(KeyEvent.VK_X);

        // Set up accelerators (Ctrl + key) for menu items
        newMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        openMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        saveMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        exitMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
    }

    /**
     * Adds action listeners for device type radio buttons. Extends the parent
     * class listener setup to include smartphone and tablet selection handling.
     */
    @Override
    public void addListeners() {
        super.addListeners();
        selectTypeSmartPhone.addActionListener(this);
        selectTypeTablet.addActionListener(this);
    }

    /**
     * Handles action events for the form, including device type selection. When
     * a device type radio button is selected, displays a message dialog showing
     * the selected type.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object src = e.getSource();
        if (src == selectTypeSmartPhone) {
            JOptionPane.showMessageDialog(this, ((JRadioButton) src).getText() + " is selected", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else if (src == selectTypeTablet) {
            JOptionPane.showMessageDialog(this, ((JRadioButton) src).getText() + " is selected", "Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
