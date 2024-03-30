package evm.aircraft.controllers.creational;

import evm.aircraft.models.*;
import evm.cli.Reader;

import java.util.ArrayList;

public class PlaneFactory implements ICreate<Plane> {
    private final EngineFactory engineFactory = FactoryManager.getInstance().getEngineFactory();
    private final WingFactory wingFactory = FactoryManager.getInstance().getWingFactory();
    private final WheelFactory wheelFactory = FactoryManager.getInstance().getWheelFactory();
    private final RoadTrackFactory roadTrackFactory = FactoryManager.getInstance().getTrackFactory();

    @Override
    public Plane create() {
        String name = makeName();
        Engine engine = engineFactory.create();
        ArrayList<Wing> wings = makeWings(false);
        ArrayList<Wheel> wheels = makeWheels(false);
        RoadTrack roadTrack = roadTrackFactory.create();
        return new Plane(name, engine, wings, wheels, roadTrack);
    }

    @Override
    public Plane createDefault() {
        Engine engine = engineFactory.createDefault();
        ArrayList<Wing> wings = makeWings(true);
        ArrayList<Wheel> wheels = makeWheels(true);
        RoadTrack roadTrack = roadTrackFactory.createDefault();
        return new Plane("Самолёт", engine, wings, wheels, roadTrack);
    }

    public String makeName() {
        return Reader.getInstance().readString("Название самолёта: ");
    }

    public ArrayList<Wing> makeWings(boolean useDefault) {
        ArrayList<Wing> wings = new ArrayList<>();
        if (useDefault) {
            for (int i = 0; i < 2; i++) {
                wings.add(wingFactory.createDefault());
            }
        } else {
            int wingsCount = Reader.getInstance().readInteger("Количество крыльев: ");
            for (int i = 0; i < wingsCount; i++) {
                wings.add(wingFactory.create());
            }
        }
        return wings;
    }

    public ArrayList<Wheel> makeWheels(boolean useDefault) {
        ArrayList<Wheel> wheels = new ArrayList<>();
        if (useDefault) {
            for (int i = 0; i < 3; i++) {
                wheels.add(wheelFactory.createDefault());
            }
        } else {
            int wheelsCount = Reader.getInstance().readInteger("Количество колес: ");
            for (int i = 0; i < wheelsCount; i++) {
                wheels.add(wheelFactory.create());
            }
        }
        return wheels;
    }
}
