package evm.cooker.views;

import evm.cooker.models.Salad;
import evm.cooker.models.SortCharacteristic;
import evm.cooker.models.Vegetable;
import evm.cooker.models.VegetableType;

import java.util.ArrayList;

public class SaladView implements ISaladView {
    @Override
    public String displayVegetables(ArrayList<Vegetable> vegetables) {
        StringBuilder result = new StringBuilder("Овощи: [\n\t");
        for(Vegetable vegetable : vegetables) {
            VegetableType vegetableType = VegetableType.getVegetableType(vegetable.getName());
            float vegetableCount = vegetable.getCalories() / vegetableType.getCalories();
            result.append(STR."\{vegetable.getName()} \{vegetableCount} шт. \{vegetableType.getCalories()} ккал, ");
        }
        return STR."\{result.toString()}\n]";
    }

    @Override
    public String makeSalad(Salad salad) {
        return STR."Создан салат: \{displaySalad(salad)}";
    }

    public String displaySalad(Salad salad) {
        String name = salad.getName();
        String vegetablesString = displayVegetables(salad.getVegetables());
        float calories = salad.getCalories();
        return STR."Салат: \{name}\n\{vegetablesString}\nКалорийность: \{calories} ккал";
    }

    @Override
    public String calculateCalories(Salad salad) {
        return STR."В салате \{salad.getName()} \{salad.getCalories()} ккал";
    }

    @Override
    public String sortVegetables(
            ArrayList<Vegetable> vegetables, SortCharacteristic characteristic) {
        return STR."Овощи отсортированы по \{characteristic}:\n \{displayVegetables(vegetables)}";
    }

    @Override
    public String findVegetablesByCaloriesRange(
            ArrayList<Vegetable> vegetables, float minCalories, float maxCalories) {
        return STR."Овощи в диапазоне ккал \{minCalories} - \{maxCalories}:\n \{displayVegetables(vegetables)}";
    }

    public String sortCharacteristics() {
        StringBuilder result = new StringBuilder();
        SortCharacteristic[] values = SortCharacteristic.values();
        for (int i = 0; i < values.length; i++) {
            result.append(i + 1).append(". ").append(values[i]).append("\n");
        }
        return result.toString();
    }
}
