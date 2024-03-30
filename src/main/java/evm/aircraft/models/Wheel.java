package evm.aircraft.models;

import java.util.Objects;

public class Wheel extends Detail {
    private final float diameter;

    public Wheel(String name, float wearOut, float diameter) {
        super(name, wearOut);
        if (diameter <= 0) {
            throw new IllegalArgumentException("Диаметр колес должен быть больше нуля");
        }
        this.diameter = diameter;
    }

    public Wheel(String name, float diameter) {
        this(name, 0, diameter);
    }

    public float getDiameter() {
        return diameter;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Wheel)) {
            return false;
        }
        return super.equals(obj) && ((Wheel) obj).getDiameter() == getDiameter();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDiameter()) + super.hashCode();
    }

    @Override
    public String toString() {
        return STR."Wheel (\n\textended of \{super.toString()}\n\tdiameter = \{getDiameter()}\n)";
    }
}
