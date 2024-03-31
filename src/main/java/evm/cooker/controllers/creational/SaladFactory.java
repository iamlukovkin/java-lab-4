package evm.cooker.controllers.creational;

import evm.aircraft.controllers.creational.ICreate;
import evm.cli.Reader;
import evm.cooker.models.Salad;
import evm.cooker.models.Vegetable;
import evm.cooker.models.VegetableType;

import java.util.ArrayList;

public class SaladFactory extends MealFactory implements ICreate<Salad> {
    private final VegetableFactory vegetableFactory = new VegetableFactory();

    @Override
    public Salad create() {
        String name = getName();
        ArrayList<Vegetable> vegetables = new ArrayList<>();
        int typeVegetablesCount = Reader.getInstance().readInteger("Количество овощей:");
        for (int i = 0; i < typeVegetablesCount; i++) {
            Vegetable vegetable = makeVegetable();
            int vegetablesCount = Reader.getInstance().readInteger(STR."Количество \{vegetable.getName()}:");
            VegetableType vegetableType = vegetable.getVegetableType();
            vegetables.add(new Vegetable(vegetableType, vegetableType.getCalories() * vegetablesCount));
        }
        return new Salad(name, vegetables);
    }

    @Override
    public Salad createDefault() {
        String name = "Классический";
        ArrayList<Vegetable> vegetables = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            vegetables.add(vegetableFactory.createDefault());
        }
        return new Salad(name, vegetables);
    }

    private Vegetable makeVegetable() {
        return vegetableFactory.create();
    }
}
