package evm.cooker.models;

public class Vegetable extends Meal {
    private final VegetableType vegetableType;
    public Vegetable(VegetableType vegetableType, float calories) {
        super(vegetableType.getName(), calories);
        this.vegetableType = vegetableType;
        setCalories(calories);
    }

    public VegetableType getVegetableType() {
        return vegetableType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vegetable)) return false;
        return super.equals(o);
    }

    @Override
    public String toString() {
        return STR."Vegetable{name=\{getName()}, calories=\{getCalories()}}";
    }
}
