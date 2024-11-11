package strategy.selection;

import elevator.Elevator;

public interface ElevatorSelectionStrategy {
    public Elevator selectElevator(int floor_id,int direction);
}
