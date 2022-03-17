package vrb.battle.characters;

public class Monster extends FantasyCharacter{

    private final String nikName;

    public Monster(String name, int healthPoints, int strength, int dexterity, int xp, int gold, String nik) {
        super(name, healthPoints, strength, dexterity, xp, gold);
        this.nikName = nik;
    }

    public String getNikName() {
        return nikName;
    }
}
