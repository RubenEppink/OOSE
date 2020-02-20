package nl.han.oose.rubeneppink;

public class BookCase {

    private int content;

    public BookCase(int initialNumberOfBooks) {
        this.content = initialNumberOfBooks;
    }

    public synchronized int takeBooks(int numberOfBooks) {
        if (numberOfBooks > this.content) {
            return 0;
        }
        this.content = this.content - numberOfBooks;
        return numberOfBooks;
    }

    public synchronized void addBooks(int numberOfBooks) {
        content = content + numberOfBooks;
    }

    public String toString() {
        return "BookCase contains" + content + " number of books";
    }

    public synchronized int getContent() {
        return content;
    }
}
