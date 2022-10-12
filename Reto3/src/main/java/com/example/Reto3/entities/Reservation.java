package com.example.Reto3.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "Reservation")
public class Reservation implements Serializable {

    // ATRIBUTOS**
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "startdate")
    private String startdate;

    @Column(name = "devolutiondate")
    private String devolutiondate;

    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;

    // RELACIONES//
    // Relacion muchos a uno. El message tiene enlazado un Client y un Farm
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Cliente_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Farm_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Farm farm;

    // METODOS//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getDevolutiondate() {
        return devolutiondate;
    }

    public void setDevolutiondate(String devolutiondate) {
        this.devolutiondate = devolutiondate;
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

    public List<Reservation> getListReservations() {
        return null;
    }

    public Reservation crearReservation(Reservation reservation) {
        return null;
    }

    public void eliminarReservation(int id2) {
    }

    public void actualizarReservation(Integer id2, Reservation reservation) {
    }

    public Reservation getReservation(int id2) {
        return null;
    }

}
