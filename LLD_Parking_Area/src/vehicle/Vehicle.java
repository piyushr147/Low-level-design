package vehicle;

import enums.WheelerType;

//use of vehicle interface is here so that in future there comes multiple types of vehicle 0 wheeler,5 wheeler etc
//you don't have to add the implementation for that vehicle in all the classes where you're using vehicle objects
public abstract class Vehicle {
    private WheelerType type;
    private int id;

    protected Vehicle(int id, WheelerType type){
        setId(id);
        setType(type);
    }

    public WheelerType getType() {
        return type;
    }
    public void setType(WheelerType type) {
        this.type = type;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
