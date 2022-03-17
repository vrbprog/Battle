package vrb.battle.characters;

import vrb.battle.service.Randomizer;

public class Goblin extends Monster {
    private static final int STRENGTH_INIT = 1300;
    private static final int DEXTERITY_INIT = 3000;
    private static final int GOLD_INIT = 150;
    private static final int DEXTERITY_RND = 5600;
    private static final int LOWER_INIT = 200;
    private static final int RND_MULT = 1000;
    private static final int RND_DIV = 500;

    public Goblin(){
        super("noName",
                10000,
                Randomizer.getRandomOf(STRENGTH_INIT)  + LOWER_INIT,
                Randomizer.getRandomOf(DEXTERITY_INIT) + LOWER_INIT,
                0,
                Randomizer.getRandomOf(GOLD_INIT),
                "Goblin"
        );
    }

    public Goblin(String name) {
        super(name,
                10000,
                Randomizer.getRandomOf(STRENGTH_INIT)  + LOWER_INIT,
                Randomizer.getRandomOf(DEXTERITY_INIT) + LOWER_INIT,
                0,
                Randomizer.getRandomOf(GOLD_INIT),
                "Goblin"
                );
    }

    public Goblin(String name, int healthPoints, int strength, int dexterity, int xp, int gold) {
        super(name, healthPoints, strength, dexterity, xp, gold, "Goblin");
    }

    @Override
    public int attack() {
        if(getDexterity() * 3 > Randomizer.getRandomOf(DEXTERITY_RND))
            return (getStrength() * (Randomizer.getRandomOf(RND_MULT + getXp()/10) + 1)) / RND_DIV;
        else return 0;
    }

    @Override
    public String toString() {
        return String.format("Goblin %9s: " +
                        "\u2764 - %5.2f%c, " +
                        "\uD83D\uDCAA - %5.2f%c, " +
                        "\uD83E\uDD3A - %5.2f%c, " +
                        "\uD83E\uDDD4 - %4d, " +
                        "\uD83D\uDCB0 - %3d ",
                getName(),
                getHealthPoints() / 100.0, '%',
                getStrength() / 100.0, '%',
                getDexterity() / 100.0, '%',
                getXp(),
                getGold()
        );
    }
}
