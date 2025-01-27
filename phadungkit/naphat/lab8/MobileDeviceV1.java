package phadungkit.naphat.lab8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 * This class extends MySimpleWindow to create a form for mobile device information.
 * It includes fields for device name, brand, price, and device type selection.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 27 January 2025
 */
public class MobileDeviceV1 extends MySimpleWindow {

    protected JLabel deviceName, deviceBrand, devicePrice, deviceType;
    protected JTextField inputName, inputBrand, inputPrice;
    protected JRadioButton selectType1, selectType2;
    protected JPanel formPanel, typePanel;
    protected ButtonGroup typeGroup;

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
        MobileDeviceV1 mdv1 = new MobileDeviceV1("Mobile Device V1");
        mdv1.addComponents();
        mdv1.setFrameFeatures();
    }

    // Constructs a new mobile device form with the specified title.
    public MobileDeviceV1(String title) {
        super(title);
    }
    
    /**
     * Adds form components including labels, text fields, and radio buttons.
     * Organizes components using GridLayout and BorderLayout.
     */
    @Override
    public void addComponents() {
        super.addComponents();
        deviceName = new JLabel("Device Name:");
        inputName = new JTextField(15);
        deviceBrand = new JLabel("Brand:");
        inputBrand = new JTextField(15);
        devicePrice = new JLabel("Price:");
        inputPrice = new JTextField(15);
        deviceType = new JLabel("Type:");
        selectType1 = new JRadioButton("Smartphone", true);
        selectType2 = new JRadioButton("Tablet");

        typeGroup = new ButtonGroup();
        typeGroup.add(selectType1);
        typeGroup.add(selectType2);

        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4,2));
        formPanel.add(deviceName);
        formPanel.add(inputName);
        formPanel.add(deviceBrand);
        formPanel.add(inputBrand);
        formPanel.add(devicePrice);
        formPanel.add(inputPrice);
        formPanel.add(deviceType);
        
        typePanel = new JPanel();
        typePanel.add(selectType1);
        typePanel.add(selectType2);
        
        formPanel.add(typePanel);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(mainPanel);
    }
}