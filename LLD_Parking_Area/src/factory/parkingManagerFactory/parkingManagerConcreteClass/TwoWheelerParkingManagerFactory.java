package factory.parkingManagerFactory.parkingManagerConcreteClass;

import factory.parkingManagerFactory.ParkingManagerFactory;
import parkingSlotManager.ParkingSlotManager;
import parkingSlotManager.parkingSlotConcreteClass.TwoWheelerParkingSlotManager;

public class TwoWheelerParkingManagerFactory implements ParkingManagerFactory {
    @Override
    public ParkingSlotManager createParkingSlotManagerObject(int capacity) {
        return new TwoWheelerParkingSlotManager(capacity);
    }
}
