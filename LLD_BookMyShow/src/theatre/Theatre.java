package theatre;

import searcher.Searcher;
import show.Show;
import ticket.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Theatre implements Searcher {
    private int id;
    private int max_seats = 10;
    private List<Integer> seats;
    private List<Show> showList;

    public Theatre(int id){
        this.id = id;
        showList = new ArrayList<Show>();
    }

    public int getId() {
        return id;
    }

    public int getMax_seats() {
        return max_seats;
    }

    public List<Integer> getSeats() {
        return seats;
    }

    public List<Show> getShowList() {
        return showList;
    }

    public void addShow(Show show){
        showList.add(show);
    }

    public void deleteShow(Show show){
        showList.remove(show);
    }

    public void showMovieSlots(){

    }

    public void showSeats(){
        System.out.println("Current seat arrangement...");
        for (int j = 0; j < max_seats; j++) {
            System.out.println(" " + j + " ");
        }
        for(int i=0;i<max_seats;i++) {
            if (seats.get(i) == 0)
                System.out.println(" E ");
            else
                System.out.println(" B ");
        }
    }

    public Ticket bookSeats(int start, int end) {
        if (checkSeatsAvailable(start, end)) {
            return null;
        }
        else
            System.out.println("Ticket got booked by some other user");
        return null;
    }

    public boolean checkSeatsAvailable(int start,int end){
        for(int i=start;i<=end;i++){
            if(seats.get(i) == 1){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isMovieAvailable(String movie) {
        for(Show show:showList){
            if(show.isMovieAvailable(movie))
                return true;
        }
        return false;
    }
}
