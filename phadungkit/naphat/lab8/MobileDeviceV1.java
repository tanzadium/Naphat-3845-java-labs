package phadungkit.naphat.lab8;

import java.awt.*;
import javax.swing.*;

/**
 * This class extends MySimpleWindow to create a form for mobile device
 * information. It includes fields for device name, brand, price, and device
 * type selection.
 *
 * Author: Naphat Phadungkit Student ID: 673040384-5 Sec: 1 Last updated date:
 * 27 January 2025
 */
public class MobileDeviceV1 extends MySimpleWindow {

    protected JLabel deviceNameLabel, deviceBrandLabel, devicePriceLabel, deviceTypeLabel;
    protected JTextField deviceNameTextField, deviceBrandTextField, devicePriceTextField;
    protected JRadioButton selectTypeSmartPhone, selectTypeTablet;
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

    public void crtBtnGroup() {
        selectTypeSmartPhone = new JRadioButton("Smartphone", true);
        selectTypeTablet = new JRadioButton("Tablet");
        typeGroup = new ButtonGroup();
        typeGroup.add(selectTypeSmartPhone);
        typeGroup.add(selectTypeTablet);
    }

    public void crtFormPanel() {
        deviceNameLabel = new JLabel("Device Name:");
        deviceNameTextField = new JTextField(15);
        deviceBrandLabel = new JLabel("Brand:");
        deviceBrandTextField = new JTextField(15);
        devicePriceLabel = new JLabel("Price:");
        devicePriceTextField = new JTextField(15);
        deviceTypeLabel = new JLabel("Type:");

        crtBtnGroup();

        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2));

        typePanel = new JPanel();
        typePanel.add(selectTypeSmartPhone);
        typePanel.add(selectTypeTablet);

        formPanel.add(deviceNameLabel);
        formPanel.add(deviceNameTextField);
        formPanel.add(deviceBrandLabel);
        formPanel.add(deviceBrandTextField);
        formPanel.add(devicePriceLabel);
        formPanel.add(devicePriceTextField);
        formPanel.add(deviceTypeLabel);

        formPanel.add(typePanel);

    }

    @Override
    public void crtMainPanel() {
        crtFormPanel();
        crtBtnPanel();

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        setContentPane(mainPanel);
    }

    /**
     * Adds form components including labels, text fields, and radio buttons.
     * Organizes components using GridLayout and BorderLayout.
     */
    @Override
    public void addComponents() {

        super.addComponents();

        crtBtnGroup();
        crtFormPanel();
        crtMainPanel();

    }
}
