package controller;

import elevator.Elevator;
import manager.ElevatorManager;

public class ElevatorController {
    private Elevator elevator;

    ElevatorController(Elevator elevator){
        this.elevator = elevator;
    }

    public Elevator getElevator() {
        return elevator;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }

    public void acceptRequest(int floor_id, int direction) {
        System.out.println("Accepting the request for floorid: "+floor_id);
        ElevatorManager.getElevatorInstance().getElevatorControlStrategy().addRequest(this,floor_id,direction);
        controlElevatorFlow();
    }

    public void controlElevatorFlow(){
        ElevatorManager.getElevatorInstance().moveElevator(this);
    }
}
