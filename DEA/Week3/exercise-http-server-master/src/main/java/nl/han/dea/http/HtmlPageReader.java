package nl.han.dea.http;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

public class HtmlPageReader {

    public String readFile(String filename) {
        var fullFileName = "pages/".concat(filename);
        try {
            ClassLoader classLoader = getClass().getClassLoader();

            var file = new File(Objects.requireNonNull(classLoader.getResource(fullFileName)).getFile()).toPath();

            return new String(Files.readAllBytes(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

