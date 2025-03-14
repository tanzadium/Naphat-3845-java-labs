package phadungkit.naphat.lab10;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * This class extends MobileDeviceV9 and implements ListSelectionListener and
 * ChangeListener to handle list and slider events. It adds functionality for
 * operating system selection, vendor selection, and device rating changes.
 *
 * Author: Naphat Phadungkit 
 * Student ID: 673040384-5 
 * Sec: 1 
 * Last updated date: 17 February 2025
 */
public class MobileDeviceV10 extends MobileDeviceV9 implements ListSelectionListener, ChangeListener {

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
        MobileDeviceV10 mdv10 = new MobileDeviceV10("Mobile Device V10");
        mdv10.addComponents();
        mdv10.setFrameFeatures();
        mdv10.addListeners();
        mdv10.addChangeListener();
        mdv10.addListSelectionListener();
    }

    // Constructs a new mobile device form with the specified title.
    public MobileDeviceV10(String title) {
        super(title);
    }

    /**
     * Adds action listeners including OS selection box listener.
     */
    @Override
    public void addListeners() {
        super.addListeners();
        osBox.addActionListener(this);
    }

    /**
     * Adds list selection listener for vendor list.
     */
    public void addListSelectionListener() {
        vendorList.addListSelectionListener(this);
    }

    /**
     * Adds change listener for device rating slider.
     */
    public void addChangeListener() {
        deviceRate.addChangeListener(this);
    }

    /**
     * Handles action events including OS selection changes.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object src = e.getSource();
        if (src == osBox) {
            String selectedOS = (String) osBox.getSelectedItem();
            JOptionPane.showMessageDialog(this, "You selected Operating System: "
                    + selectedOS, "OS Selection", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Handles list selection events for vendor list. Displays selected vendors
     * in a message dialog.
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();
        if (src == vendorList && !e.getValueIsAdjusting()) {
            String vendorTextShow = "Device is available at: "
                    + String.join(", ", vendorList.getSelectedValuesList());
            JOptionPane.showMessageDialog(this, vendorTextShow,
                    "Vendor Selection", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Handles change events for the rating slider. Displays new rating value in
     * a message dialog.
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider src = (JSlider) e.getSource();
        if (!src.getValueIsAdjusting()) {
            int currentValue = src.getValue();
            String text = "New rating: " + currentValue;
            JOptionPane.showMessageDialog(this, text, "Rating Adjustment", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
