package button;

import dispatchers.ElevatorButtonDispatcher;
import elevator.Elevator;

public class ElevatorButton extends Button{
    int id;
    ElevatorButtonDispatcher elevatorButtonDispatcher;

    @Override
    public void pressButton(Elevator elevator, int floor_id, int direction) {
        elevatorButtonDispatcher = ElevatorButtonDispatcher.getInstanceOfDispatcher();
        elevatorButtonDispatcher.submitRequest(elevator,floor_id,direction);
    }
}
