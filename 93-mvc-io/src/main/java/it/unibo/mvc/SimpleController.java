package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Implementation of Controller.
 */
public final class SimpleController implements Controller {

    // Last string is the current string.
    private final List<String> strings = new ArrayList<>();
    private String currenString;

    @Override
    public void setString(final String string) {
        Objects.requireNonNull(string);
        this.currenString = string;
    }

    @Override
    public String getString() {
        if (currenString == null) {
            throw new IllegalStateException("No string was set.");
        }
        return this.currenString;
    }

    @Override
    public List<String> getPrintedHistory() {
        return List.copyOf(this.strings);
    }

    @Override
    public void printString() {
        System.out.println(getString()); // NOPMD: printing is required by the excercise.
        this.strings.addLast(currenString);
    }

}
