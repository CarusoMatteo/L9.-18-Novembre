package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 */
public final class SimpleGUIWithFileChooser extends SimpleGUI {

    /**
     * Creates a new SimpleGUIWithFileChooser,
     * which works on what's created by SimpleGUI.
     */
    public SimpleGUIWithFileChooser() {
        super();
        final JPanel browsePanel = new JPanel();
        browsePanel.setLayout(new BorderLayout());

        final JTextField fileTextField = new JTextField();
        fileTextField.setEditable(false);
        fileTextField.setText(this.getController().getPath());
        final JButton browseButton = new JButton("Browse");

        this.getMainCanvas().add(browsePanel, BorderLayout.NORTH);
        browsePanel.add(fileTextField, BorderLayout.CENTER);
        browsePanel.add(browseButton, BorderLayout.LINE_END);

        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(getController().getFile());
                final int fileChooserOutput = fileChooser.showSaveDialog(getFrame());

                switch (fileChooserOutput) {
                    case JFileChooser.APPROVE_OPTION:
                        getController().setFile(fileChooser.getSelectedFile());
                        fileTextField.setText(getController().getPath());
                        break;
                    case JFileChooser.CANCEL_OPTION:
                        break;
                    default:
                        JOptionPane.showMessageDialog(getFrame(), "An error has occoured",
                                "Error", JOptionPane.WARNING_MESSAGE);
                        break;
                }
            }
        });
    }

    /**
     * Launches the application.
     *
     * @param args ignored
     */
    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser().display();
    }
}
