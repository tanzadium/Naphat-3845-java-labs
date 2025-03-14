package phadungkit.naphat.lab10;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import phadungkit.naphat.lab9.MobileDeviceV7;

/**
 * This class extends MobileDeviceV7 and implements ActionListener to handle
 * button events. It adds functionality for creating message dialogs and
 * handling form actions.
 *
 * Author: Naphat Phadungkit Student ID: 673040384-5 Sec: 1 Last updated date:
 * 17 February 2025
 */
public class MobileDeviceV8 extends MobileDeviceV7 implements ActionListener {

    protected List<String> vendorSelected;
    protected String vendorSelectedMessage, okMessage;

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
        MobileDeviceV8 mdv8 = new MobileDeviceV8("Mobile Device V8");
        mdv8.addComponents();
        mdv8.setFrameFeatures();
        mdv8.addListeners();
    }

    // Constructs a new mobile device form with the specified title.
    public MobileDeviceV8(String title) {
        super(title);
    }

    /**
     * Creates a message dialog containing all form information. Collects and
     * formats all user input and selections for display.
     */
    public void crtMessageDialog() {
        vendorSelectedMessage = String.join(", ", vendorList.getSelectedValuesList());

        okMessage = "Device Name: " + deviceNameTextField.getText() + "\nBrand: " + deviceBrandTextField.getText()
                + "\nPrice: " + devicePriceTextField.getText() + "\nType: " + selectTypeSmartPhone.getText()
                + "\nOperating System: " + osBox.getSelectedItem() + "\nFeatures: " + deviceFeatureTextArea.getText()
                + "\nAvailable at: " + vendorSelectedMessage + "\nRating: " + deviceRate.getValue();
    }

    /**
     * Adds ActionListener to the form buttons. Sets up event handling for OK
     * and Cancel buttons.
     */
    public void addListeners() {
        cancelButton.addActionListener(this);
        okButton.addActionListener(this);
    }

    /**
     * Handles button click events. - Cancel button clears all form fields - OK
     * button displays the form information in a dialog
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        crtMessageDialog();
        Object src = e.getSource();
        if (src == cancelButton) {
            for (JTextField textFieldCleared : textFields) {
                textFieldCleared.setText("");
            }
            deviceFeatureTextArea.setText("");
            selectTypeSmartPhone.setSelected(true);
            osBox.setSelectedIndex(0);
            vendorList.clearSelection();
            deviceRate.setValue(initialRate);
        } else if (src == okButton) {
            JOptionPane.showMessageDialog(null, okMessage,
                    "Device Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
