package vrb.battle.service;

import vrb.battle.characters.Goblin;
import vrb.battle.characters.Hero;
import vrb.battle.characters.Monster;
import vrb.battle.characters.Skeleton;

import java.util.Scanner;

public class Game {
    private static final int NUM_TYPE_OF_MONSTER = 2;
    Thread threadScene;
    Hero myHero = null;

    public void runGame() {
        String name = getNameHero();
        if (name == null) System.exit(1);
        else {
            myHero = new Hero(name);
        }

        System.out.printf("Да ты силен, %s\n", myHero.getName());
        System.out.println(myHero);
        while (myHero.getHealthPoints() > 0) {
            switch (getItemMenu()) {
                case '1':
                    Shopping();
                    break;
                case '2':
                    //Goblin goblin = new Goblin("Gob");
                    ButtleRing ring = new ButtleRing(myHero, getNextMonster());
                    threadScene = new Thread(ring);
                    threadScene.start();
                    try {
                        threadScene.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case '3':
                    System.out.println("Надеюсь увидить Вас вскоре. До встречи!!!");
                    System.exit(1);
            }
        }
    }

    private Monster getNextMonster() {
        Monster monster;
        int monsterType = Randomiser.getRandomOf(9999) % NUM_TYPE_OF_MONSTER;
        switch (monsterType) {
            case 0:
                monster = new Goblin();
                break;
            case 1:
                monster = new Skeleton();
                break;
            default: monster = null;
        }
        return monster;
    }

    private String getNameHero() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Наш мир в большой опасности. Монстры повсюду. Ты готов спасти его ???\n" +
                "1 - Да, я готов!!!\n" +
                "0 - Нет, я еще не готов...\n" +
                "Ваш ответ: ");

        while (true) {
            if (scanner.hasNextInt()) {
                if (scanner.nextInt() != 1) {
                    System.out.println("Очень жаль. Надеюсь увидить Вас вскоре. До встречи.");
                    return null;
                } else {
                    if (scanner.hasNextLine()) scanner.nextLine();
                    System.out.println("\nСкажи свое имя герой: ");
                    return scanner.nextLine();
                }
            } else {
                System.out.println("Неверный ввод. Повторите еще раз.");
                scanner.next();
            }
        }
    }

    private  char getItemMenu() {
        char choise;
        boolean faultOperation = true;
        Scanner s = new Scanner(System.in);
        do {
            System.out.printf("Куда вы хотите пойти %s?\n",myHero.getName());
            System.out.println("\u2630 Menu");
            System.out.println("1 - К торговцу.");
            System.out.println("2 - В темный лес.");
            System.out.println("3 - На выход.");
            choise = s.next().charAt(0);
            switch (choise) {
                case '1':
                case '2':
                case '3': {
                    faultOperation = false;
                    break;
                }
                default: {
                    System.out.println("Неверный путь!!! Повторите ввод.");
                }
            }
        } while (faultOperation);
        return choise;
    }

    private void Shopping() {
        System.out.println("К сожелению торговца нет в городе.");
    }
}
