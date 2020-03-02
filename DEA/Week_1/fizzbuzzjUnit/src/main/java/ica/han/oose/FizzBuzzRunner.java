package ica.han.oose;

public class FizzBuzzRunner {

    public static void main(String[] args) {
        FizzBuzzExecutor fizzBuzzExecutor = new FizzBuzzExecutor();

        for (int i = 1; i <= 100; i++) {
            System.out.println(fizzBuzzExecutor.execute(i));
        }
    }
}
