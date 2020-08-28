package by.belstu.it.Karpushevich.basejava;

import java.util.*;
import java.lang.Object.*;

public class Film {

    private int id;
    private String title;
    private int year;


    private static Map<Integer, Film> allFilms;

    private static int countID = 0;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Film(String title, int year){
        if(allFilms== null){
            allFilms = new HashMap<>();
        }
        this.title = title;
        this.year = year;

        if(!hasFilm()){
            countID++;
            this.id = countID;
            allFilms.put(id, this);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Film film = (Film) obj;
        return year == film.year &&
                title == film.title;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year);
    }

    private boolean hasFilm(){
        for (Film film : allFilms.values()){
            if (film.equals(this) && film.hashCode() == this.hashCode()){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Film { " +
                "Title: " + title+ ", " +
                "Year: " + year + "}";
    }

    public static List<Film> getAllFilms(){
        return new ArrayList<>(allFilms.values());
    }

    public static List<Film> getAllFilms(int year){
        List<Film> listAllFilm = new ArrayList<>();
        for(Film film : allFilms.values()){
            if (film.year == year){
                listAllFilm.add(film);
            }
        }
        return listAllFilm;
    }

    public static int getHowManyFilms(){
        return allFilms.size();
    }

    public static int getHowManyFilms(int year){
        return getAllFilms(year).size();
    }





}
