package vrb.battle.characters;



public enum TradesList {
    POTION("Зелье", TradesList.POTION_PRICE),
    PROTECTION("Защита",TradesList.PROTECTION_PRICE),
    EXTRA_POWER("Супер-сила",TradesList.EXTRA_POWER_PRICE);

    public static final int POTION_PRICE = 1;
    public static final int EXTRA_POWER_PRICE = 2;
    public static final int PROTECTION_PRICE = 3;

    private String enumName;
    private int enumPrice;

    TradesList(String name, int price){
        this.enumName = name;
        this.enumPrice = price;
    }

    public String getEnumName() {
        return enumName;
    }

    public int getEnumPrice() {
        return enumPrice;
    }
}
