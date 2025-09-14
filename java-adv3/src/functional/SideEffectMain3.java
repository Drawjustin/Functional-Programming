package functional;

import java.util.function.Function;

public class SideEffectMain3 {


    public static void main(String[] args) {
        Function<Integer, Integer> func = x -> x * 2;
        int x = 10;

        Integer result = func.apply(10);
        System.out.println("result = " + result);
    }
}
