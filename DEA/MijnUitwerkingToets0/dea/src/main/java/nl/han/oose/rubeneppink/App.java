package nl.han.oose.rubeneppink;


import nl.han.oose.rubeneppink.exceptions.NegativeAmountException;
import nl.han.oose.rubeneppink.exceptions.NotEnoughBooksException;

public class App {
    private static BookCase bc;

    public static void main(String[] args) {
        bc = new BookCase(25);

        takeAndPlaceBook();

    }

    private static void takeAndPlaceBook() {
        try {
            bc.placeBooks(10);
        } catch (NegativeAmountException e) {

        }
        System.out.println("1");
        try {
            bc.takeBooks(50);
        } catch (NegativeAmountException | NotEnoughBooksException e) {

        }
        System.out.println("2");
        try {
            bc.takeBooks(20);
        } catch (NegativeAmountException | NotEnoughBooksException e) {

        }
        System.out.println("3");
        try {
            bc.placeBooks(14);
        } catch (NegativeAmountException e) {

        }
        System.out.println("4");
        try {
            bc.placeBooks(16);
        } catch (NegativeAmountException e) {

        }
        System.out.println("5");
        try {
            bc.takeBooks(40);
        } catch (NegativeAmountException | NotEnoughBooksException e) {

        }
        System.out.println("6");


    }
}
