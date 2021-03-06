package vrb.battle.service;

import vrb.battle.characters.*;

import java.util.Scanner;

public class Game {
    private static final int NUM_TYPE_OF_MONSTER = 2;
    private Hero myHero;
    private boolean readyCurrentBattle = false;

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
                    Tradesman.Shopping(myHero);
                    break;
                case '2':
                    BattleRing ring = new BattleRing(myHero, getNextMonster());
                    Thread threadScene = new Thread(ring);
                    threadScene.start();
                    try {
                        threadScene.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    readyCurrentBattle = ring.isReadyBattle();
                    break;
                case '3':
                    System.out.println("Надеюсь увидить Вас вскоре. До встречи!!!");
                    System.exit(1);
            }
        }
    }

    private Monster getNextMonster() {
        Monster monster;
        int monsterType = Randomizer.getRandomOf(9999) % NUM_TYPE_OF_MONSTER;
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
        System.out.print("Наш мир в большой опасности. Монстры повсюду. Ты готов спасти его ???\n" +
                "1 - Да, я готов!!!\n" +
                "0 - Нет, я еще не готов...\n" +
                "Ваш ответ: ");

        boolean choice = getBinaryChoice();
        if(choice){
            System.out.println("\nСкажи свое имя герой: ");
            return scanner.nextLine();
        } else {
            System.out.println("Очень жаль. Надеюсь увидить Вас вскоре. До встречи.");
            return null;
        }
    }

    private  char getItemMenu() {
        char choise;
        boolean faultOperation = true;
        Scanner s = new Scanner(System.in);

        if(readyCurrentBattle){
            if(getConfirmNextBattle()){
                return '2';
            }
        }

        do {
            System.out.printf("\nВы в городе, куда вы хотите пойти %s?\n",myHero.getName());
            System.out.println("\u2630 Menu");
            System.out.println("1 - К торговцу.");
            System.out.println("2 - В темный лес.");
            System.out.println("3 - На выход.");
            System.out.print("Ваш выбор: ");
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

    private boolean getConfirmNextBattle() {
        System.out.print("Продолжаем прогулку по лесу ???\n" +
                "1 - Да, продолжим.\n" +
                "0 - Нет, я наверное вернусь в город. \n" +
                "Ваш ответ: ");

        readyCurrentBattle = getBinaryChoice();
        return readyCurrentBattle;
    }

    private boolean getBinaryChoice(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice == 0) {
                    return false;
                } else if (choice == 1){
                    return true;
                }
                else {
                    System.out.println("Неверный выбор. Повторите еще раз.");
                }
            } else {
                System.out.println("Неверный выбор. Повторите еще раз.");
                scanner.next();
            }
        }
    }
}
