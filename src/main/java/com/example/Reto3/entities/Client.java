package com.example.Reto3.entities;

import java.io.Serializable;
//import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client implements Serializable {

    // ATRIBUTOS**
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private String age;

    // @Column(name = "createdAt")
    // private Date createdAt;

    // @Column(name = "updatedAt")
    // private Date updatedAt;

    // *METODOS */

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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
     * 
     * // *RELACIONES
     */
    // un empleado puede tener muchas reservaciones y messages

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Message> Reservation = new HashSet<>();

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Message> Messages = new HashSet<>();

    public void actualizarClient(Integer id2, Client client) {
    }

    public Client crearClient(Client client) {
        return null;
    }

    public void eliminarClient(int id2) {
    }

    public Client getClient(int id2) {
        return null;
    }

    public List<Client> getListClients() {
        return null;
    }

}
