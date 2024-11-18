package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 */
public class SimpleGUI {

    private static final int PROPORTION = 5;

    private final JFrame frame = new JFrame("Simple File Read");
    private final JPanel mainCanvas = new JPanel();
    private final Controller controller = new Controller();

    /**
     * Creates a new SimpleGUI.
     */
    public SimpleGUI() {
        mainCanvas.setLayout(new BorderLayout());

        final JTextArea text = new JTextArea();
        final JButton saveButton = new JButton("Save");

        mainCanvas.add(text, BorderLayout.CENTER);
        mainCanvas.add(saveButton, BorderLayout.SOUTH);

        frame.setContentPane(mainCanvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.write(text.getText());
                } catch (final IOException e1) {
                    JOptionPane.showMessageDialog(frame, e1, "Error", JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace(); // NOPMD: allowed as this is just an exercise
                }
            }
        });
    }

    /**
     * @return the frame of the GUI.
     */
    protected JFrame getFrame() {
        return this.frame;
    }

    /**
     * @return the main canvas of the GUI.
     */
    protected JPanel getMainCanvas() {
        return this.mainCanvas;
    }

    /**
     * @return the controller.
     */
    protected Controller getController() {
        return this.controller;
    }

    /**
     * Makes the GUI visible.
     */
    protected void display() {
        /*
         * Make the frame one fifth the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected. In order to deal coherently with multimonitor
         * setups, other facilities exist (see the Java documentation about this
         * issue). It is MUCH better than manually specify the size of a window
         * in pixel: it takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);

        /*
         * OK, ready to push the frame onscreen
         */
        frame.setVisible(true);
    }

    /**
     * Launches the application.
     *
     * @param args ignored
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }
}
