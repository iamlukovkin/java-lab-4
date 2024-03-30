package evm.aircraft.models;

import java.util.Objects;

public class Engine extends Detail {
    private float maxPower;

    public Engine(String name, float wearOut, float maxPower) {
        super(name, wearOut);
        setMaxPower(maxPower);
    }

    public Engine(String name, float maxPower) {
        this(name, 0, maxPower);
    }

    public void setMaxPower(float maxPower) {
        if (maxPower < 0) {
            throw new IllegalArgumentException("Максимальная мощность должна быть больше нуля");
        }
        this.maxPower = maxPower;
    }

    @Override
    public void use() {
        super.use();
        setMaxPower(getMaxPower() * 0.99f);
    }

    public float getMaxPower() {
        return maxPower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Engine engine)) return false;
        if (!super.equals(o)) return false;
        return Float.compare(getMaxPower(), engine.getMaxPower()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMaxPower());
    }

    @Override
    public String toString() {
        return STR."Engine (\n\textended of \{super.toString()}\n\tmaxPower = \{getMaxPower()}\n)";
    }
}
