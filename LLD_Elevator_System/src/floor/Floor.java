package floor;

import button.FloorButton;
import elevator.Elevator;

import java.util.List;

public class Floor {
    private List<Elevator> elevatorList;
    private FloorButton floorButton;
    int id;

    public FloorButton getFloorButton() {
        return floorButton;
    }

    public void setFloorButton(FloorButton floorButton) {
        this.floorButton = floorButton;
    }

    public List<Elevator> getElevatorList() {
        return elevatorList;
    }

    public void setElevatorList(List<Elevator> elevatorList) {
        this.elevatorList = elevatorList;
    }

    public void callElevator(int direction){
        floorButton.pressButton(this.id,direction);
    }
}
