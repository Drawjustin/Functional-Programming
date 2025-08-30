package lambda.lambda5.mystream;

import java.util.List;

public class MyStreamLoopMain<T> {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Apple", 100),
                new Student("Banana", 100),
                new Student("Berry", 100),
                new Student("Tomato", 100)
        );
        List<String> result = MyStreamV3.of(students)
                .filter(s -> s.getScore() >= 80)
                .map(s -> s.getName())
                .toList();


        // 외부 반복
        for (String s : result) {
            System.out.println("name = " + s);
        }


        // 내부 반복
        MyStreamV3.of(students)
                .filter(s -> s.getScore() >= 80)
                .map(s -> s.getName())
                .forEach((name) -> System.out.println("name : " + name));


    }
}
