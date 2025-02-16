package phadungkit.naphat.lab10;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

/**
 * This class extends MobileDeviceV8 and adds file operations and text
 * formatting functionality. It includes features for file operations (new,
 * open, save), and text customization (font size, color, and style).
 *
 * Author: Naphat Phadungkit 
 * Student ID: 673040384-5 
 * Sec: 1 
 * Last updated date: 17 February 2025
 */
public class MobileDeviceV9 extends MobileDeviceV8 {

    private static final String newLine = "\n";
    protected final JFileChooser fc = new JFileChooser();
    protected JTextArea log;
    protected JScrollPane logScrollPane;
    protected JPanel newMainPanel;

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
        MobileDeviceV9 mdv9 = new MobileDeviceV9("Mobile Device V9");
        mdv9.addComponents();
        mdv9.setFrameFeatures();
        mdv9.addListeners();
    }

    // Constructs a new mobile device form with the specified title.
    public MobileDeviceV9(String title) {
        super(title);
    }

    @Override
    public void addComponents() {
        super.addComponents();
    }

    /**
     * Resets all form fields to their default values when selecting "New" from
     * menu.
     */
    public void chooseNewFileMenu() {
        inputName.setText("");
        inputBrand.setText("");
        inputPrice.setText("");
        inputFeature.setText("");
        osBox.setSelectedIndex(0);
        selectTypeSmartPhone.setSelected(true);
        vendorList.clearSelection();
        deviceRate.setValue(5);
    }

    /**
     * Displays file chooser dialog for opening files and shows confirmation
     * message.
     */
    public void chooseOpenFileMenu() {
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File openFile = fc.getSelectedFile();
            JOptionPane.showMessageDialog(this, "Opening: " + openFile.getName(),
                    "Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Displays file chooser dialog for saving files and shows success message.
     */
    public void chooseSaveFileMenu() {
        int returnVal = fc.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File saveFile = fc.getSelectedFile();
            JOptionPane.showMessageDialog(this, "Data is saved to "
                    + saveFile.getName() + " successfully!",
                    "Save", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Exits the application when selecting "Exit" from menu.
     */
    public void chooseExitMenu() {
        System.exit(0);
    }

    /**
     * Changes the font size of all text input fields.
     */
    public void changeFontSize(int size) {
        Font newFont = new Font(inputName.getFont().getFontName(), Font.PLAIN, size);
        inputName.setFont(newFont);
        inputBrand.setFont(newFont);
        inputPrice.setFont(newFont);
        inputFeature.setFont(newFont);
    }

    /**
     * Changes the text color of all input fields.
     */
    public void changeFontColor(Color color) {
        inputName.setForeground(color);
        inputBrand.setForeground(color);
        inputPrice.setForeground(color);
        inputFeature.setForeground(color);
    }

    /**
     * Changes the font style of all input fields.
     */
    public void changeFontStyle(Font font) {
        inputName.setFont(font);
        inputBrand.setFont(font);
        inputPrice.setFont(font);
        inputFeature.setFont(font);
    }

    /**
     * Adds action listeners for menu items and inherits listeners from parent
     * class.
     */
    @Override
    public void addListeners() {
        super.addListeners();
        exitMenu.addActionListener(this);
        newMenu.addActionListener(this);
        saveMenu.addActionListener(this);
        openMenu.addActionListener(this);

        smallMenuItem.addActionListener(this);
        mediumMenuItem.addActionListener(this);
        largeMenuItem.addActionListener(this);
        extraLargeMenuItem.addActionListener(this);

        blackMenuItem.addActionListener(this);
        redMenuItem.addActionListener(this);
        greenMenuItem.addActionListener(this);
        blueMenuItem.addActionListener(this);

        font1MenuItem.addActionListener(this);
        font2MenuItem.addActionListener(this);
        font3MenuItem.addActionListener(this);
    }

    /**
     * Handles all action events for menu items and inherits handling from
     * parent class. Processes file operations and text formatting options.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object src = e.getSource();

        if (src == newMenu) {
            chooseNewFileMenu();
        } else if (src == openMenu) {
            chooseOpenFileMenu();
        } else if (src == saveMenu) {
            chooseSaveFileMenu();
        } else if (src == exitMenu) {
            chooseExitMenu();
        } else if (src == smallMenuItem) {
            changeFontSize(10);
        } else if (src == mediumMenuItem) {
            changeFontSize(14);
        } else if (src == largeMenuItem) {
            changeFontSize(18);
        } else if (src == extraLargeMenuItem) {
            changeFontSize(22);
        } else if (src == blackMenuItem) {
            changeFontColor(Color.BLACK);
        } else if (src == redMenuItem) {
            changeFontColor(Color.RED);
        } else if (src == greenMenuItem) {
            changeFontColor(Color.GREEN);
        } else if (src == blueMenuItem) {
            changeFontColor(Color.BLUE);
        } else if (src == font1MenuItem) {
            changeFontStyle(new Font("Serif", Font.PLAIN, inputName.getFont().getSize()));
        } else if (src == font2MenuItem) {
            changeFontStyle(new Font("SansSerif", Font.PLAIN, inputName.getFont().getSize()));
        } else if (src == font3MenuItem) {
            changeFontStyle(new Font("Monospaced", Font.PLAIN, inputName.getFont().getSize()));
        }
    }
}
