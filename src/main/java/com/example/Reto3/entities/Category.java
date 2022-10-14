package com.example.Reto3.entities;

import java.io.Serializable;
//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category implements Serializable {

    // **ATRIBUTOS ***
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    // ** METODOS */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*
     * public List<Category> getListCategories() {
     * return null;
     * }
     */

    public Category getCategory(int id2) {
        return null;
    }

    public Category crearCategory(Category category) {
        return null;
    }

    public void eliminarCategory(int id2) {
    }

    public void actualizarCategory(Integer id2, Category category) {
    }

}
