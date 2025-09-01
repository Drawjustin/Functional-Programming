package methodref;

import java.util.function.BiFunction;

// 매개변수 추가
public class MethodRefEx6 {
    public static void main(String[] args) {
        // 4. 임의 객체의 인스턴스 메서드 참조(특정 타입의)
        Person person = new Person("Kim");


        // 람다
        BiFunction<Person,Integer,String> function1 = (Person p, Integer number) -> p.introduceWithNumber(number);
        System.out.println("function1.apply(person,1) = " + function1.apply(person,1));
        // 메서드 참조
        BiFunction<Person,Integer,String> function2 =  Person::introduceWithNumber;
        System.out.println("function2.apply(person,2) = " + function2.apply(person,2));
    }
}
