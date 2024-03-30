package evm.aircraft.views;

import evm.aircraft.models.IPlane;
import evm.aircraft.models.RoadTrack;

public interface IPlaneView extends IPlane {
    void displayRoadTrack(RoadTrack roadTrack);
}
