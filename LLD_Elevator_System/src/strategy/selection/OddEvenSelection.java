package strategy.selection;

import controller.ElevatorController;
import elevator.Elevator;
import manager.ElevatorManager;

import java.util.List;

import static constants.Constants.DIRECTION_DOWN;
import static constants.Constants.DIRECTION_UP;

public class OddEvenSelection implements ElevatorSelectionStrategy {
    List<ElevatorController> elevatorControllerList;

    @Override
    public Elevator selectElevator(int floor_id, int direction) {
        elevatorControllerList = ElevatorManager.getElevatorInstance().getElevatorControllerList();
        for(ElevatorController elevatorController:elevatorControllerList){
            if(floor_id%2 == elevatorController.getElevator().getId() && direction == elevatorController.getElevator().getStatus()){
                if(direction == DIRECTION_UP && floor_id > elevatorController.getElevator().getCurr_floor())
                    return elevatorController.getElevator();
                if(direction == DIRECTION_DOWN && floor_id < elevatorController.getElevator().getCurr_floor())
                    return elevatorController.getElevator();
            }
        }
        return null;
    }
}
