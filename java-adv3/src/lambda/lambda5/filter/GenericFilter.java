package lambda.lambda5.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GenericFilter {
    public static <T> List<T> filter(List<T> numbers, Predicate<T> predicate){
        List<T> list = new ArrayList<>();
        for (T number : numbers) {
            if(predicate.test(number)){
                list.add(number);
            }
        }
        return list;
    }
}
