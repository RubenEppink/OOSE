package nl.han.oose.rubeneppink;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        BookCase bookCase = new BookCase(100);

        new Thread(new BookReadingPerson(bookCase, 10), "thread 1: ").start();
        new Thread(new BookReadingPerson(bookCase, 25), "thread 2: ").start();
        new Thread(new BookReadingPerson(bookCase, -37), "thread 3: ").start();
        new Thread(new BookReadingPerson(bookCase, -5), "thread 4: ").start();
        new Thread(new BookReadingPerson(bookCase, 42), "thread 5: ").start();
    }
}
