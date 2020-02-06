package ica.han.oose;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    public int add(String numbers) {

        List<String> numberList;

        if (numbers.isBlank()) {
            return 0;
        }

        try {
            numberList = Arrays.stream(numbers.split("\\D+")).collect(Collectors.toList());
            numberList.removeIf(i -> i.matches("\\s") || i.matches(""));
        } catch (NumberFormatException e) {
            return 0;
        }

        List<Integer> integerLijst = numberList.stream().mapToInt(Integer::parseInt).filter(i -> i <= 1000).boxed().collect(Collectors.toList());


        return integerLijst.stream()
                .reduce(0, (a, b) -> a + b);
    }
}

