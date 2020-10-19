package threads;

public class TestThreads {

    public static void main(String[] args) {
        someMethod();
        someMethodSecond();
    }

    public static void someMethod() {
        Runnable r = () -> {
            try {

                Thread.sleep(100);
                System.out.println("asdasd");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t = new Thread(r);
        t.start();
    }

    public static void someMethodSecond() {

    }
}
