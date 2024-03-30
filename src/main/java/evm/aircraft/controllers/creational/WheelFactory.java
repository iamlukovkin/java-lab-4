package evm.aircraft.controllers.creational;

import evm.aircraft.models.Wheel;
import evm.cli.Reader;

public class WheelFactory implements ICreate<Wheel> {
    @Override
    public Wheel create() {
        String name = Reader.getInstance().readString("Название колеса");
        float diameter = Reader.getInstance().readFloat("Диаметр колеса");
        return new Wheel(name, diameter);
    }

    @Override
    public Wheel createDefault() {
        return new Wheel("Колесо", 0.5f);
    }
}
