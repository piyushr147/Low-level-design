package manager;

import controller.ElevatorController;
import elevator.Elevator;
import strategy.control.ElevatorControlStrategy;
import strategy.selection.ElevatorSelectionStrategy;

import java.util.List;

public class ElevatorManager {
    private static ElevatorManager EMinstance;
    private List<ElevatorController> elevatorControllerList;
    private ElevatorSelectionStrategy elevatorSelectionStrategy;
    private ElevatorControlStrategy elevatorControlStrategy;

    private ElevatorManager(){
        System.out.println("Initialising Elevator Manager singleton instance...");
    }

    public static ElevatorManager getElevatorInstance(){
        if(EMinstance == null)
            return new ElevatorManager();
        else
            return EMinstance;
    }

    public void setElevatorControllerList(List<ElevatorController> elevatorControllerList) {
        this.elevatorControllerList = elevatorControllerList;
    }

    public List<ElevatorController> getElevatorControllerList() {
        return elevatorControllerList;
    }

    public void setElevatorSelectionStrategy(ElevatorSelectionStrategy elevatorSelectionStrategy) {
        this.elevatorSelectionStrategy = elevatorSelectionStrategy;
    }

    public ElevatorControlStrategy getElevatorControlStrategy() {
        return elevatorControlStrategy;
    }

    public void setElevatorControlStrategy(ElevatorControlStrategy elevatorControlStrategy) {
        this.elevatorControlStrategy = elevatorControlStrategy;
    }

    public Elevator findElevatorForRequest(int floor_id, int direction){
        return elevatorSelectionStrategy.selectElevator(floor_id,direction);
    }

    public void moveElevator(ElevatorController elevatorController) {
        elevatorControlStrategy.moveElevator(elevatorController);
    }
}
