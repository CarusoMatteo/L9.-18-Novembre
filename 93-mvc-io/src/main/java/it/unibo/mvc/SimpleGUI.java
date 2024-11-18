package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 */
public final class SimpleGUI {

    private static final String TITLE = "A very simple GUI application";
    private static final int PROPORTION = 5;

    private final JFrame frame = new JFrame(TITLE);

    private final Controller controller = new SimpleController();

    /**
     * Creates a new BadIOGUI.
     */
    public SimpleGUI() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());

        final JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        final JTextField textField = new JTextField();
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        final JButton printButton = new JButton("Print");
        final JButton showHistroyButton = new JButton("Show History");

        canvas.add(textField, BorderLayout.NORTH);
        canvas.add(textArea, BorderLayout.CENTER);

        canvas.add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.add(printButton);
        buttonPanel.add(showHistroyButton);

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setString(textField.getText());
                controller.printString();
            }
        });
        showHistroyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final List<String> strings = controller.getPrintedHistory();
                final StringBuilder history = new StringBuilder();

                for (final String string : strings) {
                    history.append(string).append('\n');
                }
                textArea.setText(history.toString());
            }
        });
    }

    private void display() {
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
    public static void main(final String... args) {
        // System.out.println(PATH);
        new SimpleGUI().display();
    }
}
