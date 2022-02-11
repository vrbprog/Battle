package vrb.battle.service;

import java.util.Random;

public class Randomiser {
    private static Random random = new Random();

    public static int getRandomOf(int limit){
        return random.nextInt(limit);
    }
}
