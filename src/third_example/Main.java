package third_example;

import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args){

        final Predicate<Integer> isEven = x -> x % 2 == 0;
        final Predicate<Integer> isPositive = x -> x > 0;
        final Predicate<Integer> isZero = x -> x == 0;
        final Predicate<Integer> isNull= Objects::isNull;

        System.out.println(isEven.test(5));
        System.out.println(isEven.test(2));
        System.out.println(isPositive.test(5));
        System.out.println(isPositive.test(-22));
        System.out.println(isZero.test(-22));
        System.out.println(isZero.test(0));
        System.out.println(isNull.test(null));
        System.out.println(isNull.test(-389));

        final Predicate<String> isShortWord = x -> x.length() < 4;

        System.out.println(isShortWord.test("hey"));
        System.out.println(isShortWord.test("wassup"));
        System.out.println(isShortWord.test("nice"));
        System.out.println(isShortWord.test("bye"));

        System.out.println(isPositive.and(isEven).test(16));
        System.out.println(isPositive.and(isEven).negate().test(-9));
    }

}
