package com.tsi.hasnain.zahoor.program;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="language")

public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int language_id;

    //Attributes
    private String language_name;

//    @ManyToMany(mappedBy = "actor", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private Set<Film> film = new HashSet<>();

    public Language(String languageName) {
        this.language_name = languageName;
    }

    //Empty Constructor
    public Language() {
    }

    //Getter and Setters

    //needed to Many-to-Many mapping
    //public Set<Film> getFilm() {
    //return film;
    //}
    //public void setFilm() {
    //this.film = films;
    //}

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getLanguage_name() {
        return language_name;
    }

    public void setLanguage_name(String language_name) {
        this.language_name = language_name;
    }


}
