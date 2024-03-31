package evm.cooker;

import evm.cli.Reader;
import evm.cooker.controllers.SaladController;
import evm.cooker.controllers.creational.SaladFactory;
import evm.cooker.models.Salad;
import evm.cooker.models.SortCharacteristic;
import evm.cooker.models.Vegetable;
import evm.cooker.views.MenuView;
import evm.cooker.views.SaladView;

import java.util.ArrayList;

public class CookerApplication {
    private final static SaladController saladController = new SaladController();
    private final static SaladView saladView = new SaladView();

    public static void main() {
        MenuView menuView = new MenuView();
        boolean isContinue = true;
        int option;
        Salad salad = (new SaladFactory()).createDefault();

        while (isContinue) {
            option = Reader.getInstance().readInteger(menuView.getActions());
            if (option == 1) {
                System.out.println(STR."Текущий салат: \n\{saladView.displaySalad(salad)}");
            } else if (option == 2) {
                salad = createSalad();
            } else if (option == 3) {
                System.out.println(saladView.displayVegetables(salad.getVegetables()));
            } else if (option == 4) {
                System.out.println(saladView.calculateCalories(salad));
            } else if (option == 5) {
                sortVegetables(salad);
            } else if (option == 6) {
                findVegetablesFromRange(salad);
            } else if (option == 7) {
                isContinue = false;
            } else {
                System.out.println("Введено некорректное значение");
            }
        }
    }

    public static Salad createSalad() {
        Salad salad = saladController.makeSalad();
        System.out.println(saladView.makeSalad(salad));
        return salad;
    }

    public static void findVegetablesFromRange(Salad salad) {
        float minCalories = Reader.getInstance().readFloat("Минимальная калорийность: ");
        float maxCalories = Reader.getInstance().readFloat("Максимальная калорийность: ");
        ArrayList<Vegetable> vegetables = salad.getVegetables();
        ArrayList<Vegetable> vegetablesFromRange = saladController.findVegetablesByCaloriesRange(
                vegetables, minCalories, maxCalories);
        System.out.println(saladView.findVegetablesByCaloriesRange(
                vegetablesFromRange, minCalories, maxCalories));
    }

    public static void sortVegetables(evm.cooker.models.Salad salad) {
        System.out.println(saladView.sortCharacteristics());
        int option = Reader.getInstance().readInteger("Выберите параметр сортировки");
        SortCharacteristic sortCharacteristic = SortCharacteristic.values()[option - 1];
        ArrayList<Vegetable> vegetables = saladController.sortVegetables(salad, sortCharacteristic);
        System.out.println(saladView.sortVegetables(vegetables, sortCharacteristic));
    }

}
