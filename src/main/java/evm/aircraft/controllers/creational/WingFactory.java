package evm.aircraft.controllers.creational;

import evm.aircraft.models.Wing;
import evm.cli.Reader;

public class WingFactory implements ICreate<Wing> {
    @Override
    public Wing create() {
        String name = Reader.getInstance().readString("Название крыла");
        float length = Reader.getInstance().readFloat("Длина крыла");
        return new Wing(name, length);
    }

    @Override
    public Wing createDefault() {
        return new Wing("Крыло", 10);
    }
}
