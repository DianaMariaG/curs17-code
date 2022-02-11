package ro.fasttrackit.curs17.homework;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class PersonService {
    private final List<Person> persons = new ArrayList<>();

    public PersonService(List<Person> persons) {
        if (persons != null) {
            this.persons.addAll(persons);
        }
    }
    //list all the persons names: firstName lastName
    public List<String> listNames() {
         return  persons.stream()
                .map(person -> person.firstName() + " " + person.lastName())
                .collect(toList());
    }

    //list all persons that are major
    public List<Person> listMajorPersons() {
         List<Person> result = persons.stream()
                .filter(person -> person.age() >= 18)
                .collect(toList());
         return result;
    }

    //list all persons from Oradea
    public List<Person> listOradeanPeople() {
        return persons.stream()
                .filter(person -> "Oradea".equals(person.city()))
                .collect(toList());
    }

    //list all persons from Oradea OR Cluj
    public List<Person> listOradeaOrClujPeople() {
        return persons.stream()
                .filter(person -> "Oradea".equals(person.city()) || "Cluj".equals(person.city()))
                .collect(toList());
    }

    //list all firstNames CAPITALIZED
    public List<String> listFirstNamesCapitalized() {
        return persons.stream()
                .map (person -> person.firstName().toUpperCase())
                .collect(toList());
    }

    //list all person names: firstName firstletter from last name: Stefan B
    public List<String> listAbbreviatedNames() {
        return persons.stream()
                .map(person -> person.firstName() + " " + Character.toString(person.lastName().charAt(0)))
                .collect(toList());
    }

    //list all persons with 18 < age < 60
    public List<Person> listPersonsWithinAgeInterval() {
        return persons.stream()
                .filter(person -> person.age() >= 18 && person.age() <= 60)
                .collect(toList());
    }

    //list all persons having first name starting with A
    public List<Person> listPersonsWithFirstLetterA() {
        return persons.stream()
                .filter(person -> (person.firstName().charAt(0) == 'A'))
                .collect(toList());
    }

    //list all first names UNIQUELY
    public Set<String> listFirstNamesUniquely() {
        return persons.stream()
                .map(persons -> persons.firstName())
                .collect(Collectors.toSet());
    }

    //sort the persons by first name
    public List<Person> sortByFirstName() {
        return persons.stream()
                .sorted(comparing(person -> person.firstName())) //de ce merge si person si persons?
                .collect(toList());
    }

    //sort the persons by last name
    public List<Person> sortByLastName() {
        return persons.stream()
                .sorted(comparing(persons -> persons.lastName()))
                .collect(toList());
    }

    //sort the persons by first name, last name and then age
    public List<Person> sortByNameAndAge() {
         return persons.stream()
                .sorted(comparing((Person persons) -> persons.firstName())
                        .thenComparing(persons ->persons.lastName())
                        .thenComparingInt(persons -> persons.age()))
                .collect(toList());
    }
}
