package ro.fasttrackit.curs17.homework;

public class StringUtils {
    public static String ensureNotEmpty(String word) throws IllegalArgumentException {
        if (word == null || "".equals(word.trim())) {
            throw new IllegalArgumentException("Null or empty word is not accepted!");
        } else {
            return word;
        }
    }

    public static int validAge(int age) {
        if (age >= 0 && age < 150) {
            return age;
        } else {
            throw new IllegalArgumentException("Age is not valid!");
        }
    }
}
