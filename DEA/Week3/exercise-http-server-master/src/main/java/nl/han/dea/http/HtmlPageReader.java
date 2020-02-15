package nl.han.dea.http;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class HtmlPageReader {

    private String fullFileName;

    public HtmlPageReader(String filename) {
        this.fullFileName = "pages/".concat(filename);
    }

    public String readFile() throws ResourceNotAvailableException {

        try {
            return new String(Files.readAllBytes(getPath()));
        } catch (IOException | ResourceNotAvailableException e) {
            throw new ResourceNotAvailableException();
        }
    }

    public String getLength() throws ResourceNotAvailableException {
        if (fullFileName.isEmpty()) {
            return "0";
        }

        try {
            return Long.toString(readFile().getBytes().length);
        } catch (NullPointerException e) {
            throw new ResourceNotAvailableException();
        }
    }

    private Path getPath() throws ResourceNotAvailableException {
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            return new File(classLoader.getResource(fullFileName).getFile()).toPath();
        } catch (NullPointerException e) {
            throw new ResourceNotAvailableException();
        }
    }
}

