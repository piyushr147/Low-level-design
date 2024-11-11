package factory.parkingManagerFactory.parkingManagerConcreteClass;

import factory.parkingManagerFactory.ParkingManagerFactory;
import parkingSlotManager.ParkingSlotManager;
import parkingSlotManager.parkingSlotConcreteClass.FourWheelerParkingSlotManager;

public class FourWheelerParkingManagerFactory implements ParkingManagerFactory {
    @Override
    public ParkingSlotManager createParkingSlotManagerObject(int capacity) {
        return new FourWheelerParkingSlotManager(capacity);
    }
}
