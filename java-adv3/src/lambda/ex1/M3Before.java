package lambda.ex1;

import lambda.Procedure;

import java.util.Arrays;

public class M3Before {
    public static void measure(Procedure p){
        long start = System.nanoTime();
        p.run();
        long end = System.nanoTime();
        System.out.println("걸린시간 = " +  (end - start));
    }


    public static void cal(int N){
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += i;
        }
    }


    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7,8,9,10};

        measure(new Procedure() {
            @Override
            public void run() {
                cal(10);
            }
        });

        measure(() -> Arrays.sort(array));

    }
}
