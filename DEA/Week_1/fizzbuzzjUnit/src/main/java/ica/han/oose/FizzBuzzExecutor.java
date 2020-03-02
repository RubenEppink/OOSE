package ica.han.oose;

public class FizzBuzzExecutor {

    public String execute(int i) {
        return (i % 3 == 0) && (i % 5 == 0) ? "FizzBuzz" : (i % 3 == 0) ? "Fizz" : (i % 5 == 0) ? "Buzz" : Integer.toString(i);
    }
}
