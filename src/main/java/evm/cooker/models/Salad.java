package evm.cooker.models;

import java.util.ArrayList;
import java.util.Objects;

public class Salad extends Meal {
    ArrayList<Vegetable> vegetables;

    public Salad(String name, ArrayList<Vegetable> vegetables) {
        super(name, 1);
        setVegetables(vegetables);
    }

    public ArrayList<Vegetable> getVegetables() {
        return vegetables;
    }

    public void setVegetables(ArrayList<Vegetable> vegetables) {
        this.vegetables = vegetables;
        setCalories();
    }

    private void setCalories() {
        float calories = 0f;
        for (Vegetable vegetable : vegetables) {
            calories += vegetable.getCalories();
        }
        super.setCalories(calories);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salad salad)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getVegetables(), salad.getVegetables());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getVegetables());
    }

    @Override
    public String toString() {
        return STR."Salad{\n\textendsof \{super.toString()}\n\tvegetables=\{vegetables}\n}";
    }
}
