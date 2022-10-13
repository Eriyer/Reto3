package com.example.Reto3.entities;

import java.io.Serializable;
//import java.util.Date;
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
@Table(name = "Message")
public class Message implements Serializable {

    // ATRIBUTOS**
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "messagetext")
    private String messagetex;

    // @Column(name = "createdAt")
    // private Date createdAt;

    // @Column(name = "updatedAt")
    // private Date updatedAt;

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

    // METODOS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessagetex() {
        return messagetex;
    }

    public void setMessagetex(String messagetex) {
        this.messagetex = messagetex;
    }

    /*
     * public Date getCreatedAt() {
     * return createdAt;
     * }
     * 
     * public void setCreatedAt(Date createdAt) {
     * this.createdAt = createdAt;
     * }
     * 
     * public Date getUpdatedAt() {
     * return updatedAt;
     * }
     * 
     * public void setUpdatedAt(Date updatedAt) {
     * this.updatedAt = updatedAt;
     * }
     */
    public List<Message> getListMessages() {
        return null;
    }

    public Message getMessage(int id2) {
        return null;
    }

    public Message crearMessage(Message message) {
        return null;
    }

    public void eliminarMessage(int id2) {
    }

    public void actualizarMessage(Integer id2, Message message) {
    }

}
