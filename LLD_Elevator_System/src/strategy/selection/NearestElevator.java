package strategy.selection;

import controller.ElevatorController;
import elevator.Elevator;
import manager.ElevatorManager;

import java.util.List;

import static constants.Constants.DIRECTION_DOWN;
import static constants.Constants.DIRECTION_UP;

public class NearestElevator implements ElevatorSelectionStrategy{
    private List<ElevatorController> elevatorControllerList;

    @Override
    public Elevator selectElevator(int floor_id, int direction) {
        elevatorControllerList = ElevatorManager.getElevatorInstance().getElevatorControllerList();
        Elevator nearestElevator = null;
        int nearest = 99999;
        for(ElevatorController elevatorController:elevatorControllerList){
            Elevator currElevator = elevatorController.getElevator();
            int curr_direction = currElevator.getDirection();
            int curr_floor = currElevator.getCurr_floor();

            if(direction == curr_direction){
                if(direction == DIRECTION_UP && floor_id > curr_floor){
                    if(nearest > floor_id - curr_floor){
                        nearest = floor_id - curr_floor;
                        nearestElevator = currElevator;
                    }
                }
                if(direction == DIRECTION_DOWN && floor_id < curr_floor){
                    if(nearest > curr_floor - floor_id){
                        nearest = curr_floor - floor_id;
                        nearestElevator = currElevator;
                    }
                }
            }
        }
        return nearestElevator;
    }
}
