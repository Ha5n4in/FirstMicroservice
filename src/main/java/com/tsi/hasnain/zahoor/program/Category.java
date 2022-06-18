package com.tsi.hasnain.zahoor.program;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="category")

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;

    //Attributes
    private String category_name;

//    @ManyToMany(mappedBy = "actor", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private Set<Film> film = new HashSet<>();

    public Category(String categoryName) {
        this.category_name = categoryName;
    }

    //Empty Constructor
    public Category() {
    }

    //Getter and Setters

    //needed to Many-to-Many mapping
    //public Set<Film> getFilm() {
    //return film;
    //}
    //public void setFilm() {
    //this.film = films;
    //}

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }


}
