package phadungkit.naphat.lab9;

import java.awt.*;
import javax.swing.*;

/**
 * This class extends MobileDeviceV4 to add vendor list and device rating functionality.
 * It introduces a list of device vendors and a slider to rate the device,
 * enhancing the mobile device form with additional interactive components.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 9 February 2025
 */

public class MobileDeviceV5 extends MobileDeviceV4 {

    protected JSlider deviceRate;
    protected int minRate, maxRate, initialRate;
    protected JList<String> vendorList;
    protected JLabel deviceVendorLabel, deviceRateLabel;
    protected String deviceVendorStr, deviceRateStr;
    protected String[] deviceVendorList;
    protected JScrollPane vendorListScroller;
    protected JPanel mainPanel2, mainPanel3, deviceRatePanel, deviceVendorPanel, deviceAndVendorPanel;

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
        MobileDeviceV5 mdv5 = new MobileDeviceV5("Mobile Device V5");
        mdv5.addComponents();
        mdv5.setFrameFeatures();
    }

    // Constructs a new mobile device form with the specified title.
    public MobileDeviceV5(String title) {
        super(title);
    }

    // Initializes default values for device vendor and rating components.
    public void initComponents() {
        minRate = 0;
        maxRate = 10;
        initialRate = 5;
        deviceVendorStr = "The device is available at:";
        deviceVendorList = new String[]{"AIS", "True", "DTAC", "Shopee"};
        deviceRateStr = "Rate the device(0-10):";
    }

    // Creates a list of device vendors with selection capabilities.
    public void crtSelectVendor() {
        initComponents();
        vendorList = new JList<>(deviceVendorList);
        vendorList.setSelectedIndex(0);
        vendorList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        vendorListScroller = new JScrollPane(vendorList);
    }

    // Creates a slider for rating the device.
    public void crtSlideRate() {
        initComponents();
        deviceRate = new JSlider(JSlider.HORIZONTAL, minRate, maxRate, initialRate);
        deviceRate.setMajorTickSpacing(1);
        deviceRate.setPaintTicks(true);
        deviceRate.setPaintLabels(true);
    }

    // Creates a panel for displaying device vendor options.
    public void crtDeviceVendorPanel() {
        initComponents();
        crtSelectVendor();
        deviceVendorLabel = new JLabel(deviceVendorStr);
        deviceVendorPanel = new JPanel(new GridLayout(1, 2));
        deviceVendorPanel.add(deviceVendorLabel);
        deviceVendorPanel.add(vendorList);

    }

    // Creates a panel for the device rating slider.
    public void crtDeviceRatePanel() {
        crtSlideRate();
        initComponents();
        deviceRatePanel = new JPanel(new GridLayout(2, 1));
        deviceRateLabel = new JLabel(deviceRateStr);
        deviceRatePanel.add(deviceRateLabel);
        deviceRatePanel.add(deviceRate);
    }
    
    // Combines vendor and rating panels into a single panel.
    public void crtDeviceRateAndVendorPanel() {
        crtDeviceVendorPanel();
        crtDeviceRatePanel();
        deviceAndVendorPanel = new JPanel(new BorderLayout());
        deviceAndVendorPanel.add(deviceVendorPanel, BorderLayout.NORTH);
        deviceAndVendorPanel.add(deviceRatePanel, BorderLayout.SOUTH);
    }

    // Creates main panel with device rate and vendor panels.
    // Organizes form components in a nested layout.
    @Override
    public void crtMainPanel() {
        super.crtMainPanel();
        crtDeviceRatePanel();
        crtDeviceVendorPanel();
        crtDeviceRateAndVendorPanel();

        mainPanel2 = new JPanel(new BorderLayout());
        mainPanel2.add(formPanel, BorderLayout.NORTH);
        mainPanel2.add(extraPanel, BorderLayout.SOUTH);

        mainPanel3 = new JPanel(new BorderLayout());
        mainPanel3.add(mainPanel2, BorderLayout.NORTH);
        mainPanel3.add(deviceAndVendorPanel, BorderLayout.CENTER);
        //mainPanel3.add(buttonPanel, BorderLayout.SOUTH);

        mainPanel.add(mainPanel3, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        setContentPane(mainPanel);
    }

    @Override
    public void addComponents() {
        super.addComponents();
        crtMainPanel();
    }

}
