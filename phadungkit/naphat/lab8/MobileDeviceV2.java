package phadungkit.naphat.lab8;

import java.awt.*;
import javax.swing.*;

/**
 * This class extends MobileDeviceV1 to add additional device information fields.
 * It adds operating system selection and a feature description text area.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 27 January 2025
 */
public class MobileDeviceV2 extends MobileDeviceV1 {
    
    protected JLabel deviceOS, deviceFeature;
    protected JTextArea inputFeature;
    protected JPanel extraPanel;
    protected JComboBox osBox;
    protected JScrollPane scrollPane;
    protected String[] osList;

    // Main method to launch the enhanced mobile device form.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    // Creates and displays the enhanced mobile device form GUI.
    public static void createAndShowGUI() {
        MobileDeviceV2 mdv2 = new MobileDeviceV2("Mobile Device V2");
        mdv2.addComponents();
        mdv2.setFrameFeatures();
    }

    // Constructs a new enhanced mobile device form with the specified title.
    public MobileDeviceV2(String title) {
        super(title);
    }

    public void selectOS(){
        osList = new String[]{"Android", "iOS", "Windows", "Others"};

        deviceOS = new JLabel("Operating System:");
        osBox = new JComboBox<>(osList);
        osBox.setSelectedIndex(0);
    }

    /**
     * Adds additional components including OS selection and feature description.
     * Extends the basic form with a new panel in the center.
     */
    @Override
    public void addComponents() {
        
        super.addComponents();

        selectOS();
        
        deviceFeature = new JLabel("Feature:");
        inputFeature = new JTextArea(3,25);
        scrollPane = new JScrollPane(inputFeature);

        extraPanel = new JPanel();
        extraPanel.setLayout(new GridLayout(2,3));
        extraPanel.add(deviceOS);
        extraPanel.add(osBox);
        extraPanel.add(deviceFeature);
        extraPanel.add(scrollPane);

        mainPanel.add(extraPanel, BorderLayout.CENTER);

        setContentPane(mainPanel);
    }
}