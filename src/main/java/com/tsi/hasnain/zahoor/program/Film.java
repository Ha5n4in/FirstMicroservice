package com.tsi.hasnain.zahoor.program;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="film")

public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;

    //Attributes
    private String film_name;
    private String film_description;

//    @ManyToMany(mappedBy = "actor", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private Set<Film> film = new HashSet<>();

    public Film(String filmName, String filmDescription) {
        this.film_name = filmName;
        this.film_description = filmDescription;
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
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }

    public String getFilm_description() {
        return film_description;
    }

    public void setFilm_description(String film_description) {
        this.film_description = film_description;
    }


}
