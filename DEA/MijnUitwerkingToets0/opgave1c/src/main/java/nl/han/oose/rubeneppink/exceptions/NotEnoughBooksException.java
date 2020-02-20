package nl.han.oose.rubeneppink.exceptions;

public class NotEnoughBooksException extends RuntimeException {

    public NotEnoughBooksException (String errorMessage) {
        super(errorMessage);
    }
}
