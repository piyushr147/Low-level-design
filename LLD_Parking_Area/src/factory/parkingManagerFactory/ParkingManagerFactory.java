package factory.parkingManagerFactory;

import enums.ManagerType;
import parkingSlotManager.ParkingSlotManager;
import parkingSlotManager.parkingSlotConcreteClass.FourWheelerParkingSlotManager;
import parkingSlotManager.parkingSlotConcreteClass.TwoWheelerParkingSlotManager;

public class ParkingManagerFactory {
    public static ParkingSlotManager createParkingSlotManagerObject(ManagerType managerType) {
        if(managerType == ManagerType.TWO_WHEELER_MANAGER){
            return TwoWheelerParkingSlotManager.getInstance();
        }
        else if(managerType == ManagerType.FOUR_WHEELER_MANAGER){
            return FourWheelerParkingSlotManager.getInstance();
        }
        return TwoWheelerParkingSlotManager.getInstance();
    };
}
