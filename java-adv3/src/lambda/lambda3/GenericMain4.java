package lambda.lambda3;

public class GenericMain4 {
    public static void main(String[] args) {
        GenericFunction<String,String> upperCase = s -> ((String)s).toUpperCase();
        String result1 = (String) upperCase.apply("hello");
        System.out.println("result1 = " + result1);

        GenericFunction<Integer,Integer> square = n -> (Integer)n * (Integer)n;
        Integer result2 = (Integer) square.apply(3);
        System.out.println("result2 = " + result2);

    }
    @FunctionalInterface
    interface GenericFunction<T,R>{
        R apply(T s);
    }
}
