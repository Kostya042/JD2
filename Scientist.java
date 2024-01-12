import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class Scientist implements Runnable {
    private ArrayList<String> storage;
    private ArrayList<String> dump;

    private Lock lock;

    private int countOfRobots = 0;

    public static final int TIME = 100;

    public Scientist(ArrayList<String> storage, ArrayList<String> dump, Lock lock, int countOfRobots) {
        this.storage = storage;
        this.dump = dump;
        this.lock = lock;
        this.countOfRobots = countOfRobots;
    }

    @Override
    public void run() {
        int start = 0;
        while (start != TIME) {
            start++;
            for (int l = 0; l < (int) (Math.random() * 3 + 1); l++) {
                removing();
                checking();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Program finished");
        System.out.println(Thread.currentThread() + " " + countOfRobots);


    }

    public void removing() {
        synchronized (lock) {
            if (dump.size() == 0) {
                System.out.println(Thread.currentThread() + " left with nothing");
                return;
            }
            System.out.println(Thread.currentThread() + " found something");
            System.out.println(this.storage);
            int temp = (int) (Math.random() * dump.size());
            String random = dump.get(temp);
            storage.add(random);
            dump.remove(random);
        }
    }

    public void checking() {
        if (storage.contains("Head") &&
                storage.contains("Body") &&
                storage.contains("Left Hand") &&
                storage.contains("Right Hand") &&
                storage.contains("Right Foot") &&
                storage.contains("Left Foot") &&
                storage.contains("CPU") &&
                storage.contains("RAM") &&
                storage.contains("HDD")) {
            countOfRobots++;
            System.out.println("\n" + Thread.currentThread() + " created a Robot");
            System.out.println(Thread.currentThread() + " created " + countOfRobots + " robots" + "\n");
            storage.remove("Head");
            storage.remove("Body");
            storage.remove("Left Hand");
            storage.remove("Right Hand");
            storage.remove("Right Foot");
            storage.remove("Left Foot");
            storage.remove("CPU");
            storage.remove("RAM");
            storage.remove("HDD");
        } else {
            System.out.println(Thread.currentThread() + " crafted no robots");
        }
    }
}
