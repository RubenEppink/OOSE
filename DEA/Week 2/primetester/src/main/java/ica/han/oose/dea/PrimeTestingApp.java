package ica.han.oose.dea;

public class PrimeTestingApp {

    private static final int HIGHEST_NUMBER_TO_TEST = 2000;

    public static void main(String[] args) {
        var app = new PrimeTestingApp();
        app.startTesting();
    }

    private void startTesting() {
        var numberUnderTest = new NumberUnderTest();

        var tester = new PrimeTester(numberUnderTest, HIGHEST_NUMBER_TO_TEST);
        var tester1 = new PrimeTester(numberUnderTest, HIGHEST_NUMBER_TO_TEST);
        var tester2 = new PrimeTester(numberUnderTest, HIGHEST_NUMBER_TO_TEST);
        var tester3 = new PrimeTester(numberUnderTest, HIGHEST_NUMBER_TO_TEST);

        Thread t1 = new Thread(tester, "1");
        Thread t2 = new Thread(tester1, "2");
        Thread t3 = new Thread(tester2, "3");
        Thread t4 = new Thread(tester3, "4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
