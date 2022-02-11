package homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ro.fasttrackit.curs17.homework.Person;
import ro.fasttrackit.curs17.homework.PersonService;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

        List<String> result = Arrays.asList("Alin Brad", "Andra Fag", "Mara Molid");
        //RUN + ASSERT
        assertThat(personService.listNames()).isEqualTo(result);
    }

    @Test
    @DisplayName("WHEN you have a List<Person> THEN list persons older than 18")
    void testListMajorPersons() {
        //SETUP
        List<Person> persons = new ArrayList<>(List.of(new Person("Alin","Brad",44,"Cluj"),
                new Person("Andra","Fag",14,"Oradea"),
                new Person("Mara","Molid",18,"Iasi")));
        PersonService personService = new PersonService(persons);

        List<Person> result = new ArrayList<>(List.of(new Person("Alin","Brad",44,"Cluj"),
                new Person("Mara","Molid",18,"Iasi")));

        //RUN + ASSERT
        assertThat(personService.listMajorPersons()).isEqualTo(result);
    }

    @Test
    @DisplayName("WHEN you have a List<Person> THEN list persons from Oradea")
    void testListOradeanPeople() {
        //SETUP
        List<Person> persons = new ArrayList<>(List.of(new Person("Alin","Brad",44,"Cluj"),
                new Person("Andra","Fag",14,"Oradea"),
                new Person("Mara","Molid",18,"Iasi")));
        PersonService personService = new PersonService(persons);

        List<Person> result = new ArrayList<>(List.of(new Person("Andra","Fag",14,"Oradea")));

        //RUN + ASSERT
        assertThat(personService.listOradeanPeople()).isEqualTo(result);
    }

    @Test
    @DisplayName("WHEN you have a List<Person> THEN list persons from Oradea or Cluj")
    void testListOradeaOrClujPeople() {
        //SETUP
        List<Person> persons = new ArrayList<>(List.of(new Person("Alin","Brad",44,"Cluj"),
                new Person("Andra","Fag",14,"Oradea"),
                new Person("Mara","Molid",18,"Iasi")));
        PersonService personService = new PersonService(persons);

        List<Person> result = new ArrayList<>(List.of(new Person("Alin","Brad",44,"Cluj"),
                new Person("Andra","Fag",14,"Oradea")));

        //RUN + ASSERT
        assertThat(personService.listOradeaOrClujPeople()).isEqualTo(result);
    }

    @Test
    @DisplayName("WHEN you have a List<Person> THEN list first names capitalized")
    void testListFirstNamesCapitalized() {
        //SETUP
        List<Person> persons = new ArrayList<>(List.of(new Person("Alin","Brad",44,"Cluj"),
                new Person("Andra","Fag",14,"Oradea"),
                new Person("Mara","Molid",18,"Iasi")));
        PersonService personService = new PersonService(persons);

        List<String> result =  Arrays.asList("ALIN","ANDRA","MARA");

        //RUN + ASSERT
        assertThat(personService.listFirstNamesCapitalized()).isEqualTo(result);
    }

    @Test
    @DisplayName("WHEN you have a List<Person> THEN list abbreviated names")
    void testListAbbreviatesNames() {
        //SETUP
        List<Person> persons = new ArrayList<>(List.of(new Person("Alin","Brad",44,"Cluj"),
                new Person("Andra","Fag",14,"Oradea"),
                new Person("Mara","Molid",18,"Iasi")));
        PersonService personService = new PersonService(persons);

        List<String> result =  Arrays.asList("Alin B","Andra F","Mara M");

        //RUN + ASSERT
        assertThat(personService.listAbbreviatedNames()).isEqualTo(result);
    }

    @Test
    @DisplayName("WHEN you have a List<Person> THEN list persons within age interval")
    void testListPersonsWithinAgeInterval() {
        List<Person> persons = new ArrayList<>(List.of(new Person("Alin","Brad",99,"Cluj"),
                new Person("Andra","Fag",14,"Oradea"),
                new Person("Mara","Molid",18,"Iasi")));
        PersonService personService = new PersonService(persons);

        List<Person> result = new ArrayList<>(List.of(new Person("Mara","Molid",18,"Iasi")));

        //RUN + ASSERT
        assertThat(personService.listPersonsWithinAgeInterval()).isEqualTo(result);
    }

    @Test
    @DisplayName("WHEN you have a List<Person> THEN list persons with first letter 'A")
    void testListPersonsWithFirstLetterA() {
        List<Person> persons = new ArrayList<>(List.of(new Person("Alin","Brad",99,"Cluj"),
                new Person("Andra","Fag",14,"Oradea"),
                new Person("Mara","Molid",18,"Iasi")));
        PersonService personService = new PersonService(persons);

        List<Person> result = new ArrayList<>(List.of(new Person("Alin","Brad",99,"Cluj"),
                new Person("Andra","Fag",14,"Oradea")));

        //RUN + ASSERT
        assertThat(personService.listPersonsWithFirstLetterA()).isEqualTo(result);
    }

    @Test
    @DisplayName("WHEN you have a List<Person> THEN list all first names uniquely")
    void testListFirstNamesUniquely() {
        List<Person> persons = new ArrayList<>(List.of(new Person("Alin","Brad",99,"Cluj"),
                new Person("Andra","Fag",14,"Oradea"),
                new Person("Andra","Molid",18,"Iasi")));
        PersonService personService = new PersonService(persons);

        Set<String> result = new HashSet<>(Arrays.asList("Alin","Andra"));

        //RUN + ASSERT
        assertThat(personService.listFirstNamesUniquely()).isEqualTo(result);
    }

    @Test
    @DisplayName("WHEN... return sorted")
    void testSortByNameAndAge() {
        //SETUP
        List<Person> persons = new ArrayList<>(List.of(new Person("Mircea","Brad",44,"Cluj"),
                new Person("Andra","Fag",34,"Oradea"),
                new Person("Andra","Fag",18,"Iasi")));
        PersonService personService = new PersonService(persons);

        List<Person> result = new ArrayList<>(List.of(
                new Person("Andra","Fag",34,"Iasi"),
                new Person("Andra","Fag",18,"Oradea"),
                new Person("Mircea","Brad",44,"Cluj")
        ));

//        assertThat(personService.sortByNameAndAge().
    }
}
