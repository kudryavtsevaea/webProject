import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Semaphore sem = new Semaphore(5);

        List<Thread> philosophers = new ArrayList<>();
        philosophers.add(new Thread(new Philosopher("Платон", 5, sem)));
        philosophers.add(new Thread(new Philosopher("Гераклит", 20, sem)));
        philosophers.add(new Thread(new Philosopher("Демокрит", 11, sem)));
        philosophers.add(new Thread(new Philosopher("Эмпедокл", 4, sem)));
        philosophers.add(new Thread(new Philosopher("Анаксимандр", 100, sem)));
        philosophers.add(new Thread(new Philosopher("Фалес", 9, sem)));
        philosophers.add(new Thread(new Philosopher("Сократ", 10, sem)));
        philosophers.add(new Thread(new Philosopher("Анаксагор", 15, sem)));
        philosophers.add(new Thread(new Philosopher("Парменид", 60, sem)));
        philosophers.add(new Thread(new Philosopher("Аристотель", 23, sem)));

        for (Thread p : philosophers) {
            p.start();
        }

    }
}