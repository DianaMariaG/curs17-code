package ro.fasttrackit.curs17.homework;

import static ro.fasttrackit.curs17.homework.StringUtils.ensureNotEmpty;
import static ro.fasttrackit.curs17.homework.StringUtils.validAge;

public record Person(String firstName, String lastName, int age, String city) {
    public Person(String firstName, String lastName, int age, String city){
        this.firstName = ensureNotEmpty(firstName);
        this.lastName = ensureNotEmpty(lastName);
        this.age = validAge(age);
        this.city = ensureNotEmpty(city);
    }
}
