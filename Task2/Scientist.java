package Task2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;

import static Task2.Utils.*;

public class Scientist implements Runnable {
    private List<RobotPart> storage = new ArrayList<>();
    private BlockingQueue<RobotPart> dump;

    public int getCountOfRobots() {
        return countOfRobots;
    }

    private int countOfRobots = 0;
    private Set<RobotPart> TEMPROBOT = new HashSet();


    public Scientist(BlockingQueue<RobotPart> dump) {
        this.dump = dump;
    }

    @Override
    public void run() {
        while (!FLAG) {
            for (int l = 0; l < RANDOM.nextInt(MAX_NUMBER_OF_THROWS_ROBOT_PART)+1; l++) {
                try {
                    removing();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                checking();
            }
            try {
                Thread.sleep(DELAY_FOR_THROW_DETAILS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread() + " " + countOfRobots);


    }

    public void removing() throws InterruptedException {
            if (dump.size() == 0) {
                System.out.println(Thread.currentThread() + " left with nothing");
                return;
            }
            System.out.println(Thread.currentThread() + " found something");
            System.out.println(this.storage);

            RobotPart temp = dump.take();
            storage.add(temp);
            dump.remove(temp);

    }

    public void checking() {
        for(int i = 0; i<storage.size()-1;i++){
            if (!TEMPROBOT.contains(storage.get(i))){
                TEMPROBOT.add(storage.get(i));
                storage.remove(i);
            }

            if (TEMPROBOT.size()==COUNT_OF_ROBOT_PART){
                countOfRobots++;
                System.out.println(Thread.currentThread().getName()+" created a Robot");
                System.out.println(Thread.currentThread().getName()+" created "+countOfRobots+ " robots");
                TEMPROBOT.clear();
            }
        }

    }
}

