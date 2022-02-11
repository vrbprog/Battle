package vrb.battle.characters;

import vrb.battle.service.Randomiser;

public class Goblin extends FantasyCharacter{
    private static final int GOBLIN_STRENGTH_INIT = 1000;
    private static final int GOBLIN_DEXTERITY_INIT = 1000;
    private static final int GOBLIN_GOLD_INIT = 40;

    public Goblin(String name) {
        super(name,
                10000,
                Randomiser.getRandomOf(GOBLIN_STRENGTH_INIT),
                Randomiser.getRandomOf(GOBLIN_DEXTERITY_INIT),
                0,
                Randomiser.getRandomOf(GOBLIN_GOLD_INIT)
                );
    }

    public Goblin(String name, int healthPoints, int strength, int dexterity, int xp, int gold) {
        super(name, healthPoints, strength, dexterity, xp, gold);
    }
}
