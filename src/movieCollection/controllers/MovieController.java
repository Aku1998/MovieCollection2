package movieCollection.controllers;

import movieCollection.*;
import movieCollection.models.*;

import java.util.*;

public class MovieController {

    private final MovieRepository movieRepo;
    private final CSVFileRepository fileRepo;
    Scanner scanner;

    public MovieController(String filepath) {// конструктор
        this.scanner = new Scanner(System.in);
        this.movieRepo = new MovieRepository();
        this.fileRepo = new CSVFileRepository(filepath);
    }

    public void addMovie(Movie movie){
        this.movieRepo.add(movie);
    }

    public void handleSaveCommand() {  // сохранить фильмы в файл
        Collection<Movie> movies = this.movieRepo.getValues();
        this.fileRepo.save(movies);

    }

    public void loadMovies() {  // загрузить фильмы из файла

    }

    public int handleInfoCommand() {//Екатерина
        return this.movieRepo.size();
    }

    public Collection<Movie> handleShowCommand() {
        return movieRepo.getValues();
    }

    public void handleInsertCommand(
            String personName, boolean gender, String movieName, MovieGenre genre) {
        Person person = new Person(personName, gender);
        Movie movie1 = new Movie(movieName, genre, person);
        this.movieRepo.add(movie1);
    }

    public void startUpdateCommand(String argIn) { // Акмур

    }

    public boolean handleRemoveKeyCommand(long idValue) { // Татьяна
        if (this.movieRepo.containsKey(idValue)) {
            this.movieRepo.remove(idValue);
            return true;
        }
        return false;
    }

    public void handleClearCommand() {
        // Татьяна
        movieRepo.clear();
    }

    public void handleRemoveGreaterCommand(Long idIn) { //Дарья
        Set<Long> set = new HashSet<>();
        for (Long idMap : movieRepo.getIdSet()) {
            if (idMap > idIn) {
                set.add(idMap);
            }
        }
        for (Long id : set) {
            movieRepo.remove(id);
        }
    }

    public void handleRemoveLowerCommand(Long idIn) { // Дарья
        Set<Long> set = new HashSet<>();
        for (Long idMap : movieRepo.getIdSet()) {
            if (idMap < idIn) {
                set.add(idMap);
            }
        }
        for (Long id : set) {
            movieRepo.remove(id);
        }
    }

    public int handleCountLessThanGenreCommand(MovieGenre targetGenre) { // Дарья

        int counter = 0;
        for (Movie movie : movieRepo.getValues()) {

            if (movie.getGenre().ordinal() < targetGenre.ordinal()) {
                counter = counter + 1;
            }
        }

        return counter;
    }
}
