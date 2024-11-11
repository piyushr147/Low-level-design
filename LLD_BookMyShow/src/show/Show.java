package show;

import movie.Movie;
import searcher.Searcher;

public class Show implements Searcher {
    private int id;
    private Movie movie;
    private int startHour;

    public Show(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    @Override
    public boolean isMovieAvailable(String movie) {
        return movie.equalsIgnoreCase(this.movie.getName());
    }
}
