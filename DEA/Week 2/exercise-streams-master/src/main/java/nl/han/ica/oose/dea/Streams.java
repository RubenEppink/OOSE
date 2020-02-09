package nl.han.ica.oose.dea;


import nl.han.ica.oose.dea.helpers.Product;

import java.util.List;
import java.util.stream.Collectors;

class Streams {

    List<String> filterStringsLongerThanThreeCharacters(List<String> input) {
        return input.stream().filter(i -> i.length() < 3).collect(Collectors.toList());
    }

    List<String> filterStringsThatContainOnlyNumerals(List<String> input) {
        return input.stream().filter(i -> i.matches("\\d+")).collect(Collectors.toList());
    }

    String findShortestString(List<String> input) {
        return input.stream().filter(word -> word.length() == input.stream().map(String::length).sorted().findFirst().get()).findFirst().get();
    }


    String createAFullSentenceFromTheList(List<String> input) {
        StringBuffer sb = new StringBuffer("");
        input.forEach(i -> sb.append(i).append(" "));

        return sb.toString().trim();
    }

    int calculateTotalCostOfAllProducts(List<Product> products) {
        return products.stream().map(Product::getPrice).reduce(0, (a, b) -> a + b);
    }
}
