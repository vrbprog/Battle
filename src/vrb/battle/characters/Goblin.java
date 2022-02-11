package vrb.battle.characters;

import vrb.battle.service.Randomiser;

public class Goblin extends FantasyCharacter{
    private static final int GOBLIN_STRENGTH_INIT = 1300;
    private static final int GOBLIN_DEXTERITY_INIT = 3200;
    private static final int GOBLIN_GOLD_INIT = 40;
    private static final int GOBLIN_DEXTERITY_RND = 5400;
    private static final int GOBLIN_LOWER_INIT = 200;
    private static final int GOBLIN_RND_MULT = 1200;
    private static final int GOBLIN_RND_DIV = 500;

    public Goblin(String name) {
        super(name,
                10000,
                Randomiser.getRandomOf(GOBLIN_STRENGTH_INIT)  + GOBLIN_LOWER_INIT,
                Randomiser.getRandomOf(GOBLIN_DEXTERITY_INIT) + GOBLIN_LOWER_INIT,
                0,
                Randomiser.getRandomOf(GOBLIN_GOLD_INIT)
                );
    }

    public Goblin(String name, int healthPoints, int strength, int dexterity, int xp, int gold) {
        super(name, healthPoints, strength, dexterity, xp, gold);
    }

    @Override
    public int attack() {
        if(getDexterity() * 3 > Randomiser.getRandomOf(GOBLIN_DEXTERITY_RND))
            return (getStrength() * (Randomiser.getRandomOf(GOBLIN_RND_MULT + getXp()/10) + 1)) / GOBLIN_RND_DIV;
        else return 0;
    }

    @Override
    public String toString() {
        return String.format("Наш гоблин %s: здоровье - %.2f%c, сила - %.2f%c, ловкость - %.2f%c, опыт - %.2f%c, золото - %d",
                getName(),
                getHealthPoints() / 100.0, '%',
                getStrength() / 100.0, '%',
                getDexterity() / 100.0, '%',
                getXp() / 100.0, '%',
                getGold()
        );
    }
}
