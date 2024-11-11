package elevator;

import button.ElevatorButton;

import static constants.Constants.DIRECTION_UP;

public class Elevator {
    private int id;
    private int direction;
    private int curr_floor;
    private int status;
    private ElevatorButton elevatorButton;

    public Elevator(int id,int direction,int curr_floor,int status,ElevatorButton elevatorButton){
        this.id = id;
        this.direction = direction;
        this.curr_floor = curr_floor;
        this.status = status;
        this.elevatorButton = elevatorButton;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getCurr_floor() {
        return curr_floor;
    }

    public void setCurr_floor(int curr_floor) {
        this.curr_floor = curr_floor;
    }

    public int getStatus() { return status; }

    public void setStatus(int status) { this.status = status; }

    public void move(int floor, int direction){
        if(direction == DIRECTION_UP){
            while(curr_floor < floor)
                curr_floor++;
        }
        else{
            while(curr_floor > floor)
                curr_floor--;
        }
        System.out.println("Lift with ID:"+getId()+" reached on floor:"+getCurr_floor());
    }

    public void pressButton(int floor_id){
        int direction = 0;
        if(floor_id > curr_floor)
            direction = 1;
        if(floor_id < curr_floor)
            direction = 2;
        elevatorButton.pressButton(id,floor_id,direction);
    }
}
