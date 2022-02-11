package ro.fasttrackit.curs17;

import java.util.function.Function;

import static ro.fasttrackit.curs17.TryFunctionalInterfaces.tryFunction;

public class MethodReferences {
    public static void main(String[] args) {
        methodCallRef(String :: length); //orice input ai primi apeleaza-i metoda lenght pe el
        methodCallRef(Integer :: parseInt);
        methodCallRef(MethodReferences :: len);
    }

    private static int len(String str){
        return 1;
    }

    private static void methodCallRef(Function<String,Integer> str) {
        str.apply("abc");
    }
}
