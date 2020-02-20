package nl.oose.dea.opdrachtdrie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;


public class LoggerTest {

    private static final String MSG = "MSG";
    private PrintStream printStream;

    @BeforeEach
    void setup() {
        printStream = Mockito.mock(PrintStream.class);
    }

    @Test
    public void logPassesMessageToOutStream() throws Exception {
        System.setOut(printStream);
        var logger = new Logger();
        logger.log(MSG);
        verify(printStream).println(MSG);
    }

}
