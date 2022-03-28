package vrb.battle.characters;

import vrb.battle.service.Randomizer;

import java.util.Scanner;

public class Tradesman {

    public static void Shopping(Hero hero) {
        int choice;
        if ((Randomizer.getRandomOf(99999)) % 5 == 0)
            System.out.println("\nК сожелению торговца нет в городе.");
        else {
            System.out.println("\nРад приветствовать вас в моем магазине.");
            System.out.println("Сегодня у меня есть такие предложения для Вас:\n");
            choice = getMenuItem();
            while (choice != 0) {
                buying(hero, choice);
                int number = getChoice(Integer.MAX_VALUE);
                if (number * TradesList.values()[choice - 1].getEnumPrice() < hero.getGold()) {
                    transaction(hero, choice, number);
                } else {
                    System.out.println("У Вас не достаточно денег для данной покупки!!!");
                }
                System.out.println(hero);
                System.out.println("\nЖелаете еще чего нибудь?");
                choice = getMenuItem();
            }
        }
    }

    private static void buying(Hero hero, int product) {
        System.out.print("Введите количество покупаемых едениц выбранного товара: ");
    }

    private static int getChoice(int limit) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice >= 0 && choice <= limit) {
                    return choice;
                } else {
                    System.out.println("Неверный выбор. Повторите еще раз.");
                }
            } else {
                System.out.println("Неверный выбор. Повторите еще раз.");
                scanner.next();
            }
        }
    }

    private static int getMenuItem() {
        printTradeMenu();
        System.out.print("Сделайте свой выбор: ");
        return getChoice(TradesList.values().length);
    }

    private static void printTradeMenu() {
        for (TradesList item : TradesList.values()) {
            System.out.printf("%d - %s. Стоимость единицы в монетах - %d\n", item.ordinal() + 1, item.getEnumName(), item.getEnumPrice());
        }
        System.out.printf("0 - На выход\n");
    }

    private static void transaction(Hero hero, int choice, int number) {
        switch (TradesList.values()[choice - 1]) {
            case POTION: {
                hero.addPotion(number);
                break;
            }
            case PROTECTION: {
                hero.addProtection(number);
                break;
            }
            case EXTRA_POWER: {
                hero.addExtraPower(number);
                break;
            }
        }
        hero.spendGold(number * TradesList.values()[choice - 1].getEnumPrice());
    }
}
