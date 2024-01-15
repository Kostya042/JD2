package Task2;

import java.util.Random;

public class Utils {
    public static final int COUNT_OF_ROBOT_PART = RobotPart.values().length;
    public static final int MAX_NUMBER_OF_THROWS_ROBOT_PART = 4;
    public static final int COUNT_OF_NIGHT = 100;
    public static final int DELAY_FOR_THROW_DETAILS = 100;
    public static final int DELAY_FOR_FINISH = 400;
    public static final Random RANDOM = new Random();
    public static volatile boolean FLAG = false;
}
