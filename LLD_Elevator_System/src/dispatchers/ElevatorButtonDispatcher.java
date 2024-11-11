package dispatchers;

import controller.ElevatorController;
import elevator.Elevator;
import manager.ElevatorManager;

import java.util.List;

public class ElevatorButtonDispatcher {
    private List<ElevatorController> elevatorControllerList;
    private static ElevatorButtonDispatcher EBDInstance;
    private ElevatorButtonDispatcher(){
        System.out.println("ElevatorButtonDispatcher getting initialised");
    }

    public static ElevatorButtonDispatcher getInstanceOfDispatcher(){
        if(EBDInstance == null){
            EBDInstance = new ElevatorButtonDispatcher();
        }
        return EBDInstance;
    }

    public List<ElevatorController> getElevatorControllerList() {
        return elevatorControllerList;
    }

    public void setElevatorControllerList(List<ElevatorController> elevatorControllerList) {
        this.elevatorControllerList = elevatorControllerList;
    }

    public void submitRequest(Elevator elevator, int floor_id, int direction) {
        for(ElevatorController elevatorController:elevatorControllerList){
            if(elevatorController.getElevator().getId() == elevator.getId())
                elevatorController.acceptRequest(floor_id,direction);
        }
    }
}
