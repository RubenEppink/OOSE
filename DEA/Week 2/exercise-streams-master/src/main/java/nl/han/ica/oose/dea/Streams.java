package nl.han.ica.oose.dea;


import nl.han.ica.oose.dea.helpers.Product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Streams {

    List<String> filterStringsLongerThanThreeCharacters(List<String> input) {
        return input.stream()
                .filter(i -> i.length() < 3)
                .collect(Collectors.toList());
    }

    List<String> filterStringsThatContainOnlyNumerals(List<String> input) {
        return input.stream()
                .filter(i -> i.matches("\\d+"))
                .collect(Collectors.toList());
    }

    String findShortestString(List<String> input) {
       // return input.stream().sorted().findFirst().orElse(null);

        return input.stream().min(Comparator.comparingInt(String::length)).get();

       // return input.stream().sorted((e2, e1) -> e1.length() > e2.length() ? -1 : 1).findFirst().get();


      /*  return input.stream()
                .filter(word -> word.length() ==
                input.stream()
                        .map(String::length)
                        .sorted().findFirst()
                        .get())
                .findFirst()
                .get();*/

    }


    String createAFullSentenceFromTheList(List<String> input) {


        /* Oplossing 1

        StringBuffer sb = new StringBuffer("");
        input.forEach(i -> sb.append(i).append(" "));

        return sb.toString().trim();
        */



        /* Oplossing 2

        return input.stream().collect(Collectors.joining(" "));
         */


        return String.join(" ", input);

    }

    int calculateTotalCostOfAllProducts(List<Product> products) {
        return products.stream().mapToInt(Product::getPrice).sum();
       // return products.stream().map(Product::getPrice).reduce(0, Integer::sum);
    }
}
