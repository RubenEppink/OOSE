package ica.han.oose;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    public int add(String numbers) {
        return Arrays.stream(numbers.split("\\D+"))
                .filter(i -> !i.isEmpty())
                .mapToInt(Integer::parseInt)
                .filter(i -> i <= 1000)
                .boxed().reduce(0, (a, b) -> a + b);
    }
}

