package vehicle;

//use of vehicle interface is here so that in future there comes multiple types of vehicle 0 wheeler,5 wheeler etc
//you don't have to add the implementation for that vehicle in all the classes where you're using vehicle objects
public abstract class Vehicle {
    private int type;
    private int id;

    protected Vehicle(int id, int type){
        setId(id);
        setType(type);
    }

    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
