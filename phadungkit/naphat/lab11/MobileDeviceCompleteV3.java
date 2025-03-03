package phadungkit.naphat.lab11;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * This class extends MobileDeviceCompleteV2 to add component event handling. It
 * implements ComponentListener to handle window resizing, showing/hiding, and
 * movement events.
 *
 * Author: Naphat Phadungkit Student ID: 673040384-5 Sec: 1 Last updated date:
 * 03 March 2025
 */
public class MobileDeviceCompleteV3 extends MobileDeviceCompleteV2 implements ComponentListener {

    /**
     * Constructor for MobileDeviceCompleteV3.
     */
    public MobileDeviceCompleteV3(String title) {
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
        MobileDeviceCompleteV3 mdc3 = new MobileDeviceCompleteV3("Mobile Device Complete V3");
        mdc3.addComponents();
        mdc3.addMenus();
        mdc3.setFrameFeatures();
        mdc3.addListeners();
    }

    /**
     * Adds action listeners to the text fields and component listener to the
     * frame. Overrides the parent class method to add component listener
     * functionality.
     */
    @Override
    public void addListeners() {
        super.addListeners();
        this.addComponentListener(this);
    }

    /**
     * Handles the component resized event. Displays a message showing the new
     * width and height of the window.
     */
    @Override
    public void componentResized(ComponentEvent e) {
        JFrame frame = (JFrame) e.getComponent();
        JOptionPane.showMessageDialog(null, "Window resized to: " + frame.getWidth() + " x " + frame.getHeight(), "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Handles the component moved event. Displays a message showing the new
     * position of the window.
     */
    @Override
    public void componentMoved(ComponentEvent e) {
        JFrame frame = (JFrame) e.getComponent();
        JOptionPane.showMessageDialog(null, "Window moved to: X=" + frame.getLocation().getX() + " Y=" + frame.getLocation().getY(), "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Handles the component shown event. Displays a message indicating that the
     * window is now visible.
     */
    @Override
    public void componentShown(ComponentEvent e) {
        JOptionPane.showMessageDialog(this,
                "Window is now visible.",
                "Message",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Handles the component hidden event. Displays a message indicating that
     * the window is now hidden.
     */
    @Override
    public void componentHidden(ComponentEvent e) {
        JOptionPane.showMessageDialog(this,
                "Window is now hidden.",
                "Message",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
