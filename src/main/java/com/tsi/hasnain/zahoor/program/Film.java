package com.tsi.hasnain.zahoor.program;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="film")

public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;

    //Attributes
    private String title;
    private String description;
    private int release_year;
    private int language_id;
    private int length;
    private String rating;

//    @ManyToMany(mappedBy = "actor", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private Set<Film> film = new HashSet<>();

    public Film(String filmTitle, String filmDescription, int filmReleaseYear, int filmLanguageID, int filmLength, String filmRating) {
        this.title = filmTitle;
        this.description = filmDescription;
        this.release_year = filmReleaseYear;
        this.language_id = filmLanguageID;
        this.length=filmLength;
        this.rating=filmRating;
    }

    //Empty Constructor
    public Film() {
    }

    //Getter and Setters

    //needed to Many-to-Many mapping
    //public Set<Film> getFilm() {
    //return film;
    //}
    //public void setFilm() {
    //this.film = films;
    //}

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getFilm_name() {
        return title;
    }

    public void setFilm_name(String title) {
        this.title = title;
    }

    public String getFilm_description() {
        return description;
    }

    public void setFilm_description(String description) {
        this.description = description;
    }

    public int getRelease_year(){
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

}
