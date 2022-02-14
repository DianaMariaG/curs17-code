package homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ro.fasttrackit.curs17.homework.Person;
import ro.fasttrackit.curs17.homework.PersonService;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions.*;

import java.util.*;

public class PersonServiceTest {
    @Test
    @DisplayName("WHEN you have a List<Person> THEN list first names and last names in List<String>")
    void testListNames() {
        //SETUP
        List<Person> persons = new ArrayList<>(List.of(new Person("Alin","Brad",44,"Cluj"),
                new Person("Andra","Fag",14,"Oradea"),
                new Person("Mara","Molid",18,"Iasi")));
        PersonService personService = new PersonService(persons);

        List<String> expected = Arrays.asList("Alin Brad", "Andra Fag", "Mara Molid");
        //RUN + ASSERT
        assertThat(personService.listNames()).isEqualTo(expected);
    }

    @Test
    @DisplayName("WHEN you have a List<Person> THEN list persons older than 18")
    void testListMajorPersons() {
        //SETUP
        List<Person> persons = new ArrayList<>(List.of(new Person("Alin","Brad",44,"Cluj"),
                new Person("Andra","Fag",14,"Oradea"),
                new Person("Mara","Molid",18,"Iasi")));
        PersonService personService = new PersonService(persons);

        List<Person> expected = new ArrayList<>(List.of(new Person("Alin","Brad",44,"Cluj"),
                new Person("Mara","Molid",18,"Iasi")));

        //RUN + ASSERT
        assertThat(personService.listMajorPersons()).isEqualTo(expected);
    }

    @Test
    @DisplayName("WHEN you have a List<Person> THEN list persons from Oradea")
    void testListOradeanPeople() {
        //SETUP
        List<Person> persons = new ArrayList<>(List.of(new Person("Alin","Brad",44,"Cluj"),
                new Person("Andra","Fag",14,"Oradea"),
                new Person("Mara","Molid",18,"Iasi")));
        PersonService personService = new PersonService(persons);

        List<Person> expected = new ArrayList<>(List.of(new Person("Andra","Fag",14,"Oradea")));

        //RUN + ASSERT
        assertThat(personService.listOradeanPeople()).isEqualTo(expected);
    }

    @Test
    @DisplayName("WHEN you have a List<Person> THEN list persons from Oradea or Cluj")
    void testListOradeaOrClujPeople() {
        //SETUP
        List<Person> persons = new ArrayList<>(List.of(new Person("Alin","Brad",44,"Cluj"),
                new Person("Andra","Fag",14,"Oradea"),
                new Person("Mara","Molid",18,"Iasi")));
        PersonService personService = new PersonService(persons);

        List<Person> expected = new ArrayList<>(List.of(new Person("Alin","Brad",44,"Cluj"),
                new Person("Andra","Fag",14,"Oradea")));

        //RUN + ASSERT
        assertThat(personService.listOradeaOrClujPeople()).isEqualTo(expected);
    }

    @Test
    @DisplayName("WHEN you have a List<Person> THEN list first names capitalized")
    void testListFirstNamesCapitalized() {
        //SETUP
        List<Person> persons = new ArrayList<>(List.of(new Person("Alin","Brad",44,"Cluj"),
                new Person("Andra","Fag",14,"Oradea"),
                new Person("Mara","Molid",18,"Iasi")));
        PersonService personService = new PersonService(persons);

        List<String> expected =  Arrays.asList("ALIN","ANDRA","MARA");

        //RUN + ASSERT
        assertThat(personService.listFirstNamesCapitalized()).isEqualTo(expected);
    }

    @Test
    @DisplayName("WHEN you have a List<Person> THEN list abbreviated names")
    void testListAbbreviatesNames() {
        //SETUP
        List<Person> persons = new ArrayList<>(List.of(new Person("Alin","Brad",44,"Cluj"),
                new Person("Andra","Fag",14,"Oradea"),
                new Person("Mara","Molid",18,"Iasi")));
        PersonService personService = new PersonService(persons);

        List<String> expected =  Arrays.asList("Alin B","Andra F","Mara M");

        //RUN + ASSERT
        assertThat(personService.listAbbreviatedNames()).isEqualTo(expected);
    }

    @Test
    @DisplayName("WHEN you have a List<Person> THEN list persons within age interval")
    void testListPersonsWithinAgeInterval() {
        List<Person> persons = new ArrayList<>(List.of(new Person("Alin","Brad",99,"Cluj"),
                new Person("Andra","Fag",14,"Oradea"),
                new Person("Mara","Molid",18,"Iasi")));
        PersonService personService = new PersonService(persons);

        List<Person> expected = new ArrayList<>(List.of(new Person("Mara","Molid",18,"Iasi")));

        //RUN + ASSERT
        assertThat(personService.listPersonsWithinAgeInterval()).isEqualTo(expected);
    }

