package evm.aircraft.controllers.creational;

public class FactoryManager {
    private static FactoryManager instance;
    private static final RoadTrackFactory ROAD_TRACK_FACTORY = new RoadTrackFactory();
    private static final EngineFactory engineFactory = new EngineFactory();
    private static final WingFactory wingFactory = new WingFactory();
    private static final WheelFactory wheelFactory = new WheelFactory();
    private static final PlaneFactory planeFactory = new PlaneFactory();

    private FactoryManager() {}

    public static FactoryManager getInstance() {
        if (instance == null) {
            instance = new FactoryManager();
        }
        return instance;
    }

    public EngineFactory getEngineFactory() {
        return engineFactory;
    }

    public WingFactory getWingFactory() {
        return wingFactory;
    }

    public WheelFactory getWheelFactory() {
        return wheelFactory;
    }

    public PlaneFactory getPlaneFactory() {
        return planeFactory;
    }

    public RoadTrackFactory getTrackFactory() {
        return ROAD_TRACK_FACTORY;
    }
}
