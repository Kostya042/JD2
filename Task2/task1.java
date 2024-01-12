import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class task1 {
    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) {


        int countOfNights = 0;
        ArrayList<String> dump = new ArrayList<>();
        Dump mydump = new Dump(dump);

        for (int i = 0; i < 20; i++) {
            mydump.dumps();
        }

        ArrayList<String> store1 = new ArrayList<>();
        ArrayList<String> store2 = new ArrayList<>();


        Scientist sc1 = new Scientist(store1, dump, lock, countOfNights);
        Scientist sc2 = new Scientist(store2, dump, lock, countOfNights);


        Thread sc1Thread = new Thread(sc1);
        Thread sc2Thread = new Thread(sc2);
        Thread dumpThread = new Thread(mydump);
        dumpThread.start();
        sc1Thread.start();
        sc2Thread.start();



    }
}
