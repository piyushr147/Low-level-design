package dispatchers;

import controller.ElevatorController;
import elevator.Elevator;
import manager.ElevatorManager;

import java.util.List;

public class FloorButtonDispatcher {
    private List<ElevatorController> elevatorControllerList;
    private static FloorButtonDispatcher FBDInstance;

    private FloorButtonDispatcher(){
        System.out.println("FloorButtonDispatcher getting initialised...");
    };

    public static FloorButtonDispatcher getInstanceOfDispatcher(){
        if(FBDInstance == null){
            FBDInstance = new FloorButtonDispatcher();
        }
        return FBDInstance;
    }

    public List<ElevatorController> getElevatorControllerList() {
        return elevatorControllerList;
    }

    public void setElevatorControllerList(List<ElevatorController> elevatorControllerList) {
        this.elevatorControllerList = elevatorControllerList;
    }

    public void submitRequest(int floorId, int direction) {
        Elevator elevator = ElevatorManager.getElevatorInstance().findElevatorForRequest(floorId,direction);
        if(elevator != null){
            for(ElevatorController elevatorController:elevatorControllerList){
                if(elevatorController.getElevator().getId() == elevator.getId())
                    elevatorController.acceptRequest(floorId,direction);
            }
        }
        else
            System.out.println("cannot find any idle elevator for now, please try again later");
    }
}
