package ica.han.oose.dea;

import ica.han.oose.dea.exceptions.OuchIFoundThirtySevenAndHenceMustDieException;

public class PrimeTestingApp {

    private static final int HIGHEST_NUMBER_TO_TEST = 2000;

    public static void main(String[] args) {
        var app = new PrimeTestingApp();
        app.startTesting();
    }

    private void startTesting() {
        var numberUnderTest = new NumberUnderTest();

        Runnable run = () -> {
            try {
                new PrimeTester(numberUnderTest, HIGHEST_NUMBER_TO_TEST).startTesting();
            } catch (OuchIFoundThirtySevenAndHenceMustDieException e) {
                e.printStackTrace();
            }
        };


        Thread t1 = new Thread(run, "1");
        Thread t2 = new Thread(run, "2");
        Thread t3 = new Thread(run, "3");
        Thread t4 = new Thread(run, "4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
