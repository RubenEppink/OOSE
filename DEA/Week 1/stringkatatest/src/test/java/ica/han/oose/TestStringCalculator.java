package ica.han.oose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStringCalculator {
    private StringCalculator sut;

    @BeforeEach
    public void setup() {
        sut = new StringCalculator();

    }

    @ParameterizedTest
    @CsvSource(value = {"d:0", "1:1", "1,2:3"}, delimiter = ':')
    public void testAddWithEmptyString(int expected, String actualValue) {
        expected = sut.add(actualValue);

        Assertions.assertEquals(expected, actualValue);


    }


    @Test
    public void tester() {
        int testwaarde = sut.add("");

        Assertions.assertEquals(testwaarde, 0);
    }

    @Test
    public void tester1() {
        int testwaarde = sut.add("1");

        Assertions.assertEquals(testwaarde, 1);
    }

    public void tester12() {
        int testwaarde = sut.add("1,2");

        Assertions.assertEquals(testwaarde, 1);
    }

    public void testerr() {
        int testwaarde = sut.add("1\\n2,3");

        Assertions.assertEquals(testwaarde, 6);
    }

    public void testerdelimiter() {
        int testwaarde = sut.add("//;\\n1;2");

        Assertions.assertEquals(testwaarde, 3);
    }

    public void testerduizend() {
        int testwaarde = sut.add("2, 1001");

        Assertions.assertEquals(testwaarde, 2);

    }

    public void testermeerderedelimiters() {
        int testwaarde = sut.add("//[***]\\n1***2***3");

        Assertions.assertEquals(testwaarde, 6);
    }
}
