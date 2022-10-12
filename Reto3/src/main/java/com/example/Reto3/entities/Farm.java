package com.example.Reto3.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Farm")
public class Farm implements Serializable {

    // ATRIBUTOS**
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "extension")
    private String extension;

    @Column(name = "name")
    private String name;

    @Column(name = "descriptoin")
    private String description;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;

    // ** RELACIONES */
    // Relación uno a uno. Una farm tiene un Category relacionado.
    @OneToOne
    @JoinColumn(name = "Category_id")
    private Category category;

    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL)
    private Set<Message> Reservation = new HashSet<>();

    @OneToMany(mappedBy = "farm", cascade = CascadeType.ALL)
    private Set<Message> Messages = new HashSet<>();

    // METODOS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void actualizarFarm(Integer id2, Farm farm) {
    }

    public void eliminarFarm(int id2) {
    }

    public Farm crearFarm(Farm farm) {
        return null;
    }

    public Farm getFarm(int id2) {
        return null;
    }

    public List<Farm> getListFarms() {
        return null;
    }

}
