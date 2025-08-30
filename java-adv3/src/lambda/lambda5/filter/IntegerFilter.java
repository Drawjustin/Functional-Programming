package lambda.lambda5.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class IntegerFilter {
    public static List<Integer> filter(List<Integer> numbers, Predicate<Integer> predicate){
        List<Integer> list = new ArrayList<>();
        for (Integer number : numbers) {
            if(predicate.test(number)){
                list.add(number);
            }
        }
        return list;
    }
}
