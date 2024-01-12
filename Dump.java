import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class Dump implements Runnable {
    public static int TIME = 100;
    private ArrayList<String> dump;

    public Dump(ArrayList<String> dump) {
        this.dump = dump;
    }

    @Override
    public synchronized void run() {
        int start = 0;
        while (start != TIME) {
            start++;
            System.out.println("----------------------------");
            System.out.println("Night " + start + " started");
            for (int l = 0; l < (int) (Math.random() * 10); l++) {
                dumps();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void dumps() {
        int random = (int) (Math.random() * 9);
        if (random == 0) {
            dump.add("Head");
        } else if (random == 1) {
            dump.add("Body");
        } else if (random == 2) {
            dump.add("Left Hand");
        } else if (random == 3) {
            dump.add("Right Hand");
        } else if (random == 4) {
            dump.add("Right Foot");
        } else if (random == 5) {
            dump.add("Left Foot");
        } else if (random == 6) {
            dump.add("CPU");
        } else if (random == 7) {
            dump.add("RAM");
        } else {
            dump.add("HDD");
        }
    }
}
