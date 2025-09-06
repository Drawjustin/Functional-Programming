package stream.collectors;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors2Map {
    public static void main(String[] args) {
        Map<String, Integer> map1 = Stream.of("Apple", "Banana", "Tomato")
                .collect(Collectors.toMap(
                        name -> name, // key
                        name -> name.length() // value
                ));
        System.out.println("map1 = " + map1);


        // 키 중복 예외: IllegalStateException: Duplicate key Apple
/*
        Map<String, Integer> map2 = Stream.of("Apple", "Apple", "Tomato")
                .collect(Collectors.toMap(
                        name -> name, // key
                        name -> name.length() // value
                ));
        System.out.println("map2 = " + map2);
*/

        // 키 중복 대안 (병합)
        Map<String, Integer> map3 = Stream.of("Apple", "Apple", "Tomato")
                .collect(Collectors.toMap(
                        name -> name, // key
                        name -> name.length(), // value
                        (oldVal, newVal) -> newVal + oldVal
                ));
        System.out.println("map3 = " + map3);

        // Map의 타입 지정

        Map<String, Integer> map4 = Stream.of("Apple", "Apple", "Tomato")
                .collect(Collectors.toMap(
                        name -> name, // key
                        name -> name.length(), // value
                        (oldVal, newVal) -> newVal + oldVal,
                        LinkedHashMap::new
                ));
        System.out.println("map4 = " + map4.getClass());
    }
}
