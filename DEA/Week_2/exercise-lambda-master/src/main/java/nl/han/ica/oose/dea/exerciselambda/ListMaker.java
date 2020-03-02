package nl.han.ica.oose.dea.exerciselambda;

import nl.han.ica.oose.dea.exerciselambda.person.Gender;
import nl.han.ica.oose.dea.exerciselambda.person.Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListMaker {
    /**
     * Create a {@link List} containing only the Persons that are both male and adult.
     *
     * @param allPersons A {@link List} of {@link Person} Objects
     * @return A {@link List} containing only the Persons that are both male and adult
     */
    public List<Person> createMaleAdultList(List<Person> allPersons) {
        return createAdultList(allPersons, Gender.MALE);
    }

    /**
     * Create a {@link List} containing only the Persons that are both female and adult.
     *
     * @param allPersons A {@link List} of {@link Person} Objects
     * @return A {@link List} containing only the Persons that are both female and adult
     */
    public List<Person> createFemaleAdultList(List<Person> allPersons) {
        return createAdultList(allPersons, Gender.FEMALE);
    }

    private List<Person> createAdultList(List<Person> allPersons, Gender gender) {

//Predicate<Person> p = i -> i.isAdult();

        if (allPersons == null) {
            return new ArrayList<>();
        }

        return allPersons.stream()
                .filter(i -> i.isAdult()
                        && i.getGender().equals(gender))
                .collect(Collectors.toList());
    }

}
