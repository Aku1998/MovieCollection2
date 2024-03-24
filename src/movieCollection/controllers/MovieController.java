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

    public void handleSaveCommand() {  // сохранить фильмы в файл
        Collection<Movie> movies = this.movieRepo.getValues();
        this.fileRepo.save(movies);

    }

    public void loadMovies() {  // загрузить фильмы из файла

    }
//    Person person1 = new Person("Инна Веткина", false);  // это все здесь не нужно, можно удалять
//    Person person2 = new Person("Евгений Велтистов", true);
//    Person person3 = new Person("Люк Бессон", true);
//    Person person4 = new Person("David Fincher", true);
//    Person person5 = new Person("Ryan Murphy", true);
//    Person person6 = new Person("Fatih Akin", true);
//    Person person7 = new Person("Tim Burton", true);
//    Person person8 = new Person("Александр Войтинский", true);
//    Movie movie1 = new Movie("Приключения Буратино", MovieGenre.ACTION, person1);
//    Movie movie2 = new Movie("Приключения Электроника", MovieGenre.ADVENTURE, person2);
//    Movie movie3 = new Movie("Люси", MovieGenre.ACTION, person3);
//    Movie movie4 = new Movie("Gone Girl", MovieGenre.TRAGEDY, person4);
//    Movie movie5 = new Movie("Dahmer-Monster", MovieGenre.HORROR, person5);
//    Movie movie6 = new Movie("Gegen die Wand", MovieGenre.TRAGEDY, person6);
//    Movie movie7 = new Movie("Die Insel der besonderen Kinder", MovieGenre.FANTASY, person7);
//    Movie movie8 = new Movie("По щучъему велению.", MovieGenre.FANTASY, person8);

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

    public boolean startRemoveKeyCommand(long idValue) { // Татьяна
        if (this.movieRepo.containsKey(idValue)) {
            this.movieRepo.remove(idValue);
            return true;
        }
        return false;
    }

    public void startClearCommand() {
        // Татьяна
        movieRepo.clear();
    }

    public void startRemoveGreaterCommand(Long idIn) { //Дарья
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

    public void startRemoveLowerCommand(Long idIn) { // Дарья
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

    public int startCountLessThanGenreCommand(MovieGenre targetGenre) { // Дарья

        int counter = 0;
        for (Movie movie : movieRepo.getValues()) {

            if (movie.getGenre().ordinal() < targetGenre.ordinal()) {
                counter = counter + 1;
            }
        }

        return counter;
    }
}
