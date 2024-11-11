package strategy.control;

import controller.ElevatorController;
import elevator.Elevator;
import pendingRequests.PendingRequests;

import java.util.LinkedList;
import java.util.Queue;

public class ElevatorControlStrategy {
    public Queue<Integer> upQueue = new LinkedList<>();
    public Queue<Integer> downQueue = new LinkedList<>();


    public void moveElevator(ElevatorController elevatorController){};

    public void addRequest(ElevatorController elevatorController,int floor_id, int direction) {};
}
