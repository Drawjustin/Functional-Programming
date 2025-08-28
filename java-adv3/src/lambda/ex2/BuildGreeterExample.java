package lambda.ex2;

public class BuildGreeterExample {
    // 고차 함수, greeting 문자열을 받아, "새로운 함수를" 반환
    public static StringFunction buildGreeter(String greeting) {

        return (string) -> greeting + " " + string; // 적절한 람다 반환
    }
    public static void main(String[] args) {
        // 코드 작성
        StringFunction sf = buildGreeter("Hello");
        System.out.println("sf.apply(\"java\") = " + sf.apply("java"));
    }
}
