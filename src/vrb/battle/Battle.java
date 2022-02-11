package vrb.battle;

import vrb.battle.characters.Goblin;
import vrb.battle.characters.Hero;

public class Battle {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Battle is starting...");
        Hero myHero = new Hero("Iliya");
        Goblin goblin = new Goblin("Gob");
        System.out.println(myHero);
        printBattle(myHero, goblin);
    }

    public static void printBattle(Hero hero, Goblin goblin) throws InterruptedException {
//         String xxe = "\u2694";
//         String xxc = "\ud83d\udde1";
//         String xxf = "\uD83D\uDEE1️ Hero \uD83D\uDEE1️";
//         String xxg = "☠ Goblin☠ ";
//         String xxh = "\uD83D\uDC79Monster\uD83D\uDC79";

        final String butStart = "            ꧁༺ \u2694 Start of Battle \u2694 ༻꧂        ";
        final String butEnd = "           ▀▄▀▄▀▄ \uD83D\uDC98 End of Buttle \uD83D\uDC98 ▄▀▄▀▄▀        ";
        final String heroBegin = "\uD83D\uDEE1️Hero:";
        final String heroEnd = "\uD83D\uDEE1️";
        final String monstBegin = "\uD83D\uDC79Monster:";
        final String monstEnd = "\uD83D\uDC79";
        String knifeHero = "\ud83d\udde1";
        String knifeMonster = "\ud83d\udde1";

        int n = 10000;
        int time = 0;
        char c;
        String charEnd = "\u2694";;

        System.out.println("\n" + butStart + "\n");
        while (n > 0) {
            Thread.sleep(300);
            c = getSymHeroAtt(time++);
            System.out.printf("%s%s%s %5.2f%c %s  %c  %s %5.2f%c %s%s%s\r",
                    heroBegin, hero.getName(), heroEnd, n / 100.0,'%', knifeHero,  c,
                    knifeMonster, n / 100.0,'%', monstBegin, goblin.getName(), monstEnd);
            n-= 200;
        }
        knifeHero = "\u2764";
        knifeMonster = "☠";
        System.out.printf("%s%s%s %5.2f%c %s  %s  %s %5.2f%c %s%s%s\n",
                heroBegin, hero.getName(), heroEnd, n / 100.0,'%', knifeHero,  charEnd,
                knifeMonster, n / 100.0,'%', monstBegin, goblin.getName(), monstEnd);
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
