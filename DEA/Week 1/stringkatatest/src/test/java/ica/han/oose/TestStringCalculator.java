package ica.han.oose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestStringCalculator {
    int testValue;
    private StringCalculator sut;

    @BeforeEach
    public void setup() {
        sut = new StringCalculator();

    }

 /*   @ParameterizedTest
    @CsvSource(value = {"d:0", "1:1", "1,2:3"}, delimiter = ':')
    public void testAddWithEmptyString(int expected, String actualValue) {
        expected = sut.add(actualValue);

        Assertions.assertEquals(expected, actualValue);


    }*/


    @Test
    public void testEmpty() {
        testValue = sut.add("");

        Assertions.assertEquals(testValue, 0);
    }

    @Test
    public void testOne() {
        testValue = sut.add("1");

        Assertions.assertEquals(testValue, 1);
    }

    @Test
    public void testAddition() {
        testValue = sut.add("1,2");

        Assertions.assertEquals(testValue, 3);
    }

    @Test
    public void testNewLine() {
        testValue = sut.add("1\\n2,3");

        Assertions.assertEquals(testValue, 6);
    }

    @Test
    public void testDelimiter() {
        testValue = sut.add("//;\\n1;2");

        Assertions.assertEquals(testValue, 3);
    }

    @Test
    public void testOverAThousand() {
        testValue = sut.add("2, 1001");

        Assertions.assertEquals(testValue, 2);

    }

    @Test
    public void testMultipleDelimiters() {
        testValue = sut.add("//[***]\\n1***2***3");

        Assertions.assertEquals(testValue, 6);
    }
}
