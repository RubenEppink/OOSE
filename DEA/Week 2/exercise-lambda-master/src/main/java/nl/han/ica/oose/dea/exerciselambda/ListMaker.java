package nl.han.ica.oose.dea.exerciselambda;

import nl.han.ica.oose.dea.exerciselambda.person.Gender;
import nl.han.ica.oose.dea.exerciselambda.person.Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class ListMaker {

    /**
     * Create a {@link List} containing only the Persons that are both male and adult.
     *
     * @param allPersons A {@link List} of {@link Person} Objects
     * @return A {@link List} containing only the Persons that are both male and adult
     */
    public List<Person> createMaleAdultList(List<Person> allPersons) {

        if (allPersons == null) {
            return new ArrayList<>();
        }

        List<Person> filteredMaleAdults = new ArrayList<>();

        for (Person person : allPersons) {
            if (person.getGender().equals(Gender.MALE)) {
                LocalDate now = LocalDate.now();
                Period age = Period.between(person.getBirthDate(), now);

                if (age.getYears() > 18) {
                    filteredMaleAdults.add(person);
                }

            }
        }

        return filteredMaleAdults;
    }

    /**
     * Create a {@link List} containing only the Persons that are both female and adult.
     *
     * @param allPersons A {@link List} of {@link Person} Objects
     * @return A {@link List} containing only the Persons that are both female and adult
     */
    public List<Person> createFemaleAdultList(List<Person> allPersons) {

        if (allPersons == null) {
            return new ArrayList<>();
        }

        List<Person> filteredFemaleAdults = new ArrayList<>();

        for (Person person : allPersons) {
            if (person.getGender().equals(Gender.FEMALE)) {
                LocalDate now = LocalDate.now();
                Period age = Period.between(person.getBirthDate(), now);

                if (age.getYears() > 18) {
                    filteredFemaleAdults.add(person);
                }
            }
        }


        return filteredFemaleAdults;
    }

}
