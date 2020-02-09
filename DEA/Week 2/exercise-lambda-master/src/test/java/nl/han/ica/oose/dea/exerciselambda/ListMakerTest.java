package nl.han.ica.oose.dea.exerciselambda;

import nl.han.ica.oose.dea.exerciselambda.builders.PersonBuilder;
import nl.han.ica.oose.dea.exerciselambda.person.Gender;
import nl.han.ica.oose.dea.exerciselambda.person.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class ListMakerTest {

    private ListMaker listMaker;
    private List<Person> persons;

    @BeforeEach
    void setup() {
        listMaker = new ListMaker();
        persons = new ArrayList<>();
    }

    @Test
    void testAdultFemaleOnNullValue() {
        // Arrange

        // Act
        List<Person> femaleMaleAdultList = listMaker.createFemaleAdultList(null);

        // Assert
        Assertions.assertEquals(0, femaleMaleAdultList.size());
    }

    @Test
    void testAdultFemaleOnEmptyList() {
        // Arrange

        // Act
        List<Person> femaleMaleAdultList = listMaker.createFemaleAdultList(persons);

        // Assert
        Assertions.assertEquals(0, femaleMaleAdultList.size());
    }

    @Test
    void testAdultFemaleList() {
        // Arrange
        Person person1 = PersonBuilder.aPerson().withFirstName("A").withLastName("A").withGender(Gender.FEMALE).withBirthDate(LocalDate.now().minusYears(20)).build();
        Person person2 = PersonBuilder.aPerson().withFirstName("B").withLastName("B").withGender(Gender.MALE).withBirthDate(LocalDate.now().minusYears(30)).build();
        Person person3 = PersonBuilder.aPerson().withFirstName("C").withLastName("C").withGender(Gender.FEMALE).withBirthDate(LocalDate.now().minusYears(40)).build();
        Person person4 = PersonBuilder.aPerson().withFirstName("D").withLastName("D").withGender(Gender.MALE).withBirthDate(LocalDate.now().minusYears(10)).build();
        Person person5 = PersonBuilder.aPerson().withFirstName("E").withLastName("E").withGender(Gender.FEMALE).withBirthDate(LocalDate.now().minusYears(18)).build();

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        // Act
        List<Person> femaleMaleAdultList = listMaker.createFemaleAdultList(persons);

        // Assert
        Assertions.assertEquals(2, femaleMaleAdultList.size());
    }

    @Test
    void testAdultMaleOnNullValue() {
        // Arrange

        // Act
        List<Person> maleMaleAdultList = listMaker.createMaleAdultList(null);

        // Assert
        Assertions.assertEquals(0, maleMaleAdultList.size());
    }

    @Test
    void testAdultMaleOnEmptyList() {
        // Arrange

        // Act
        List<Person> maleMaleAdultList = listMaker.createMaleAdultList(persons);

        // Assert
        Assertions.assertEquals(0, maleMaleAdultList.size());
    }

    @Test
    void testAdultMaleList() {
        // Arrange
        Person person1 = PersonBuilder.aPerson().withFirstName("A").withLastName("A").withGender(Gender.FEMALE).withBirthDate(LocalDate.now().minusYears(23)).build();
        Person person2 = PersonBuilder.aPerson().withFirstName("B").withLastName("B").withGender(Gender.MALE).withBirthDate(LocalDate.now().minusYears(33)).build();
        Person person3 = PersonBuilder.aPerson().withFirstName("C").withLastName("C").withGender(Gender.FEMALE).withBirthDate(LocalDate.now().minusYears(10)).build();
        Person person4 = PersonBuilder.aPerson().withFirstName("D").withLastName("D").withGender(Gender.FEMALE).withBirthDate(LocalDate.now().minusYears(13)).build();
        Person person5 = PersonBuilder.aPerson().withFirstName("E").withLastName("E").withGender(Gender.MALE).withBirthDate(LocalDate.now().minusYears(15)).build();

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        // Act
        List<Person> maleAdultList = listMaker.createMaleAdultList(persons);

        // Assert
        Assertions.assertEquals(1, maleAdultList.size());
    }
}
