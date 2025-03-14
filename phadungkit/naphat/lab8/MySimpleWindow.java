package phadungkit.naphat.lab8;

import javax.swing.*;

/**
 * This class represents a basic window interface using Swing components.
 * It provides a foundation for creating simple GUI windows with OK and Cancel buttons.
 * 
 * Author: Naphat Phadungkit
 * Student ID: 673040384-5
 * Sec: 1
 * Last updated date: 27 January 2025
 */
public class MySimpleWindow extends JFrame {

    protected JButton cancelButton, okButton;
    protected JPanel mainPanel, buttonPanel;

    // Main method to demonstrate the basic window functionality.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    // Creates and displays the GUI window.
    public static void createAndShowGUI() {
        MySimpleWindow msw = new MySimpleWindow("My Simple Window");
        msw.addComponents();
        msw.setFrameFeatures();
    }

    // Constructs a new window with the specified title.
    public MySimpleWindow(String title) {
        super(title);
    }

    public void crtBtnPanel() {
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");
        
        buttonPanel = new JPanel();
        buttonPanel.add(cancelButton);
        buttonPanel.add(okButton);
    }

    public void crtMainPanel(){
        crtBtnPanel();
        mainPanel = new JPanel();
        mainPanel.add(buttonPanel);
        setContentPane(mainPanel);
    }

    // Adds the basic components (OK and Cancel buttons) to the window.
    protected void addComponents() {
        crtMainPanel();
    }

    // Sets up the basic window features like size, location, and behavior.
    protected void setFrameFeatures() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}