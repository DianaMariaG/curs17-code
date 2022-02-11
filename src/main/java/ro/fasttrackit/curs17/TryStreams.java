package ro.fasttrackit.curs17;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class TryStreams {
    public static void main(String[] args) {
        List<String> names = List.of("Ana", "Bogdan", "Raul", "Raluca", "Mircea", "Dragos", "Madalina");

        List<String> result = names.stream()
                .filter(name -> name.length() > 4)
                .map(String::toUpperCase)
                .filter(item -> item.startsWith("M"))
                .collect(toList());
        System.out.println(result);

        List<Citizen> citizens = List.of(
                new Citizen("Ana", 33, "programator", true),
                new Citizen("Raul", 34, "contabil", false),
                new Citizen("Dorina", 53, "programator", true),
                new Citizen("Maria", 13, "fermier", false),
                new Citizen("Bogdan", 23, "fermier", true),
                new Citizen("Marius", 63, "fermier", false)
        );
        processCollection(citizens);
        processCollection(List.of());

        List<String> persons = citizens.stream()
                .filter(citizen -> citizen.age() > 20)
                .map(Citizen::name)
                .sorted()
                .collect(toList());
        System.out.println(persons);

        citizens.stream()
                .filter(TryStreams::isOldEnough)
                .map(Citizen::name)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        System.out.println("----");

        citizens.stream()
                .sorted(Comparator.comparingInt(Citizen::age))
                .forEach(System.out::println);
        System.out.println("---");

        citizens.stream()
                .sorted(Comparator.comparingInt(Citizen::age).reversed())
                .forEach(System.out::println);
        System.out.println("---");

        citizens.stream()
                .sorted(Comparator.comparing(Citizen::profession))
                .forEach(System.out::println);
        System.out.println("---");

        List<Citizen> toSort = new ArrayList<>();
        for (Citizen citizen : citizens) {
            toSort.add(citizen);
        }
        toSort.sort(Comparator.comparing((Citizen citizen) -> citizen.profession())
                .thenComparing(citizen1 -> citizen1.name()));
        for (Citizen citizen : toSort) {
            System.out.println(citizen);
        }
        System.out.println("---");

        citizens.stream()
                .sorted((elem1, elem2) -> elem1.name().length() - elem2.name().length())
                .forEach(System.out::println);
    }

    private static void processCollection(Collection<Citizen> citizens) {
        citizens.stream()
                .filter(TryStreams::isAnExperiencedFarmer)
                .filter(Citizen::married)
                .filter(citizen -> citizen.age() > 20)
                .map(citizen -> "fermier: " + citizen.name())
                .findFirst()
                .ifPresent(name -> System.out.println(name));
    }

    private static boolean isAnExperiencedFarmer(Citizen citizen) {
        return "fermier".equals(citizen.profession())
                && citizen.married()
                && citizen.age() > 30;
    }

    private static boolean isOldEnough(Citizen citizen) {
        return citizen.age() > 20;
    }
}

record Citizen(String name, int age, String profession, boolean married) {
}