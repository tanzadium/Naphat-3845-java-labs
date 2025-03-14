package phadungkit.naphat.lab9;

import javax.swing.*;
import java.awt.*;

/**
 * This class extends MobileDeviceV5 to enhance the visual styling of the mobile
 * device form. It introduces customization for text fields, labels, vendor
 * list, and buttons, providing a more refined and visually appealing user
 * interface.
 *
 * Author: Naphat Phadungkit Student ID: 673040384-5 Sec: 1 Last updated date: 9
 * February 2025
 */
public class MobileDeviceV6 extends MobileDeviceV5 {

    protected Color textFieldBgColor, textFieldFontColor, textLabelFontColor;
    protected Font labelFont;
    protected JLabel[] labels;
    protected JTextField field;
    protected JTextField[] textFields;
    protected static final Color DARK_BLUE = new Color(0, 0, 128);
    protected static final Color DARK_GREEN = new Color(0, 100, 0);
    protected static final Color LIGHT_GRAY = Color.LIGHT_GRAY;
    protected static final Color DARK_GRAY = Color.DARK_GRAY;
    protected static final Color LIGHT_YELLOW = new Color(255, 255, 205);

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
        MobileDeviceV6 mdv6 = new MobileDeviceV6("Mobile Device V6");
        mdv6.addComponents();
        mdv6.setFrameFeatures();
    }

    // Constructs a new mobile device form with the specified title.
    public MobileDeviceV6(String title) {
        super(title);
    }

    // Customizes the appearance of text fields with specific background and font colors.
    public void customizeText() {
        textFields = new JTextField[]{deviceNameTextField, deviceBrandTextField, devicePriceTextField};
        for (JTextField field : textFields) {
            field.setBackground(LIGHT_GRAY);
            field.setForeground(DARK_GRAY);
        }

        deviceFeatureTextArea.setBackground(LIGHT_YELLOW);
        deviceFeatureTextArea.setForeground(DARK_GRAY);
        deviceFeatureTextArea.setFont(deviceFeatureTextArea.getFont().deriveFont(Font.ITALIC));
        deviceFeatureTextArea.setLineWrap(true);
        deviceFeatureTextArea.setWrapStyleWord(true);
    }

    // Applies custom font and color styling to labels.
    public void customizeLabels() {
        labelFont = new Font("Arial", Font.BOLD, 14);

        labels = new JLabel[]{
            deviceNameLabel, deviceBrandLabel, devicePriceLabel, deviceTypeLabel,
            deviceOS, deviceFeature, deviceVendorLabel, deviceRateLabel
        };

        for (JLabel labelSetFont : labels) {
            labelSetFont.setFont(labelFont);
            labelSetFont.setForeground(DARK_BLUE);
        }
    }

    // Customizes the vendor list with specific background, font, and selection colors.
    private void customizeVendorList() {
        vendorList.setBackground(new Color(242, 242, 242));
        vendorList.setForeground(DARK_GREEN);
        vendorList.setFont(vendorList.getFont().deriveFont(Font.BOLD));
        vendorList.setSelectionBackground(Color.YELLOW);
        vendorList.setSelectionForeground(Color.BLACK);
    }

    // Sets custom colors for OK and Cancel buttons.
    public void customizeButtons() {
        okButton.setForeground(Color.GREEN);
        cancelButton.setForeground(Color.RED);
    }

    @Override
    public void addComponents() {
        super.addComponents();
        customizeLabels();
        customizeText();
        customizeVendorList();
        customizeButtons();
    }

}
