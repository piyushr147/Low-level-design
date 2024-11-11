package manager;

import location.Location;
import show.Show;
import theatre.Theatre;
import venue.Venue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VenueManager {
    private List<Venue> venueList;
    private static VenueManager venueManager;
    private Location userLocation;

    private VenueManager(){
        venueList = new ArrayList<>();
    }

    public static VenueManager getInstance(){
        if(venueManager == null)
            venueManager = new VenueManager();
        return venueManager;
    }

    public Location getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(Location userLocation) {
        this.userLocation = userLocation;
    }


    public void addVenue(Venue venue){
        venueList.add(venue);
    }

    public Venue getVenue(int venude_id){
        for(Venue venue:venueList){
            if(venue.getId() == venude_id)
                return venue;
        }
        return null;
    }

    public void showAvailableVenues(String movie){
        List<Integer> availableVenues = new ArrayList<>();
        for(Venue venue:venueList){
            if(venue.getLocation().getCity().equalsIgnoreCase(userLocation.getCity())){
                if(venue.isMovieAvailable(movie)){
                    availableVenues.add(venue.getId());
                    System.out.println("venue: " + venue.getId());
                    System.out.println("Show: "+venue.getName());
                    System.out.println("Place: "+venue.getLocation().getState()+" "+venue.getLocation().getCity());
                }
            }
        }
        int venue_id = enterId();
        if(venue_id != -1){
            for(Integer id:availableVenues){
                if(id == venue_id){
                    Venue venue = getVenue(venue_id);
                    venue.showAvailableTheatres(movie);
                }
            }
        }
    }

    public int enterId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id you want to see shows for, -1 in case of no show is available acc to you");
        int number = scanner.nextInt();
        scanner.close();
        return number;
    }
}
