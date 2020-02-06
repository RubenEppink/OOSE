package ica.han.oose;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    public int add(String numbers) {

        List<String> numberList;

        if (numbers.equals("")) {
            return 0;
        }

        try {
            numberList = Arrays.stream(numbers.split("\\D+")).collect(Collectors.toList());

            numberList.removeIf(i -> i.matches("\\s") || i.matches(""));


            numberList.forEach(i -> System.out.println(i));
        } catch (NumberFormatException e) {
            System.out.println("xd");
            return 0;
        }

        List<Integer>  yolo = numberList.stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        yolo.removeIf(i -> i > 1000);

        return yolo.stream()
                .reduce(0, (a, b) -> a + b);
    }
}

