package factory.parkingManagerFactory;

import parkingSlotManager.ParkingSlotManager;

public interface ParkingManagerFactory {
    public ParkingSlotManager createParkingSlotManagerObject(int capacity);
}
