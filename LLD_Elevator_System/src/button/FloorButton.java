package button;

import dispatchers.FloorButtonDispatcher;

public class FloorButton extends Button{
    int id;
    FloorButtonDispatcher floorButtonDispatcher;

    @Override
    public void pressButton(int floor_id,int direction) {
        floorButtonDispatcher = FloorButtonDispatcher.getInstanceOfDispatcher();
        floorButtonDispatcher.submitRequest(floor_id,direction);
    }
}
