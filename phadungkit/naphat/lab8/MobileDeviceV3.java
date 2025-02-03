package phadungkit.naphat.lab8;

import javax.swing.*;

/**
 * This class extends MobileDeviceV2 to add menu functionality.
 * It includes a menu bar with File and Config options, allowing users
 * to perform file operations and configure display settings.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 27 January 2025
 */
public class MobileDeviceV3 extends MobileDeviceV2 {
    
    protected JPanel barPanel;
    protected JMenuBar menuBar;
    protected JMenu fileMenu, configMenu;
    protected JMenu sizeMenu, colorMenu, fontMenu;
    protected JMenuItem newMenu, openMenu, saveMenu, exitMenu;
    protected JMenuItem smallMenuItem, mediumMenuItem, largeMenuItem, extraLargeMenuItem;
    protected JMenuItem blackMenuItem, redMenuItem, greenMenuItem, blueMenuItem;
    protected JMenuItem font1MenuItem, font2MenuItem, font3MenuItem;
    protected JMenuItem[] fileMenuItems,configSizeMenuItems,configColorMenuItems,configFontMenuItems;

    // Main method to launch the menu-enabled mobile device form.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    // Creates and displays the menu-enabled mobile device form GUI.
    public static void createAndShowGUI() {
        MobileDeviceV3 mdv3 = new MobileDeviceV3("Mobile Device V3");
        mdv3.addComponents();
        mdv3.setFrameFeatures();
    }

    // Constructs a new menu-enabled form with the specified title.
    public MobileDeviceV3(String title) {
        super(title);
    }

    // Creates the File menu with New, Open, Save, and Exit options.
    public void createFileMenu() {
        fileMenu = new JMenu("File");
        newMenu = new JMenuItem("New");
        openMenu = new JMenuItem("Open");
        saveMenu = new JMenuItem("Save");
        exitMenu = new JMenuItem("Exit");
        
        fileMenuItems = new JMenuItem[]{newMenu, openMenu, saveMenu, exitMenu};
        for (JMenuItem itemMenu : fileMenuItems) {
            fileMenu.add(itemMenu);
        }
        
        menuBar.add(fileMenu);
    }

    // Creates the Config menu as a container for configuration submenus.
    public void createConfigMenu() {
        configMenu = new JMenu("Config");
        menuBar.add(configMenu);
    }

    // Creates the Size submenu with various size options.
    public void createConfigSizeMenu() {
        sizeMenu = new JMenu("Size");
        smallMenuItem = new JMenuItem("Small");
        mediumMenuItem = new JMenuItem("Medium");
        largeMenuItem = new JMenuItem("Large");
        extraLargeMenuItem = new JMenuItem("Extra Large");
        
        configSizeMenuItems = new JMenuItem[]{smallMenuItem, mediumMenuItem, largeMenuItem, extraLargeMenuItem};
        for (JMenuItem itemMenu : configSizeMenuItems) {
            sizeMenu.add(itemMenu);
        }
        
        configMenu.add(sizeMenu);
    }

    // Creates the Color submenu with various color options.
    public void createConfigColorMenu() {
        colorMenu = new JMenu("Color");
        blackMenuItem = new JMenuItem("Black");
        redMenuItem = new JMenuItem("Red");
        greenMenuItem = new JMenuItem("Green");
        blueMenuItem = new JMenuItem("Blue");
        
        configColorMenuItems = new JMenuItem[]{blackMenuItem, redMenuItem, greenMenuItem, blueMenuItem};
        for (JMenuItem itemMenu : configColorMenuItems) {
            colorMenu.add(itemMenu);
        }
        
        configMenu.add(colorMenu);
    }

    // Creates the Font submenu with various font options.
    public void createConfigFontMenu() {
        fontMenu = new JMenu("Font");
        font1MenuItem = new JMenuItem("Font 1");
        font2MenuItem = new JMenuItem("Font 2");
        font3MenuItem = new JMenuItem("Font 3");
        
        configFontMenuItems = new JMenuItem[]{font1MenuItem, font2MenuItem, font3MenuItem};
        for (JMenuItem itemMenu : configFontMenuItems) {
            fontMenu.add(itemMenu);
        }
        
        configMenu.add(fontMenu);
    }

    // Adds all menu components to the window and sets up the menu bar.
    @Override
    public void addComponents() {
        super.addComponents();

        menuBar = new JMenuBar();
        
        createFileMenu();
        createConfigMenu();
        createConfigSizeMenu();
        createConfigColorMenu();
        createConfigFontMenu();
        
        this.setJMenuBar(menuBar);
    }
}