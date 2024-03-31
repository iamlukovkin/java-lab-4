package evm.cooker.views;

import evm.cooker.models.Salad;
import evm.cooker.models.SortCharacteristic;
import evm.cooker.models.Vegetable;

import java.util.ArrayList;

public interface ISaladView {
    String displayVegetables(ArrayList<Vegetable> vegetables);
    String makeSalad(Salad salad);
    String calculateCalories(Salad salad);
    String sortVegetables(ArrayList<Vegetable> vegetables, SortCharacteristic characteristic);
    String findVegetablesByCaloriesRange(ArrayList<Vegetable> vegetables, float minCalories, float maxCalories);
}
