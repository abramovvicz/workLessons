package singleton;

public class Singleton {

    private static volatile Singleton instance;
    //zmienna volatile to taka zmienna, która zapewni nam spójną wartość tej zmiennej
    //niezależnie od tego, który wątek sróbuje ja odczytać
    //taka ciekawostka

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
