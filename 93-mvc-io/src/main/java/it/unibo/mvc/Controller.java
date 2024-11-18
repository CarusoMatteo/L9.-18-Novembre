package it.unibo.mvc;

import java.util.List;

/**
 * Controller interface.
 */
public interface Controller {
    /**
     * Sets the current string.
     * 
     * @param string the next string to print.
     */
    void setString(String string);

    /**
     * @return the next string to print.
     */
    String getString();

    /**
     * @return a list that contains every string that was printed.
     */
    List<String> getPrintedHistory();

    /**
     * Prints the current string, and adds it to the history.
     */
    void printString();
}
