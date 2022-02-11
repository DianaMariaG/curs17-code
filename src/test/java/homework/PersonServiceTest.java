package homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ro.fasttrackit.curs17.homework.Person;
import ro.fasttrackit.curs17.homework.PersonService;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonServiceTest {
    @Test
    @DisplayName("WHEN... list")
    void testListNames() {
        //SETUP
        List<Person> persons = new ArrayList<>(List.of(new Person("Alin","Brad",44,"Cluj"),
                new Person("Andra","Fag",14,"Oradea"),
                new Person("Mara","Molid",18,"Iasi")));
        PersonService personService = new PersonService(persons);

        List<String> result = Arrays.asList("Alin Brad", "Andra Fag", "Mara Molid");
        //RUN + ASSERT
        assertThat(personService.listNames().equals(result));
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