    @Test
    @DisplayName("WHEN you have a List<Person> THEN list persons with first letter 'A")
    void testListPersonsWithFirstLetterA() {
        List<Person> persons = new ArrayList<>(List.of(new Person("Alin","Brad",99,"Cluj"),
                new Person("Andra","Fag",14,"Oradea"),
                new Person("Mara","Molid",18,"Iasi")));
        PersonService personService = new PersonService(persons);

        List<Person> expected = new ArrayList<>(List.of(new Person("Alin","Brad",99,"Cluj"),
                new Person("Andra","Fag",14,"Oradea")));

        //RUN + ASSERT
        assertThat(personService.listPersonsWithFirstLetterA()).isEqualTo(expected);
    }

    @Test
    @DisplayName("WHEN you have a List<Person> THEN list all first names uniquely")
    void testListFirstNamesUniquely() {
        List<Person> persons = new ArrayList<>(List.of(new Person("Alin","Brad",99,"Cluj"),
                new Person("Andra","Fag",14,"Oradea"),
                new Person("Andra","Molid",18,"Iasi")));
        PersonService personService = new PersonService(persons);

        Set<String> expected = new HashSet<>(Arrays.asList("Alin","Andra"));

        //RUN + ASSERT
        assertThat(personService.listFirstNamesUniquely()).isEqualTo(expected);
    }

    @Test
    @DisplayName("WHEN you have a List<Person> THEN sort by first name/last name/name and age")
    void testSortByNameAndAge() {
        //SETUP
        List<Person> persons = new ArrayList<>(List.of(new Person("Mircea","Brad",44,"Cluj"),
                new Person("Andra","Fag",34,"Oradea"),
                new Person("Andra","Fag",18,"Iasi")));
        PersonService personService = new PersonService(persons);

        List<Person> expected = new ArrayList<>(List.of(
                new Person("Andra","Fag",18,"Iasi"),
                new Person("Andra","Fag",34,"Oradea"),
                new Person("Mircea","Brad",44,"Cluj")
        ));
        assertThat(personService.sortByFirstName()).isEqualTo(List.of(
                new Person("Andra","Fag",34,"Oradea"),
                new Person("Andra","Fag",18,"Iasi") ,
                new Person("Mircea","Brad",44,"Cluj")
        ));
        assertThat(personService.sortByLastName()).isEqualTo(List.of(
                new Person("Mircea","Brad",44,"Cluj"),
                new Person("Andra","Fag",34,"Oradea"),
                new Person("Andra","Fag",18,"Iasi")
        ));
        assertThat(personService.sortByNameAndAge()).isEqualTo(expected);
    }


    @Test
    @DisplayName("WHEN null or empty fileds are given THEN throw exception")
    void testNullFields() {
        IllegalArgumentException exc1 = assertThrows(IllegalArgumentException.class,
                () -> new Person(null, "Marian",13,"Cluj"));
        assertThat(exc1.getMessage()).isEqualTo("Null or empty word is not accepted!");

        IllegalArgumentException exc2 = assertThrows(IllegalArgumentException.class,
                () -> new Person("Amalia",null,11,"Iasi"));
        assertThat(exc2.getMessage()).isEqualTo("Null or empty word is not accepted!");

        IllegalArgumentException exc3 = assertThrows(IllegalArgumentException.class,
                ()-> new Person("Mihai","Suciu",88,null));
        assertThat(exc3.getMessage()).isEqualTo("Null or empty word is not accepted!");

        IllegalArgumentException exc4 = assertThrows(IllegalArgumentException.class,
                ()-> new Person("Ingrid","Costea",-55,"Timisoara"));
        assertThat(exc4.getMessage()).isEqualTo("Age is not valid!");
    }

    @Test
    @DisplayName("WHEN null list or list containing null element is given THEN throw exception")
    void testNullList() {
        IllegalArgumentException exc1 = assertThrows(IllegalArgumentException.class,
                ()-> new PersonService(null));
        assertThat(exc1.getMessage()).isEqualTo("Null list or null element in list not accepted!");

        IllegalArgumentException exc2 = assertThrows(IllegalArgumentException.class,
                ()-> new PersonService(List.of(
                        new Person("Anca","Mar",44,"Cluj"))));
        assertThat(exc2.getMessage()).isEqualTo("Null list or null element in list not accepted!");
    }
}
