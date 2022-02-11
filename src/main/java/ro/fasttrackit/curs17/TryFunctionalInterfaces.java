package ro.fasttrackit.curs17;

import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TryFunctionalInterfaces {
    public static void main(String[] args) {
        tryFunction(a -> a+1); //a = 3
        tryFunction(b -> b*10); // b =3

        trySupplier(() -> "Hello");
        trySupplier(() -> "World");

        tryPredicate(input -> input.length() > 2);
        tryPredicate(input -> input.length() > 20);

        tryConsumer(input -> System.out.println(input + "consumed"));
        tryConsumer(input -> System.out.println(input + "consumed again"));

        tryRunnable(() -> {
                    System.out.println("Fac ce vreau");
                });
        tryRunnable(()-> {
        });


//        tryMultiple();
    }

    private static void tryMultiple(Supplier<String> supplier, Function<String, Integer> transformer, Predicate<Integer> tester, Consumer<Integer> consumer){
        Integer value = transformer.apply(supplier.get());
    }

    private static void tryRunnable(Runnable runnable) {
        try{

        }catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("A fost o eroare");
        }
    }

    private static void tryConsumer(Consumer<String> stringConsumer) {
        stringConsumer.accept("ceva");
        stringConsumer.accept("food");
        stringConsumer.accept("candy");
    }

    public static void tryPredicate(Predicate<String> stringTester) {
        if(stringTester.test("Hello world")) {
            System.out.println("A trecut testul");
        } else {
            System.out.println("Nu a trecut testul");
        }
    }

    public static void trySupplier(Supplier<String> stringSupplier) {
        String value = stringSupplier.get();
        if(value.startsWith("H")) {
            System.out.println(value.toUpperCase());
        } else {
            System.out.println("Not H");
        }
    }
    //trimitem functiile la date, e pe dos
    public static void tryFunction(Function<Integer,Integer> incrementor){
        System.out.println(incrementor.apply(3));
        System.out.println(incrementor.apply(13));
    }
}
