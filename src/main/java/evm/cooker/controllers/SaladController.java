package evm.cooker.controllers;

import evm.cooker.controllers.creational.SaladFactory;
import evm.cooker.models.Salad;
import evm.cooker.models.SortCharacteristic;
import evm.cooker.models.Vegetable;

import java.util.ArrayList;

public class SaladController implements ISalad {
    private final SaladFactory saladFactory = new SaladFactory();

    public Salad makeSalad() {
        return saladFactory.create();
    }

    @Override
    public ArrayList<Vegetable> sortVegetables(evm.cooker.models.Salad salad, SortCharacteristic sortCharacteristic) {
        ArrayList<Vegetable> vegetables = salad.getVegetables();
        return switch (sortCharacteristic) {
            case NAME -> sortByName(vegetables);
            case SortCharacteristic.CALORIES -> sortByCalories(vegetables);
        };
    }

    @Override
    public ArrayList<Vegetable> findVegetablesByCaloriesRange(ArrayList<Vegetable> vegetables, float minCalories, float maxCalories) {
        ArrayList<Vegetable> result = new ArrayList<>();
        for (Vegetable vegetable : vegetables) {
            if (vegetable.getCalories() >= minCalories && vegetable.getCalories() <= maxCalories) {
                result.add(vegetable);
            }
        }
        return result;
    }

    private ArrayList<Vegetable> sortByName(ArrayList<Vegetable> vegetables) {
        for(int i = 0; i < vegetables.size(); i++) {
            for (int j = i + 1; j < vegetables.size(); j++) {
                if (vegetables.get(i).getName().compareTo(vegetables.get(j).getName()) > 0) {
                    Vegetable temp = vegetables.get(i);
                    vegetables.set(i, vegetables.get(j));
                    vegetables.set(j, temp);
                }
            }
        }
        return vegetables;
    }

    private ArrayList<Vegetable> sortByCalories(ArrayList<Vegetable> vegetables) {
        for(int i = 0; i < vegetables.size(); i++) {
            for (int j = i + 1; j < vegetables.size(); j++) {
                if (vegetables.get(i).getCalories() > vegetables.get(j).getCalories()) {
                    Vegetable temp = vegetables.get(i);
                    vegetables.set(i, vegetables.get(j));
                    vegetables.set(j, temp);
                }
            }
        }
        return vegetables;
    }
}
