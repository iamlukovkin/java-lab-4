package evm.aircraft.views;

import evm.aircraft.models.Plane;
import evm.aircraft.models.RoadTrack;

public class PlaneView implements IPlaneView {
    @Override
    public void fly(Plane plane) {
        String name = plane.getName();
        System.out.println(STR."Самолёт \"\{name}\" летит!");
        displayRoadTrack(plane.getRoadTrack());
    }

    public void setRoadTrack(RoadTrack roadTrack) {
        System.out.println("Маршрут самолета изменился");
        displayRoadTrack(roadTrack);
    }

    @Override
    public void displayRoadTrack(RoadTrack roadTrack) {
        String source = roadTrack.getSource();
        String destination = roadTrack.getDestination();
        System.out.println(STR."Текущий маршрут: \{source} - \{destination}");
    }
}
