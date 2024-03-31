package evm.cooker.models;

public enum VegetableType {
    CUCUMBER("Огурец", 15f),
    TOMATO("Помидор", 10f),
    ONION("Лук", 5f),
    BROCCOLI("Брокколи", 20f),
    CARROT("Морковь", 15f);

    private final String name;
    private final float calories;

    VegetableType(String name, float calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public float getCalories() {
        return calories;
    }

    public static VegetableType getVegetableType(String name) {
        for (VegetableType vegetableType : values()) {
            if (vegetableType.getName().equalsIgnoreCase(name)) {
                return vegetableType;
            }
        }
        throw new IllegalArgumentException("Такого овоща нет");
    }
}
