package nl.han.ica.oose.dea.exerciselambda.builders;

import nl.han.ica.oose.dea.exerciselambda.person.Gender;
import nl.han.ica.oose.dea.exerciselambda.person.Person;

import java.time.LocalDate;

/**
 * A {@code PersonBuilder} follows the Builder-pattern that simplifies Object construction.
 */
public final class PersonBuilder {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Gender gender;

    private PersonBuilder() {
    }

    public static PersonBuilder aPerson() {
        return new PersonBuilder();
    }

    public PersonBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder withBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public PersonBuilder withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Person build() {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setBirthDate(birthDate);
        person.setGender(gender);
        return person;
    }
}
