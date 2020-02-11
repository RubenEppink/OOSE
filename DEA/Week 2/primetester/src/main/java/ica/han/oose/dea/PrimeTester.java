package ica.han.oose.dea;

import ica.han.oose.dea.exceptions.OuchIFoundThirtySevenAndHenceMustDieException;
import org.apache.commons.math3.primes.Primes;

import java.util.concurrent.locks.ReentrantReadWriteLock;


public class PrimeTester implements Runnable {

    NumberUnderTest numberUnderTest;
    int highestNumberToTest;
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    public PrimeTester(NumberUnderTest numberUnderTest, int highestNumberToTest) {
        this.numberUnderTest = numberUnderTest;
        this.highestNumberToTest = highestNumberToTest;
    }

    private void startTesting() throws OuchIFoundThirtySevenAndHenceMustDieException {

        while (true) {


            int number = numberUnderTest.getNumber();

            if (number == 37) {
                throw new OuchIFoundThirtySevenAndHenceMustDieException("oops I found 37");
            }

            if (number > highestNumberToTest){
                break;
            }

            boolean isPrime = Primes.isPrime(number);

            if (isPrime) {
                System.out.println(Thread.currentThread().getName() + " found a prime number: " + number);
            }
        }
    }

    @Override
    public void run() {

        try {
            startTesting();
        } catch (OuchIFoundThirtySevenAndHenceMustDieException e) {
            System.out.println(Thread.currentThread().getName() + " found thirty seven and must die");
        }
    }
}
