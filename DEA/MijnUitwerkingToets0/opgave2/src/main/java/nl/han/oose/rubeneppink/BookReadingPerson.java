package nl.han.oose.rubeneppink;

public class BookReadingPerson implements Runnable {

    private final BookCase bookCase;
    private final int amount;

    public BookReadingPerson(BookCase bookCase, int amount){

        this.bookCase = bookCase;
        this.amount = amount;
    }

    private void takeOrAddBooks(){
        if (amount < 0){
            int takenAmount = bookCase.takeBooks(amount);

            if (takenAmount == 0){
                System.out.println("Bummer, They didn't have enough books.");
            }
        } else {
            bookCase.addBooks(amount);
        }

        System.out.println(Thread.currentThread().getName() + bookCase.getContent());
    }

    @Override
    public void run() {
        takeOrAddBooks();
    }
}
