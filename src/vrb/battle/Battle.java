package vrb.battle;

import vrb.battle.characters.Goblin;
import vrb.battle.characters.Hero;

public class Battle {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Battle is starting...");
        Hero myHero = new Hero("Iliya");
        Goblin goblin = new Goblin("Gob");
        System.out.println(myHero);
        System.out.println(goblin);
        printBattle(myHero, goblin);
    }

    public static void printBattle(Hero hero, Goblin goblin) throws InterruptedException {
        final String butStart = "            ꧁༺ \u2694 Start of Battle \u2694 ༻꧂        ";
        final String butEnd = "           ▀▄▀▄▀▄ \uD83D\uDC98 End of Buttle \uD83D\uDC98 ▄▀▄▀▄▀        ";
        final String heroBegin = "\uD83D\uDEE1️Hero:";
        final String heroEnd = "\uD83D\uDEE1️";
        final String monstBegin = "\uD83D\uDC79Monster:";
        final String monstEnd = "\uD83D\uDC79";
        String knifeHero = "\ud83d\udde1";
        String knifeMonster = "\ud83d\udde1";

        int lifeHero = hero.getHealthPoints();
        int lifeGoblin = goblin.getHealthPoints();
        int time = 0;
        char c;
        boolean heroAttemp = false;
        String charEnd = "\u2694";;

        System.out.println(hero.attack());
        System.out.println(goblin.attack());
        System.out.println("\n" + butStart + "\n");
        while (lifeHero > 0 && lifeGoblin > 0) {

            Thread.sleep(300);
            c = getSymHeroAtt(time++);

            if(heroAttemp){
                lifeGoblin -= hero.attack();
                if(lifeGoblin < 0) lifeGoblin = 0;
            }
            else{
                lifeHero -= goblin.attack();
                if(lifeHero < 0) lifeHero = 0;
            }

            System.out.printf("%s%s%s %5.2f%c %s  %c  %s %5.2f%c %s%s%s\r",
                    heroBegin, hero.getName(), heroEnd, lifeHero / 100.0,'%', knifeHero,  c,
                    knifeMonster, lifeGoblin / 100.0,'%', monstBegin, goblin.getName(), monstEnd);
            heroAttemp = !heroAttemp;
        }
        knifeHero = "\u2764";
        knifeMonster = "☠";
        System.out.printf("%s%s%s %5.2f%c %s  %s  %s %5.2f%c %s%s%s\n",
                heroBegin, hero.getName(), heroEnd, lifeHero / 100.0,'%', knifeHero,  charEnd,
                knifeMonster, lifeGoblin / 100.0,'%', monstBegin, goblin.getName(), monstEnd);
        System.out.println("\n" + butEnd);
    }

    public static char getSymMonstAtt(int time) {
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

    public static char getSymHeroAtt(int time) {
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
