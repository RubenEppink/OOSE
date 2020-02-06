package ica.han.oose;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    public int add(String numbers) {
        List<Integer> numberList;

        if (numbers.equals("")) {
            return 0;
        }

        try {
            numberList = Arrays.stream(numbers.split("\\D+")).map(Integer::parseInt).collect(Collectors.toList());

          numberList.forEach(i -> System.out.println(i));
        } catch (NumberFormatException e) {
            System.out.println("xd");
            return 0;
        }

        return numberList.stream()
                .reduce(0, (a, b) -> a + b);
    }
}
