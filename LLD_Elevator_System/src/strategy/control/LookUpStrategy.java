package strategy.control;

import controller.ElevatorController;
import elevator.Elevator;
import manager.ElevatorManager;
import pendingRequests.PendingRequests;

import java.util.*;

import static constants.Constants.DIRECTION_DOWN;
import static constants.Constants.DIRECTION_UP;

public class LookUpStrategy extends ElevatorControlStrategy{

    private List<ElevatorController> elevatorControllerList;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    @Override
    public void moveElevator(ElevatorController elevatorController) {
        Elevator elevator = elevatorController.getElevator();

        if(elevator.getDirection() == DIRECTION_UP){
            while(!minHeap.isEmpty()){
                int floor_id = minHeap.poll();
                elevator.move(floor_id,DIRECTION_UP);
            }
            elevator.setDirection(DIRECTION_DOWN);
            while(!downQueue.isEmpty()){
                int floor_id = downQueue.poll();
                maxHeap.add(floor_id);
            }
        }
        else {
            while(!maxHeap.isEmpty()){
                int floor_id = maxHeap.poll();
                elevator.move(floor_id,DIRECTION_DOWN);
            }
            elevator.setDirection(DIRECTION_UP);
            while(!upQueue.isEmpty()){
                int floor_id = upQueue.poll();
                minHeap.add(floor_id);
            }
        }
    }

    @Override
    public void addRequest(ElevatorController elevatorController,int floor_id,int direction){
        Elevator elevator = elevatorController.getElevator();
        if(elevator.getDirection() == DIRECTION_UP){
            if(floor_id > elevator.getCurr_floor())
                minHeap.add(floor_id);
            else
                upQueue.add(floor_id);
        }
        else{
            if(floor_id < elevator.getCurr_floor())
                maxHeap.add(floor_id);
            else
                downQueue.add(floor_id);
        }
    }
}
