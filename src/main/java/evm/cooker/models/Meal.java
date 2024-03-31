package evm.cooker.models;

import java.util.Objects;

public abstract class Meal implements Edible {
    private final String name;
    private float calories;

    public Meal(String name, float calories) {
        this.name = name;
        setCalories(calories);
    }

    public void setCalories(float calories) {
        if (calories <= 0) {
            throw new IllegalArgumentException("Калории должны быть больше 0");
        }
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    @Override
    public float getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return STR."Meal{name='\{name}\{'\''}, calories=\{calories}\{'}'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meal meal)) return false;
        return Float.compare(getCalories(), meal.getCalories()) == 0 && Objects.equals(getName(), meal.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCalories());
    }
}
