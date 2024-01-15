package Task2;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

import static Task2.Utils.*;

public class Dump implements Runnable {
    private BlockingQueue<RobotPart> dump;

    public Dump(BlockingQueue<RobotPart> dump) {
        this.dump = dump;
        for (int i = 0; i < 20; i++) {
            dumps();
        }
    }

    @Override
    public void run() {
        int start = 0;
        while (start != COUNT_OF_NIGHT) {
            start++;
            System.out.println("----------------------------");
            System.out.println("Night " + start + " started");
            for (int l = 0; l < RANDOM.nextInt(MAX_NUMBER_OF_THROWS_ROBOT_PART)+1; l++) {
                dumps();
            }
            try {
                System.out.println("---------------------------");
                Thread.sleep(DELAY_FOR_THROW_DETAILS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        finishing();
    }

    private void finishing() {
        System.out.println("Program finished");
        FLAG = true;
    }

    public void dumps() {
            dump.add(RobotPart.values()
                    [RANDOM.nextInt((RobotPart.values().length))]);
    }
}

