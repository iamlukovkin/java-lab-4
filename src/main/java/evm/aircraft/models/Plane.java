package evm.aircraft.models;

import java.util.ArrayList;
import java.util.Objects;

public class Plane {
    private final String name;
    private Engine engine;
    private ArrayList<Wing> wings;
    private ArrayList<Wheel> wheels;
    private RoadTrack roadTrack;

    public Plane(String name, Engine engine, ArrayList<Wing> wings, ArrayList<Wheel> wheels, RoadTrack roadTrack) {
        this.name = name;
        setEngine(engine);
        setWings(wings);
        setWheels(wheels);
        setRoadTrack(roadTrack);
    }

    public void setEngine(Engine engine) {
        if(engine == null) {
            throw new IllegalArgumentException("Двигатель не может быть null");
        }
        this.engine = engine;
    }

    public void setWings(ArrayList<Wing> wings) {
        if(wings == null) {
            throw new IllegalArgumentException("Крылья не могут быть null");
        }
        if (wings.isEmpty()) {
            throw new IllegalArgumentException("У самолета обязательно должны быть крылья!");
        }
        this.wings = wings;
    }

    public void setWheels(ArrayList<Wheel> wheels) {
        if(wheels == null) {
            throw new IllegalArgumentException("Колеса не могут быть null");
        }
        if (wheels.isEmpty()) {
            throw new IllegalArgumentException("У самолета обязательно должны быть колеса!");
        }
        this.wheels = wheels;
    }

    public Engine getEngine() {
        return engine;
    }

    public ArrayList<Wing> getWings() {
        return wings;
    }

    public ArrayList<Wheel> getWheels() {
        return wheels;
    }

    public void use() {
        engine.use();
        for (Wing wing : wings) {
            wing.use();
        }
        for (Wheel wheel : wheels) {
            wheel.use();
        }
    }

    @Override
    public String toString() {
        return STR."Plane{\n\tNAME = \{name}\n\tENGINE = \{engine.toString()}\n\tWINGS = \{wings.toString()}\n\tWHEELS = \{wheels.toString()}\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane plane)) return false;
        return Objects.equals(name, plane.name) && Objects.equals(getEngine(), plane.getEngine()) && Objects.equals(getWings(), plane.getWings()) && Objects.equals(getWheels(), plane.getWheels());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getEngine(), getWings(), getWheels());
    }

    public String getName() {
        return name;
    }

    public RoadTrack getRoadTrack() {
        return roadTrack;
    }

    public void setRoadTrack(RoadTrack roadTrack) {
        this.roadTrack = roadTrack;
    }
}
