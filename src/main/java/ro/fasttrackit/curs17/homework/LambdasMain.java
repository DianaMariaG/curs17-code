package ro.fasttrackit.curs17.homework;

import java.util.List;

public class LambdasMain {
    public static void main(String[] args) {
        PersonService persons = new PersonService(List.of(
             new Person("Silvia","Damas",33,"Cluj"),
             new Person("Mara","Turc",56,"Oradea"),
             new Person("Casandra","Stoica",88,"Sibiu") ,
             new Person("Oana","Fag",41,"Constanta"),
             new Person("Marius","Enea",16,"Cluj"),
             new Person("Alin","Rac",14,"Oradea"),
             new Person("Silvia","Craciun",90,"Brasov")
        ));

        System.out.println(persons.listNames());
        System.out.println(persons.listMajorPersons());
        System.out.println(persons.listOradeanPeople());
        System.out.println(persons.listOradeaOrClujPeople());
        System.out.println(persons.listFirstNamesCapitalized());
        System.out.println(persons.listAbbreviatedNames());
        System.out.println(persons.listPersonsWithinAgeInterval());
        System.out.println(persons.listPersonsWithFirstLetterA());
        System.out.println(persons.listFirstNamesUniquely());
        System.out.println(persons.sortByFirstName());
        System.out.println(persons.sortByLastName());
        System.out.println(persons.sortByNameAndAge());
    }
}
