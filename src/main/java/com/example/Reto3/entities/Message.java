package com.example.Reto3.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Message")
public class Message implements Serializable {

    // ATRIBUTOS**
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "messagetext")
    private String messagetext;

    // RELACIONES//
    // Relacion muchos a uno. El message tiene enlazado un Client y un Farm
    @ManyToOne(optional = false)
    @JsonIgnoreProperties(value = { "messages", "reservations" })
    @JoinColumn(name = "farm_id")
    private Farm farm;

    @ManyToOne(optional = false)
    @JsonIgnoreProperties(value = { "messages", "reservations" })
    @JoinColumn(name = "client_id")
    private Client client;

    // METODOS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessagetext() {
        return messagetext;
    }

    public void setMessagetext(String messagetext) {
        this.messagetext = messagetext;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }
}
