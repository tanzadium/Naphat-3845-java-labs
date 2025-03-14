package phadungkit.naphat.lab12;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import phadungkit.naphat.lab7.MobileDevice;

/**
 * This class extends MobileDeviceV14 to implement binary file I/O
 * functionality. It allows saving and loading mobile device data to/from binary
 * files.
 *
 * Author: Naphat Phadungkit Student ID: 673040384-5 Sec: 1 Last updated date:
 * 14 March 2025
 */
public class MobileDeviceV15 extends MobileDeviceV14 {

    protected JMenu formatMenu;
    protected JRadioButtonMenuItem textFormat, binaryFormat;
    protected ButtonGroup formatGroup;
    protected boolean isTextFormat = true; // Default to text format

    /**
     * Main method to launch the mobile device form.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    /**
     * Creates and displays the mobile device form GUI.
     */
    public static void createAndShowGUI() {
        MobileDeviceV15 mdv15 = new MobileDeviceV15("Mobile Device V15");
        mdv15.addComponents();
        mdv15.setFrameFeatures();
        mdv15.addListeners();
        mdv15.addChangeListener();
        mdv15.addListSelectionListener();
    }

    /**
     * Constructs a new mobile device form with the specified title.
     */
    public MobileDeviceV15(String title) {
        super(title);
    }

    /**
     * Creates and adds menu items to the menu bar.
     */
    @Override
    public void addMenus() {
        super.addMenus();

        // Create Format menu
        formatMenu = new JMenu("Format");
        configMenu.add(formatMenu);

        // Create radio button menu items for format selection
        formatGroup = new ButtonGroup();
        textFormat = new JRadioButtonMenuItem("Text", true);
        binaryFormat = new JRadioButtonMenuItem("Binary");

        formatGroup.add(textFormat);
        formatGroup.add(binaryFormat);

        formatMenu.add(textFormat);
        formatMenu.add(binaryFormat);
    }

    /**
     * Adds action listeners to components.
     */
    @Override
    public void addListeners() {
        super.addListeners();
        textFormat.addActionListener(this);
        binaryFormat.addActionListener(this);
    }

    public void saveBinaryFile() {
        if (deviceList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No device to save",
                    "Message", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        returnVal = fc.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();

            if (!file.getName().contains(".")) {
                file = new File(file.getAbsolutePath());
            }

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(deviceList);

                JOptionPane.showMessageDialog(this,
                        "Data is saved to " + file.getAbsolutePath() + " successfully!",
                        "Save",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(this,
                        "Error saving file: " + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Handles saving mobile device data to a file based on selected format.
     */
    @Override
    public void handleMenuSave() {
        if (textFormat.isSelected()) {
            super.handleMenuSave();
        } else if (binaryFormat.isSelected()) {
            saveBinaryFile();
        }
    }

    public void openBinaryFile() {
        returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            JOptionPane.showMessageDialog(this,
                    "Opening: " + file.getAbsolutePath(),
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE);

            deviceList.clear();

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                Object obj = ois.readObject();

                if (obj instanceof java.util.ArrayList) {
                    java.util.ArrayList<?> loadedList = (java.util.ArrayList<?>) obj;

                    String readData = "Reading from file " + file.getAbsolutePath() + "\n";

                    for (Object item : loadedList) {
                        if (item instanceof MobileDevice) {
                            deviceList.add((MobileDevice) item);
                            readData += item.toString() + "\n";
                        }
                    }

                    JOptionPane.showMessageDialog(this,
                            readData,
                            "Message",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(this,
                        "Error reading file: " + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Handles opening a file containing mobile device data based on selected
     * format.
     */
    @Override
    public void handleMenuOpen() {
        File file = fc.getSelectedFile();
        String fileName = file.getName().toLowerCase();

        if (fileName.endsWith(".txt")) {
            textFormat.setSelected(true);
            super.handleMenuOpen();
        } else {
            if (textFormat.isSelected()) {
                super.handleMenuOpen();
            } else {
                openBinaryFile();
            }
        }
    }

    /**
     * Handles action events for components.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == textFormat) {
            isTextFormat = true;
        } else if (src == binaryFormat) {
            isTextFormat = false;
        } else {
            super.actionPerformed(e);
        }
    }
}
