package vrb.battle.service;

import java.util.Random;

public class Randomizer {
    private static final Random random = new Random();

    public static int getRandomOf(int limit){
        return random.nextInt(limit);
    }
}
