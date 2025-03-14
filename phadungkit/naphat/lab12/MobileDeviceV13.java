package phadungkit.naphat.lab12;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import phadungkit.naphat.lab7.MobileDevice;

public class MobileDeviceV13 extends MobileDeviceV12 {

    protected JButton addButton, displayButton;
    protected ArrayList<MobileDevice> deviceList;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        MobileDeviceV13 mdv13 = new MobileDeviceV13("Mobile Device V13");
        mdv13.addComponents();
        mdv13.setFrameFeatures();
        mdv13.addListeners();
        mdv13.addChangeListener();
        mdv13.addListSelectionListener();
    }

    public MobileDeviceV13(String title) {
        super(title);
        deviceList = new ArrayList<>();
    }

    @Override
    public void crtBtnPanel() {
        super.crtBtnPanel();
        addButton = new JButton("Add");
        displayButton = new JButton("Display");

        buttonPanel.add(addButton);
        buttonPanel.add(displayButton);
    }

    @Override
    public void addListeners() {
        super.addListeners();
        addButton.addActionListener(this);
        displayButton.addActionListener(this);
    }

    public void handleAddButton() {
        String name = deviceNameTextField.getText();
        String brand = deviceBrandTextField.getText();

        try {
            double price = Double.parseDouble(devicePriceTextField.getText());

            MobileDevice device;

            if (selectTypeSmartPhone.isSelected()) {
                device = new SmartPhone(name, brand, price);
                deviceList.add(device);
                JOptionPane.showMessageDialog(this,
                        "SmartPhone " + name + " is added",
                        "Message",
                        JOptionPane.INFORMATION_MESSAGE);
            } else if (selectTypeTablet.isSelected()) {
                device = new Tablet(name, brand, price);
                deviceList.add(device);
                JOptionPane.showMessageDialog(this,
                        "Tablet " + name + " is added",
                        "Message",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid price",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void handleDisplayButton() {

        if (deviceList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No devices have been added yet", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String message = "";

            for (MobileDevice device : deviceList) {
                message = message + device.toString() + "\n";
            }

            JOptionPane.showMessageDialog(this,
                    message,
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == addButton) {
            handleAddButton();
        } else if (src == displayButton) {
            handleDisplayButton();
        } else {
            super.actionPerformed(e);
        }
    }
}
