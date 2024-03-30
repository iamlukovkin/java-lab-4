package evm.aircraft;

import evm.aircraft.controllers.PlaneController;
import evm.aircraft.controllers.creational.FactoryManager;
import evm.aircraft.models.Plane;
import evm.aircraft.models.RoadTrack;

public class AircraftApplication {
    public static void main() {
        Plane plane = FactoryManager.getInstance().getPlaneFactory().createDefault();
        PlaneController planeController = new PlaneController();

        planeController.fly(plane);
        RoadTrack roadTrack = new RoadTrack("Казань", "Владивосток");
        planeController.setRoadTrack(plane, roadTrack);
        planeController.displayRoadTrack(plane);
    }
}
