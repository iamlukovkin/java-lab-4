package evm.aircraft.controllers.creational;

import evm.aircraft.models.RoadTrack;
import evm.cli.Reader;

public class RoadTrackFactory implements ICreate<RoadTrack> {
    @Override
    public RoadTrack create() {
        String source = Reader.getInstance().readString("Источник: ");
        String destination = Reader.getInstance().readString("Назначение: ");
        return new RoadTrack(source, destination);
    }

    @Override
    public RoadTrack createDefault() {
        return new RoadTrack("Место отправления", "Место назначения");
    }
}
