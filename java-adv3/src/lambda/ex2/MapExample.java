package lambda.ex2;
import java.util.ArrayList;
import java.util.List;
public class MapExample {
    // 고차 함수, 함수를 인자로 받아, 리스트의 각 요소를 변환
    public static List<String> map(List<String> list, StringFunction func) {
        // 코드 작성
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            newList.add(func.apply(s));
        }
        return newList;
    }
    public static void main(String[] args) {
        List<String> words = List.of("hello", "java", "lambda");
        System.out.println("원본 리스트: " + words);
        // 1. 대문자 변환
        // 코드 작성
        List<String> list1 = map(words, (string) -> string.toUpperCase());
        System.out.println("list1 = " + list1);

        // 2. 앞뒤에 *** 붙이기 (람다로 작성)
        // 코드 작성
        List<String> list2 = map(words, (string) -> "***"+string+"***");
        System.out.println("list2 = " + list2);


    }
}
