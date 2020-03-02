package ica.han.oose;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class FizzBuzzExecutorTest {
    private FizzBuzzExecutor sut;

    @BeforeEach
    void setup() {
        sut = new FizzBuzzExecutor();
    }

    @Test
    void executeWithValidIntTest() {
        String testValue = sut.execute(37);
        Assertions.assertEquals("37", testValue);
    }

    @Test
    void executeWithIntDivisibleBy3() {
        String testValue = sut.execute(3);
        Assertions.assertEquals("Fizz", testValue);
    }

    @Test
    void executeWithIntDivisibleBy5() {
        String testValue = sut.execute(5);
        Assertions.assertEquals("Buzz", testValue);
    }

    @Test
    void executeWithIntDivisibleBy5And3() {
        String testValue = sut.execute(15);
        Assertions.assertEquals("FizzBuzz", testValue);
    }
}
