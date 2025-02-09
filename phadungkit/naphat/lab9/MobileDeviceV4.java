package phadungkit.naphat.lab9;

import java.awt.*;
import javax.swing.*;
import phadungkit.naphat.lab8.MobileDeviceV3;

/**
 * This class extends MobileDeviceV3 to add icon functionality and display settings.
 * It includes icons for menu items such as New, Open, Save, and Exit, and configures
 * the size and color settings for the menu options.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 9 February 2025
 */

public class MobileDeviceV4 extends MobileDeviceV3 {

    protected ImageIcon iconNewMenu, iconOpenMenu, iconSaveMenu, iconExitMenu;

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
        MobileDeviceV4 mdv4 = new MobileDeviceV4("Mobile Device V4");
        mdv4.addComponents();
        mdv4.setFrameFeatures();
    }

    // Constructs a new mobile device form with the specified title.
    public MobileDeviceV4(String title) {
        super(title);
    }

    // Loads icons for menu items from image resources.
    public void loadIcon(){
        iconNewMenu = new ImageIcon(getClass().getClassLoader().getResource("phadungkit/naphat/lab9/images/new_icon.png"));
        iconOpenMenu = new ImageIcon(getClass().getClassLoader().getResource("phadungkit/naphat/lab9/images/open_icon.png"));
        iconSaveMenu = new ImageIcon(getClass().getClassLoader().getResource("phadungkit/naphat/lab9/images/save_icon.png"));
        iconExitMenu = new ImageIcon(getClass().getClassLoader().getResource("phadungkit/naphat/lab9/images/exit_icon.png"));
    }

    // Overrides the parent class's addMenus method to customize menu items.
    @Override
    public void addMenus(){
        super.addMenus();
        loadIcon();

        newMenu.setIcon(iconNewMenu);
        openMenu.setIcon(iconOpenMenu);
        saveMenu.setIcon(iconSaveMenu);
        exitMenu.setIcon(iconExitMenu);

        smallMenuItem.setFont(new Font("Arial", Font.PLAIN,10));
        mediumMenuItem.setFont(new Font("Arial", Font.PLAIN,14));
        largeMenuItem.setFont(new Font("Arial", Font.PLAIN,18));
        extraLargeMenuItem.setFont(new Font("Arial", Font.PLAIN,22));

        blackMenuItem.setForeground(Color.BLACK);
        redMenuItem.setForeground(Color.RED);
        greenMenuItem.setForeground(Color.GREEN);
        blueMenuItem.setForeground(Color.BLUE);

        font1MenuItem.setFont(new Font("Serif", Font.PLAIN, 14));
        font2MenuItem.setFont(new Font("SansSerif", Font.PLAIN, 14));
        font3MenuItem.setFont(new Font("Monospaced", Font.PLAIN, 14));
    }

}
