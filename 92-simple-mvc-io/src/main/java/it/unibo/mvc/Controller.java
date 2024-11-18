package it.unibo.mvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public final class Controller {
    private static final String DEFAULT_PATH = System.getProperty("user.home")
            + System.getProperty("file.separator")
            + "output.txt";

    private File file;

    /**
     * Creates a new Controller with the default file output.txt.
     */
    public Controller() {
        this.file = new File(DEFAULT_PATH);
    }

    /**
     * @return the current File.
     */
    public File getFile() {
        return file;
    }

    /**
     * Sets the current file.
     * 
     * @param file to open.
     */
    public void setFile(final File file) {
        this.file = file;
    }

    /**
     * @return the path of the current file.
     */
    public String getPath() {
        return this.file.getPath();
    }

    /**
     * Writes a string to the current file.
     * 
     * @param string to write
     * @throws FileNotFoundException If the file doesn't exist.
     * @throws IOException           For other I/O errors.
     */
    public void write(final String string) throws IOException, FileNotFoundException {
        try (PrintStream ps = new PrintStream(file, StandardCharsets.UTF_8)) {
            ps.println(string);
        }
    }
}
