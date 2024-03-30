package evm.aircraft.models;

import java.util.Objects;

public class RoadTrack {
    private String source;
    private String destination;

    public RoadTrack(String source, String destination) {
        setCoordinates(source, destination);
    }

    public void setCoordinates(String source, String destination) {
        if (source == null || destination == null) {
            throw new IllegalArgumentException("Координаты не могут быть null");
        }
        if (source.equals(destination)) {
            throw new IllegalArgumentException("Координаты не могут совпадать");
        }
        this.source = source;
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return STR."Track{\n\tsource = \{source}\n\tdestination = \{destination}\n}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RoadTrack track)) {
            return false;
        }
        return track.getSource().equals(getSource()) && track.getDestination().equals(getDestination());
    }
}
