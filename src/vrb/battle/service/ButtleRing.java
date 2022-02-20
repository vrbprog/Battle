package vrb.battle.service;

import vrb.battle.characters.Goblin;
import vrb.battle.characters.Hero;
import vrb.battle.characters.Monster;

public class ButtleRing implements Runnable{
    Hero hero;
    Monster monster;

    public ButtleRing(Hero hero, Monster monster) {
        this.hero = hero;
        this.monster = monster;
    }

    @Override
    public void run() {
        System.out.println("Battle is starting...");
        try {
            printBattle(hero, monster);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printBattle(Hero hero, Monster monster) throws InterruptedException {
        final String butStart = "            ꧁༺ \u2694 Start of Battle \u2694 ༻꧂        ";
        final String butEnd = "           ▀▄▀▄▀▄ \uD83D\uDC98 End of Buttle \uD83D\uDC98 ▄▀▄▀▄▀        ";
        final String heroBegin = "\uD83D\uDEE1️Hero:";
        final String heroBegin2 = "\uD83D\uDC51️Hero:";
        final String heroEnd = "\uD83D\uDEE1️";
        final String heroEnd2 = "\uD83D\uDC51️";
        final String monstBegin = "\uD83D\uDC79Monster:";
        final String monstEnd = "\uD83D\uDC79";
        final String KNIFE = "\ud83d\udde1";
        final String charEnd = "\u2694"; //🎁
        String knifeHero = " ";
        String knifeMonster = " ";

        int lifeHero = hero.getHealthPoints();
        int lifeGoblin = monster.getHealthPoints();
        int deltaHeroAttack = 0;
        int deltaMonstrAttack = 0;
        int time = 0;
        int numDelay = 0;
        char c;
        boolean heroAttemp = false;

        //System.out.println(hero);
        System.out.printf("Тебя вызыает на бой %s\n",monster.getNikName());
        System.out.println(monster);
        System.out.println("\n" + butStart + "\n");

        while (lifeHero > 0 && lifeGoblin > 0) {

            Thread.sleep(300);

            if(numDelay == 0) {
                if (heroAttemp) {
                    deltaHeroAttack = hero.attack()/4;
                    knifeHero = KNIFE;
                    knifeMonster = " ";
                } else {
                    deltaMonstrAttack = monster.attack()/4;
                    knifeHero = " ";
                    knifeMonster = KNIFE;
                }
            }

            if(heroAttemp) {
                c = getSymHeroAtt(time++);
                lifeGoblin -= deltaHeroAttack;
                if (lifeGoblin < 0) lifeGoblin = 0;
            }
            else{
                c = getSymMonstAtt(time++);
                if(hero.getProtection() > 0){
                    hero.useProtection();
                }
                else{
                    lifeHero -= deltaMonstrAttack;
                }
                if (lifeHero < 0) lifeHero = 0;
            }

            System.out.printf("%s%s%s %5.2f%c %s  %c  %s %5.2f%c %s%s%s\r",
                    heroBegin2, hero.getName(), heroEnd2, lifeHero / 100.0,'%', knifeHero,  c,
                    knifeMonster, lifeGoblin / 100.0,'%', monstBegin, monster.getName(), monstEnd);

            numDelay++; numDelay &= 3;
            if(numDelay == 0) {
                heroAttemp = !heroAttemp;
            }
        }

        if(lifeHero > 0) {
            knifeHero = "\u2764";
            knifeMonster = "☠";
            hero.setHealthPoints(lifeHero);
            hero.addGold(monster.getGold());
            hero.addXp(time);
            hero.improveStrength(monster.getStrength()/100);
            hero.improveDexterity(monster.getDexterity()/100);
        }
        else{
            knifeHero = "☠";
            knifeMonster = "\u2764";
            hero.setHealthPoints(0);
            hero.setGold(0);
        }

        System.out.printf("%s%s%s %5.2f%c %s  %s  %s %5.2f%c %s%s%s\n",
                heroBegin2, hero.getName(), heroEnd2, lifeHero / 100.0,'%', knifeHero,  charEnd,
                knifeMonster, lifeGoblin / 100.0,'%', monstBegin, monster.getName(), monstEnd);
        System.out.println("\n" + butEnd + "\n");

        if(lifeHero > 0){
            System.out.println(" ✌✌✌ Да здраствует великий победитель монстров, герой " + hero.getName() + " ✌✌✌");
            System.out.println(hero);
        }
        else{
            System.out.println("         \uD83C\uDF3A\uD83C\uDF3A\uD83C\uDF3A Вечняя память герою " + hero.getName()
                    + " \uD83C\uDF3A\uD83C\uDF3A\uD83C\uDF3A");
            System.out.println("   \uD83C\uDFC1 \uD83C\uDFC1 \uD83C\uDFC1" +
                    " Миссия не выполнена. Конец игры " +
                    "\uD83C\uDFC1 \uD83C\uDFC1 \uD83C\uDFC1");
        }
        System.out.println();
    }

    private char getSymMonstAtt(int time) {
        char out = ' ';
        switch (time % 4) {
            case 0:
                out = '\\';
                break;
            case 1:
                out = '-';
                break;
            case 2:
                return '/';
            case 3:
                return '|';
        }
        return out;
    }

    private char getSymHeroAtt(int time) {
        char out = ' ';
        switch (time % 4) {
            case 0:
                out = '/';
                break;
            case 1:
                out = '-';
                break;
            case 2:
                return '\\';
            case 3:
                return '|';
        }
        return out;
    }
}
