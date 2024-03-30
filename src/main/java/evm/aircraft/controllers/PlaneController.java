package evm.aircraft.controllers;

import evm.aircraft.models.Plane;
import evm.aircraft.models.RoadTrack;
import evm.aircraft.views.PlaneView;

public class PlaneController implements IPlaneController {
    @Override
    public void fly(Plane plane) {
        plane.use();
        (new PlaneView()).fly(plane);
    }

    @Override
    public void setRoadTrack(Plane plane, RoadTrack track) {
        plane.setRoadTrack(track);
        (new PlaneView()).setRoadTrack(track);
    }

    @Override
    public void displayRoadTrack(Plane plane) {
        (new PlaneView()).displayRoadTrack(plane.getRoadTrack());
    }
}
