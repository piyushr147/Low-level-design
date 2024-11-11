package venue;

import location.Location;
import theatre.Theatre;
import ticket.Ticket;
import java.util.List;

public class Venue {
    private int id;
    private int name;
    private List<Theatre> theatreList;
    private Location location;

    public Venue(Location location, int name, int id) {
        this.location = location;
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public List<Theatre> getTheatreList() {
        return theatreList;
    }

    public Location getLocation() {
        return location;
    }

    public void addTheatre(Theatre theatre){
        theatreList.add(theatre);
    }

    public void removeTheatre(Theatre theatre){
        theatreList.remove(theatre);
    }

    public void showSeatingArrangement(int theatre_id){
        for(Theatre theatre:theatreList){
            if(theatre.getId() == theatre_id){
                theatre.showSeats();
            }
        }
    }

    public Ticket bookSeats(int theatre_id, int start, int end){
        for(Theatre theatre:theatreList){
            if(theatre.getId() == theatre_id){
                theatre.bookSeats(start,end);
            }
        }
        return null;
    }
}
