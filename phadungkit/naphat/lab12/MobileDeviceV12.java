package phadungkit.naphat.lab12;

import javax.swing.*;
import java.awt.event.*;

import phadungkit.naphat.lab10.MobileDeviceV11;

public class MobileDeviceV12 extends MobileDeviceV11 {

    protected boolean textEmpty;
    protected String textInput;

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
        MobileDeviceV12 mdv12 = new MobileDeviceV12("Mobile Device V12");
        mdv12.addComponents();
        mdv12.setFrameFeatures();
        mdv12.addListeners();
        mdv12.addChangeListener();
        mdv12.addListSelectionListener();
    }

    // Constructs a new mobile device form with the specified title.
    public MobileDeviceV12(String title) {
        super(title);
    }

    @Override
    public void addComponents() {
        super.addComponents();
        deviceNameTextField.setName("Device Name");
        deviceBrandTextField.setName("Brand");
        devicePriceTextField.setName("Price");
    }

    public void handleNormalTextField(JTextField tf, JComponent nextComponent) {
        textEmpty = tf.getText().isEmpty();
        textInput = tf.getText();

        if (textEmpty) {
            JOptionPane.showMessageDialog(this, "Please enter a value for " + tf.getName() + ".", "Message",
                    JOptionPane.INFORMATION_MESSAGE);
            tf.requestFocusInWindow();
            nextComponent.setEnabled(false);
        } else {
            nextComponent.setEnabled(true);
            JOptionPane.showMessageDialog(this, tf.getName() + " is changed to " + textInput, "Message",
                    JOptionPane.INFORMATION_MESSAGE);
            nextComponent.requestFocusInWindow();
        }
    }

    public void handlePosNumTextField(JTextField tf, JComponent nextComponent) {
        textEmpty = tf.getText().isEmpty();
        textInput = tf.getText();

        if (textEmpty) {
            JOptionPane.showMessageDialog(this, "Please enter some data in " + tf.getName(), "Message",
                    JOptionPane.INFORMATION_MESSAGE);
            tf.requestFocusInWindow();
            nextComponent.setEnabled(false);
        } else {
            try {
                double price = Double.parseDouble(tf.getText());
                if (price <= 0) {
                    JOptionPane.showMessageDialog(this, tf.getName() + " must be a positive number", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    tf.requestFocusInWindow();
                    nextComponent.setEnabled(false);
                } else {
                    nextComponent.setEnabled(true);
                    JOptionPane.showMessageDialog(this, tf.getName() + " is changed to " + textInput, "Message",
                            JOptionPane.INFORMATION_MESSAGE);
                    nextComponent.requestFocusInWindow();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number in " + tf.getName(), "Message",
                        JOptionPane.INFORMATION_MESSAGE);
                tf.requestFocusInWindow();
                nextComponent.setEnabled(false);
            }
        }
    }

    @Override
    public void addListeners() {
        super.addListeners();
        deviceNameTextField.addActionListener(this);
        deviceBrandTextField.addActionListener(this);
        devicePriceTextField.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object srcObject = e.getSource();
        if (srcObject == deviceNameTextField) {
            handleNormalTextField(deviceNameTextField, deviceBrandTextField);
        } else if (srcObject == deviceBrandTextField) {
            handleNormalTextField(deviceBrandTextField, devicePriceTextField);
        } else if (srcObject == devicePriceTextField) {
            handlePosNumTextField(devicePriceTextField, osBox);
        }
    }

}
