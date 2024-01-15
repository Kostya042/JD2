package Task2;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static Task2.Utils.*;


public class task1 {

    public static void main(String[] args) throws InterruptedException {


        BlockingQueue<RobotPart> dump = new LinkedBlockingQueue<>();
        Dump mydump = new Dump(dump);


        Scientist sc1 = new Scientist(dump);
        Scientist sc2 = new Scientist(dump);


        Thread sc1Thread = new Thread(sc1);
        Thread sc2Thread = new Thread(sc2);
        Thread dumpThread = new Thread(mydump);



        dumpThread.start();
        sc1Thread.start();
        sc2Thread.start();


        getResults(sc1,sc2);

    }


    public static void getResults(Scientist sc1, Scientist sc2) throws InterruptedException {
        while(!FLAG){
            Thread.sleep(DELAY_FOR_FINISH);
        }
        if (sc1.getCountOfRobots()<sc2.getCountOfRobots()){
            System.out.println("Scientist 2 won with "+sc2.getCountOfRobots()+" robots");
        }else if (sc1.getCountOfRobots()>sc2.getCountOfRobots()){
            System.out.println("Scientist 1 won with "+sc1.getCountOfRobots()+" robots");

        } else{
            System.out.println("It's a tie! Nobody won.");
        }
    }

}
