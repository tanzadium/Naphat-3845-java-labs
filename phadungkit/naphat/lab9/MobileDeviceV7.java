package phadungkit.naphat.lab9;

import javax.swing.*;
import java.awt.*;

/**
 * This class extends MobileDeviceV6 to add image display functionality.
 * It introduces a panel for reading and displaying an image of a mobile device,
 * enhancing the form with a visual representation of the selected device.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 9 February 2025
 */

public class MobileDeviceV7 extends MobileDeviceV6 {

    protected ReadImage imagePanel;
    protected JPanel imageContainerPanel;

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
        MobileDeviceV7 mdv7 = new MobileDeviceV7("Mobile Device V7");
        mdv7.addComponents();
        mdv7.setFrameFeatures();
    }

    // Constructs a new mobile device form with the specified title.
    public MobileDeviceV7(String title) {
        super(title);
    }

    // Sets form data with predefined device information.
    public void setFormData() {
        inputName.setText("Samsung Galaxy S25 Ultra");
        inputBrand.setText("Samsung");
        inputPrice.setText("46,900");
        selectType1.setSelected(true);

        osBox.setSelectedItem("Android");

        String samsungS25Features = "200MP Camera\n" + "1TB Storage\n" + "Snapdragon Gen 4 Processor\n" + "5000mAh Battery\n" + "6.8-inch AMOLED Display\n" + "120Hz Refresh Rate\n" + "Fast Charging";
        inputFeature.setText(samsungS25Features);

        vendorList.setSelectedValue("AIS", true);

        deviceRate.setValue(9);
    }

    // Creates main panel with image container and button panel.
    @Override
    public void crtMainPanel() {
        super.crtMainPanel();
        imagePanel = new ReadImage();
        
        imageContainerPanel = new JPanel();
        imageContainerPanel.setPreferredSize(new Dimension(800, 400));
        imageContainerPanel.setLayout(new BorderLayout());
        imageContainerPanel.add(imagePanel);
        
        mainPanel.add(imageContainerPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        setContentPane(mainPanel);
    }

    @Override
    public void addComponents() {
        super.addComponents();  
        setFormData(); 
    }

}

/**
 * Custom JPanel class for displaying a mobile device image.
 * Loads and renders an image centered within the panel.
 */
class ReadImage extends JPanel {
    protected Image deviceImage;
    
    // Constructs the image panel and Loads the device image from resources and sets a white background.
    public ReadImage() {
        ImageIcon icon = new ImageIcon(getClass().getClassLoader()
                .getResource("phadungkit/naphat/lab9/images/S25-ultra.jpg"));
        deviceImage = icon.getImage();
        setBackground(Color.WHITE);
    }

    // Overrides paintComponent to custom render the image. Scales and centers the image within the panel.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  
        if (deviceImage != null) { 
            int width = (int)(getWidth() * 0.8);  
            int height = width * deviceImage.getHeight(this) / deviceImage.getWidth(this);
            
            int x = (getWidth() - width) / 2;
            int y = (getHeight() - height) / 2;
            
            g.drawImage(deviceImage, x, y, width, height, this);
        }
    }
}