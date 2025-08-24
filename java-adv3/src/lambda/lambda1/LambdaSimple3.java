package lambda.lambda1;

import lambda.MyFunction;

public class LambdaSimple3 {
    public static void main(String[] args) {
        // 타입 생략 전
        MyFunction myFunction1 = (int a, int b) -> a+b;

        // 타입 생략 후
        MyFunction myFunction2 = (a,b) -> a+b;

        int result = myFunction1.apply(1, 2);
        System.out.println("result = " + result);
    }
}
