package nl.han.oose.rubeneppink;

import nl.han.oose.rubeneppink.exceptions.NegativeAmountException;
import nl.han.oose.rubeneppink.exceptions.NotEnoughBooksException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookCaseTest {
    BookCase sut;

    @BeforeEach
    void bookCaseSetup() {
        //Arrange
        sut = new BookCase(10);

    }

    @Test
    void takeBooksTest() {

        try {
            sut.takeBooks(1);
        } catch (NegativeAmountException | NotEnoughBooksException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(9, sut.getNumberOfBooks());

    }

    @Test
    void placeBooksTest() {

        try {
            sut.placeBooks(1);
        } catch (NegativeAmountException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(11, sut.getNumberOfBooks());
    }

    @Test
    void setNegativeAmountOfBooksException() {
        Assertions.assertThrows(NegativeAmountException.class, () -> {
            sut.setContent(-10);
        });
    }

    @Test
    void notEnoughBooksException() {
        Assertions.assertThrows(NotEnoughBooksException.class, () -> {
            sut.takeBooks(20);
        });
    }
}
