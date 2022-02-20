package vrb.battle.characters;

import vrb.battle.service.Randomiser;

public class Skeleton extends Monster {
    private static final int STRENGTH_INIT = 1500;
    private static final int DEXTERITY_INIT = 2500;
    private static final int GOLD_INIT = 200;
    private static final int DEXTERITY_RND = 5700;
    private static final int LOWER_INIT = 300;
    private static final int RND_MULT = 1000;
    private static final int RND_DIV = 600;

    public Skeleton(){
        super("noName",
                10000,
                Randomiser.getRandomOf(STRENGTH_INIT)  + LOWER_INIT,
                Randomiser.getRandomOf(DEXTERITY_INIT) + LOWER_INIT,
                0,
                Randomiser.getRandomOf(GOLD_INIT),
                "Skeleton"
        );
    }

    public Skeleton(String name) {
        super(name,
                10000,
                Randomiser.getRandomOf(STRENGTH_INIT)  + LOWER_INIT,
                Randomiser.getRandomOf(DEXTERITY_INIT) + LOWER_INIT,
                0,
                Randomiser.getRandomOf(GOLD_INIT),
                "Skeleton"
        );
    }

    public Skeleton(String name, int healthPoints, int strength, int dexterity, int xp, int gold) {
        super(name, healthPoints, strength, dexterity, xp, gold,"Skeleton");
    }

    @Override
    public int attack() {
        if(getDexterity() * 3 > Randomiser.getRandomOf(DEXTERITY_RND))
            return (getStrength() * (Randomiser.getRandomOf(RND_MULT + getXp()/10) + 1)) / RND_DIV;
        else return 0;
    }

    @Override
    public String toString() {
        return String.format("Skeleton %9s: " +
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
