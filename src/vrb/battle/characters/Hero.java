package vrb.battle.characters;

import vrb.battle.service.Randomizer;

public class Hero extends FantasyCharacter {
    private static final int STRENGTH_INIT = 2000;
    private static final int DEXTERITY_INIT = 4000;
    private static final int GOLD_INIT = 300;
    private static final int DEXTERITY_RND = 5200;
    private static final int LOWER_INIT = 500;
    private static final int RND_MULT = 800;
    private static final int RND_DIV = 400;

    private int protection;
    private int extraPower;
    private int potion;

    public Hero(String name) {
        super(name,
                10000,
                Randomizer.getRandomOf(STRENGTH_INIT) + LOWER_INIT,
                Randomizer.getRandomOf(DEXTERITY_INIT) + LOWER_INIT,
                0,
                Randomizer.getRandomOf(GOLD_INIT)
        );
        protection = 10;
        extraPower = 0;
        potion = 0;
    }

    public Hero(String name, int healthPoints, int strength, int dexterity, int xp, int gold) {
        super(name, healthPoints, strength, dexterity, xp, gold);
        protection = 0;
        extraPower = 0;
        potion = 0;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public void addProtection(int protection) {
        this.protection += protection;
    }

    public void useProtection(){
        if(protection > 0){
            protection--;
        }
    }

    public int getExtraPower() {
        return extraPower;
    }

    public void setExtraPower(int extraPower) {
        this.extraPower = extraPower;
    }

    public void addExtraPower(int extraPower) {
        this.extraPower += extraPower;
    }

    public int getPotion() {
        return potion;
    }

    public void setPotion(int potion) {
        this.potion = potion;
    }

    public void addPotion(int potion) {
        this.potion += potion;
    }

    @Override
    public int attack() {
        if((getDexterity() + getXp()/10) * 3 > Randomizer.getRandomOf(DEXTERITY_RND))
            return (getStrength() * (Randomizer.getRandomOf(
                    RND_MULT + extraPower) + 1)) / RND_DIV;
        else return 0;
    }

    @Override
    public String toString() {
        return String.format("Наш герой %10s: " +
                        "\u2764 - %5.2f%c, " +
                        "\uD83D\uDCAA - %5.2f%c, " +
                        "\uD83E\uDD3A - %5.2f%c, " +
                        "\uD83E\uDDD4 - %4d, " +
                        "\uD83D\uDCB0 - %3d, " +
                        "\uD83E\uDD4A - %3d, " +
                        "\uD83D\uDEE1️ - %3d, " +
                        "\uD83E\uDDEA️ - %3d, ",
                getName(),
                getHealthPoints() / 100.0, '%',
                getStrength() / 100.0, '%',
                getDexterity() / 100.0, '%',
                getXp(),
                getGold(),
                extraPower,
                protection,
                potion
        );
    }
}
