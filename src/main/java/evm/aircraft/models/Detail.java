package evm.aircraft.models;

abstract public class Detail {
    private final String name;
    private float wearOut;

    public Detail(String name, float wearOut) {
        this.name = name;
        setWearOut(wearOut);
    }

    public void setWearOut(float wearOut) {
        if ((wearOut < 0) || (wearOut > 1)) {
            throw new IllegalArgumentException("Износ должен быть в диапазоне от 0 до 1");
        }
        this.wearOut = wearOut;
    }

    public float getWearOut() {
        return wearOut;
    }

    public String getName() {
        return name;
    }

    public void use() {
        if (wearOut >= 1) {
            throw new IllegalArgumentException("Износ не может быть больше 1");
        }
        setWearOut(getWearOut() + 0.01f);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Detail detail)) {
            return false;
        }
        return detail.getName().equals(getName()) && detail.getWearOut() == getWearOut();
    }

    @Override
    public int hashCode() {
        return getName().hashCode() + Float.hashCode(getWearOut());
    }

    @Override
    public String toString() {
        return STR."Detail{\n\tname=\{name}, \n\twearOut=\{wearOut}\n}";
    }
}
