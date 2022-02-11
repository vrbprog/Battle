package vrb.battle.characters;

import vrb.battle.service.Randomiser;

public class Hero extends FantasyCharacter {
    private static final int HERO_STRENGTH_INIT = 2000;
    private static final int HERO_DEXTERITY_INIT = 3000;
    private static final int HERO_GOLD_INIT = 100;

    private int protection;

    public Hero(String name) {
        super(name,
                10000,
                Randomiser.getRandomOf(HERO_STRENGTH_INIT),
                Randomiser.getRandomOf(HERO_DEXTERITY_INIT),
                0,
                Randomiser.getRandomOf(HERO_GOLD_INIT)
        );
        protection = 0;
    }

    public Hero(String name, int healthPoints, int strength, int dexterity, int xp, int gold) {
        super(name, healthPoints, strength, dexterity, xp, gold);
        protection = 0;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    @Override
    public String toString() {
        return String.format("Наш герой %s: здоровье - %.2f%c, сила - %.2f%c, ловкость - %.2f%c, опыт - %.2f%c, золото - %d",
                getName(),
                getHealthPoints() / 100.0, '%',
                getStrength() / 100.0, '%',
                getDexterity() / 100.0, '%',
                getXp() / 100.0, '%',
                getGold()
        );
    }
}
