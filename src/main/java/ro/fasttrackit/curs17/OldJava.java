package ro.fasttrackit.curs17;

import java.util.Locale;

public class OldJava {
    public static void main(String[] args) {
        System.out.println(transformString("abc", new ToUpperCaseTransformer()));
        System.out.println(transformString("abc", new ToLowerCaseTransformer()));
        System.out.println(transformString("abc", new StringTransformer() { //clasa anonima, extinde StringTransformer si da implementarea de jos; nu are nume de asta e anonima
            @Override
            public String transform(String word) {
                return "*".repeat(word.length());
            }
        }));
    }

    private static String transformString(String word, StringTransformer transformer) {
        return transformer.transform(word);
    }
}
interface StringTransformer {
    String transform (String word);
}

class ToUpperCaseTransformer implements StringTransformer {

    @Override
    public String transform(String word) {
        return word.toUpperCase();
    }
}
class ToLowerCaseTransformer implements StringTransformer {

    @Override
    public String transform(String word) {
        return word.toLowerCase();
    }
}
