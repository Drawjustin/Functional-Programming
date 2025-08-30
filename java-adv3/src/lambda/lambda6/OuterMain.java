package lambda.lambda6;

public class OuterMain {
    private String message = "외부 클래스";

    public void execute(){
        // 1. 익명 클래스 예시
        Runnable annoymous = new Runnable(){
            private String message = "익명 클래스";
            @Override
            public void run() {
                // 익명 클래스에서의 this는 익명 클래스의 인스턴스를 가르킨다.
                System.out.println("this = " + this);
                System.out.println("this.getClass() = " + this.getClass());
                System.out.println("this.message = " + this.message);
            }
        };

        Runnable lambda = () -> {
            System.out.println("this = " + this);
            System.out.println("this.getClass() = " + this.getClass());
            System.out.println("this.message = " + this.message);
        };


        annoymous.run();
        System.out.println("----------------------");
        lambda.run();
    }

    public static void main(String[] args) {
        OuterMain outer = new OuterMain();
        System.out.println("[외부 클래스]:" + outer);
        outer.execute();
    }
}
