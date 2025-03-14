package phadungkit.naphat.lab12;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import phadungkit.naphat.lab7.MobileDevice;

/**
 * This class extends MobileDeviceV13 to implement file I/O functionality. It
 * allows saving and loading mobile device data to/from text files.
 *
 * Author: Naphat Phadungkit 
 * Student ID: 673040384-5 
 * Sec: 1 
 * Last updated date: 13 March 2025
 */
public class MobileDeviceV14 extends MobileDeviceV13 {

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
        MobileDeviceV14 mdv14 = new MobileDeviceV14("Mobile Device V14");
        mdv14.addComponents();
        mdv14.setFrameFeatures();
        mdv14.addListeners();
        mdv14.addChangeListener();
        mdv14.addListSelectionListener();
    }

    /**
     * Constructs a new mobile device form with the specified title.
     */
    public MobileDeviceV14(String title) {
        super(title);
    }

    /**
     * Adds listeners for menu items.
     */
    @Override
    public void addListeners() {
        super.addListeners();
    }

    /**
     * Handles opening a file containing mobile device data. Reads text file
     * content and creates MobileDevice objects.
     */
    public void handleMenuOpen() {
        returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            JOptionPane.showMessageDialog(this,
                    "Opening: " + file.getAbsolutePath(),
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE);

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                deviceList.clear();

                String line;
                String readData = "Read devices from the file " + file.getAbsolutePath() + " are as follows:\n";

                while ((line = reader.readLine()) != null) {
                    readData = readData + line + "\n";

                    // Parse the line to extract device information
                    String[] parts = line.split(":"); // SmartPhone : info  (Type : info) (separated into 2 parts)
                    String deviceType = parts[0].trim();
                    String deviceInfo = parts[1].trim();

                    // Extract name, brand, and price
                    int brandStartIndex = deviceInfo.indexOf("(");
                    int brandEndIndex = deviceInfo.indexOf(")");

                    String name = deviceInfo.substring(0, brandStartIndex).trim();
                    String brand = deviceInfo.substring(brandStartIndex + 1, brandEndIndex).trim();

                    // Extract price
                    String priceString = deviceInfo.substring(deviceInfo.lastIndexOf(")") + 1, deviceInfo.indexOf("Baht")).trim();
                    double price = Double.parseDouble(priceString);

                    // Create and add the appropriate device to the list
                    if (deviceType.equals("SmartPhone")) {
                        deviceList.add(new SmartPhone(name, brand, price));
                    } else if (deviceType.equals("Tablet")) {
                        deviceList.add(new Tablet(name, brand, price));
                    }
                }

                JOptionPane.showMessageDialog(this,
                        readData,
                        "Message",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException e) {
                JOptionPane.showMessageDialog(this,
                        "Error reading file: " + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Handles saving mobile device data to a file. Writes each device as a text
     * line in the file.
     */
    public void handleMenuSave() {

        returnVal = fc.showSaveDialog(this);

        if (deviceList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No device to save",
                    "Message", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();

            // check file name end with .txt
            if (!file.getName().endsWith(".txt")) {
                file = new File(file.getAbsolutePath()+".txt");
            }

            try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                for (MobileDevice device : deviceList) {
                    writer.println(device.toString());
                }

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
     * Handles action events for menu items.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == openMenu) {
            handleMenuOpen();
        } else if (src == saveMenu) {
            handleMenuSave();
        } else {
            super.actionPerformed(e);
        }

    }
}
