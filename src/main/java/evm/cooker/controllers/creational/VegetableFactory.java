package evm.cooker.controllers.creational;

import evm.aircraft.controllers.creational.ICreate;
import evm.cooker.models.Vegetable;
import evm.cooker.models.VegetableType;

public class VegetableFactory extends MealFactory implements ICreate<Vegetable> {
    @Override
    public Vegetable create() {
        String name;
        VegetableType vegetableType;
        try {
            System.out.println(getStringNames());
            name = getName();
            vegetableType = VegetableType.getVegetableType(name);
        } catch (Exception e) {
            System.out.println("Такого овоща нет");
            return create();
        }
        return new Vegetable(vegetableType, vegetableType.getCalories());
    }

    @Override
    public Vegetable createDefault() {
        VegetableType defaultType = VegetableType.CUCUMBER;
        float defaultCalories = 20f;
        return new Vegetable(defaultType, defaultCalories);
    }

    private String getStringNames() {
        StringBuilder result = new StringBuilder();
        result.append("Список овощей:\n");
        for(VegetableType vegetableType : VegetableType.values()) {
            result.append(STR."\{vegetableType.getName()} (\{vegetableType.getCalories()} ккал)\n");
        }
        return result.toString();
    }
}
