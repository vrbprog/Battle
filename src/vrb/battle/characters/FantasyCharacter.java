package vrb.battle.characters;

public abstract class FantasyCharacter implements Fighter{
    private String name;
    private int healthPoints;
    private int strength;
    private int dexterity;
    private int xp;
    private int gold;

    public FantasyCharacter(String name, int healthPoints, int strength, int dexterity, int xp, int gold) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.strength = strength;
        this.dexterity = dexterity;
        this.xp = xp;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        if(healthPoints >= 0 && healthPoints <= 10000)
            this.healthPoints = healthPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        if(strength >= 0 && strength <= 10000)
            this.strength = strength;
    }

    public void improveStrength(int strength) {
        this.strength += strength;
        if(this.strength > 10000) this.strength = 10000;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        if(dexterity >= 0 && dexterity <= 10000)
            this.dexterity = dexterity;
    }

    public void improveDexterity(int dexterity) {
        this.dexterity += dexterity;
        if(this.dexterity > 10000) this.dexterity = 10000;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        if(xp >= 0)
        this.xp = xp;
    }

    public void addXp(int xp) {
        this.xp += xp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        if(gold >= 0)
        this.gold = gold;
    }

    public void addGold(int gold) {
        this.gold += gold;
    }

    public boolean spendGold(int spend) {
        if(spend <= gold) {
            gold -= spend;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int attack() {
        return 0;
    }
}
