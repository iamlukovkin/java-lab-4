package evm.aircraft.controllers.creational;

import evm.cli.Reader;
import evm.aircraft.models.Engine;

public class EngineFactory implements ICreate<Engine> {
    @Override
    public Engine create() {
        String name = Reader.getInstance().readString("Название двигателя");
        float maxPower = Reader.getInstance().readFloat("Максимальная мощность");
        return new Engine(name, maxPower);
    }

    @Override
    public Engine createDefault() {
        return new Engine("Двигатель", 1000);
    }
}
