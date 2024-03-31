package evm.cooker.controllers;

import evm.cooker.models.Salad;
import evm.cooker.models.SortCharacteristic;
import evm.cooker.models.Vegetable;

import java.util.ArrayList;

public interface ISalad {
    ArrayList<Vegetable> sortVegetables(Salad salad, SortCharacteristic sortCharacteristic);
    ArrayList<Vegetable> findVegetablesByCaloriesRange(ArrayList<Vegetable> vegetables, float minCalories, float maxCalories);
}
