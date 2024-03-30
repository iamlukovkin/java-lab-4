package evm.aircraft.models;

import java.util.Objects;

public class Wing extends Detail {
    private final float length;

    public Wing(String name, float wearOut, float length) {
        super(name, wearOut);
        if (length < 0) {
            throw new IllegalArgumentException("Длина крыла должна быть больше 0");
        }
        this.length = length;
    }

    public Wing(String name, float length) {
        this(name, 0, length);
    }

    public float getLength() {
        return length;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Wing)) {
            return false;
        }
        return super.equals(obj) && length == ((Wing) obj).getLength();
    }

    @Override
    public int hashCode() {
        return Objects.hash(length) + super.hashCode();
    }

    @Override
    public String toString() {
        return STR."Wing (\n\textended of \{super.toString()}\n\tlength = \{length}\n)";
    }
}
