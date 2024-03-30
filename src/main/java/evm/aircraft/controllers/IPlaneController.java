package evm.aircraft.controllers;

import evm.aircraft.models.IPlane;
import evm.aircraft.models.Plane;
import evm.aircraft.models.RoadTrack;

public interface IPlaneController extends IPlane {
    void setRoadTrack(Plane plane, RoadTrack track);
    void displayRoadTrack(Plane plane);
}
