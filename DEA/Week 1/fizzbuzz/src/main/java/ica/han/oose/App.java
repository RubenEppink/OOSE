package ica.han.oose;

public class App {

    public static void main(String[] args) {
        fizzbuzz();
    }

    private static void fizzbuzz() {
        for (int i = 1; i <= 100; i++) {
            System.out.println((i % 3 == 0) && (i % 5 == 0) ? "Fizzbuzz" : (i % 3 == 0) ? "Fizz" : (i % 5 == 0) ? "Buzz" : Integer.toString(i));
        }
    }
}
