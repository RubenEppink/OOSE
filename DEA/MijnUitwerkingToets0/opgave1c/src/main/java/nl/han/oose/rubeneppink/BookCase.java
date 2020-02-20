package nl.han.oose.rubeneppink;

import nl.han.oose.rubeneppink.exceptions.NegativeAmountException;
import nl.han.oose.rubeneppink.exceptions.NotEnoughBooksException;

public class BookCase {
    private int content;

    public BookCase(int initialNumberOfBooks) {
        this.content = initialNumberOfBooks;
    }

    public void takeBooks(int numberOfBooks) throws NegativeAmountException {
        System.out.println("Number of Books before books were taken: " + this.content);

        if (numberOfBooks > this.content) {
            throw new NotEnoughBooksException("You're trying to take more books than that are available!");
        }

        int newNumberOfBooks = this.content-= numberOfBooks;
        setContent(newNumberOfBooks);

        System.out.println("Number of Books after books were taken: " + this.content);
    }

    public void placeBooks(int numberOfBooks) throws NegativeAmountException {
        System.out.println("Number of Books before books were put on the shelf: " + this.content);

       int newNumberOfBooks = this.content+= numberOfBooks;
       setContent(newNumberOfBooks);

        System.out.println("Number of Books after books were put on the shelf: " + this.content);
    }

    public String toString() {
        return "Number of books: " + this.content;
    }

    public void setContent(int content) throws NegativeAmountException {
        if (content < 0) {
            throw new NegativeAmountException("You're trying to set a negative amount of books!");
        }

        this.content = content;
    }

    public int getNumberOfBooks() {
        return content;
    }
}

