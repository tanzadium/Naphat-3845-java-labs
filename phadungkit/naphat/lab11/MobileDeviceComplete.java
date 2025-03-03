package phadungkit.naphat.lab11;

import javax.swing.*;
// import javax.swing.border.Border;
import phadungkit.naphat.lab9.ReadImage;
import java.awt.*;

/**
 * This class creates a comprehensive GUI for mobile device information. It
 * displays and collects information about mobile devices including name, brand,
 * price, type, operating system, features, vendors, and user ratings.
 *
 * Author: Naphat Phadungkit Student ID: 673040384-5 Sec: 1 Last updated date:
 * 03 March 2025
 */
public class MobileDeviceComplete extends JFrame {

    protected JTextField deviceNameField, brandField, priceField;
    protected JRadioButton smartphoneButton, tabletButton;
    protected JComboBox<String> osComboBox;
    protected JTextArea featuresTextArea;
    protected JList<String> vendorList;
    protected JSlider ratingSlider;
    protected JLabel imageLabel;
    protected JButton okButton, cancelButton, colorButton;

    protected JMenuBar menuBar;
    protected JMenu fileMenu, configMenu, sizeMenu, colorMenu, fontMenu;
    protected JMenuItem newMI, openMI, saveMI, exitMI, smallMI, mediumMI, largeMI, xLargeMI, blackMI, redMI, greenMI, blueMI, font1MI, font2MI, font3MI;
    protected JPanel mainPanel, topPanel, middlePanel, bottomPanel, rbPanel, dbPanel, TAPanel, listPanel, sliderPanel, imagePanel, buttonPanel;

    /**
     * Constructor that initializes the frame with a title.
     */
    public MobileDeviceComplete(String title) {
        super(title);
    }

    /**
     * Main method to launch the application.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater((new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        }));
    }

    /**
     * Creates and displays the GUI for the mobile device form.
     */
    public static void createAndShowGUI() {
        MobileDeviceComplete window = new MobileDeviceComplete("Mobile Device Complete");
        window.addComponents();
        window.addMenus();
        window.setFrameFeatures();
    }

    /**
     * Adds all UI components to the frame using various layout managers.
     * Components are organized in panels with appropriate layouts.
     */
    protected void addComponents() {
        mainPanel = new JPanel(new BorderLayout());

        // Create the top panel with a grid layout for form fields
        topPanel = new JPanel(new GridLayout(5, 2));
        // Device Info
        topPanel.add(new JLabel("Device Name:"));
        deviceNameField = new JTextField();
        topPanel.add(deviceNameField);

        topPanel.add(new JLabel("Brand:"));
        brandField = new JTextField();
        topPanel.add(brandField);

        topPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        topPanel.add(priceField);

        // Set up radio buttons for device type
        rbPanel = new JPanel();
        smartphoneButton = new JRadioButton("Smartphone");
        tabletButton = new JRadioButton("Tablet");
        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(smartphoneButton);
        typeGroup.add(tabletButton);
        smartphoneButton.setSelected(true);
        rbPanel.add(smartphoneButton);
        rbPanel.add(tabletButton);
        topPanel.add(new JLabel("Type:"));
        topPanel.add(rbPanel);

        // Add OS selection dropdown
        topPanel.add(new JLabel("Operating System:"));
        osComboBox = new JComboBox<>(new String[]{"Android", "iOS", "Windows", "Linux"});
        topPanel.add(osComboBox);

        // Create text area for features
        TAPanel = new JPanel(new GridLayout(1, 2));
        TAPanel.add(new JLabel("Features:"));
        featuresTextArea = new JTextArea(3, 25);
        featuresTextArea.setLineWrap(true);
        featuresTextArea.setWrapStyleWord(true);
        TAPanel.add(new JScrollPane(featuresTextArea));

        // Create vendor list panel
        listPanel = new JPanel(new GridLayout(1, 2));
        listPanel.add(new JLabel("The device is available at:"));
        vendorList = new JList<>(new String[]{"AIS", "True", "DTAC", "Shopee"});
        vendorList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        vendorList.setSelectedIndex(0);
        listPanel.add(new JScrollPane(vendorList));

        // Create slider panel for rating
        sliderPanel = new JPanel(new BorderLayout());
        sliderPanel.add(new JLabel("Rate the device (0-10):"), BorderLayout.NORTH);
        ratingSlider = new JSlider(0, 10, 5);
        ratingSlider.setMajorTickSpacing(1);
        ratingSlider.setPaintTicks(true);
        ratingSlider.setPaintLabels(true);
        sliderPanel.add(ratingSlider, BorderLayout.CENTER);

        // Set up middle panel with text area, list, and slider
        middlePanel = new JPanel(new BorderLayout());
        middlePanel.add(TAPanel, BorderLayout.NORTH);
        middlePanel.add(listPanel, BorderLayout.CENTER);
        middlePanel.add(sliderPanel, BorderLayout.SOUTH);

        // Create bottom panel with image and buttons
        bottomPanel = new JPanel(new BorderLayout());

        // Add image panel
        imagePanel = new ReadImage("S25-ultra.jpg");
        imagePanel.setPreferredSize(new Dimension(600, 450));

        // Add button panel
        buttonPanel = new JPanel();
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        // Combine image and buttons in bottom panel
        bottomPanel.add(imagePanel, BorderLayout.NORTH);
        bottomPanel.add(buttonPanel);

        // Add all main sections to the main panel
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(middlePanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        add(mainPanel);
    }

    /**
     * Sets up the menu bar with the File menu and its menu items.
     */
    protected void addMenus() {
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        newMI = new JMenuItem("New");
        openMI = new JMenuItem("Open");
        saveMI = new JMenuItem("Save");
        exitMI = new JMenuItem("Exit");
        fileMenu.add(newMI);
        fileMenu.add(openMI);
        fileMenu.add(saveMI);
        fileMenu.add(exitMI);

        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    /**
     * Sets the frame properties including close operation, visibility, size,
     * and position.
     */
    protected void setFrameFeatures() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }
}
