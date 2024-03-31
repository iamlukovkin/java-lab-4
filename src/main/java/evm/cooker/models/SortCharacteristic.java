package evm.cooker.models;

public enum SortCharacteristic {
    NAME,
    CALORIES;

    public String toString() {
        return name().toLowerCase();
    }
}
