package com.example.Reto3.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reto3.entities.Client;
import com.example.Reto3.services.ClientService;

@Service
@RestController
@RequestMapping("api/Client")

public class ClientController {
    @Autowired
    ClientService clientservice;

    // CONSTRUCTOR**

    public ClientController(ClientService clientservice) {
        this.clientservice = clientservice;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getClient() {
        return new ResponseEntity<List<Client>>(this.clientservice.getListClients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") int id) {
        return new ResponseEntity<Client>(this.clientservice.getClient(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Client> crearClient(@RequestBody Client client) {
        return new ResponseEntity<Client>(this.clientservice.crearClient(client), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarClient(@PathVariable("id") int id) {
        this.clientservice.eliminarClient(id);
        return new ResponseEntity<String>("Client Eliminado", HttpStatus.NO_CONTENT);
    }

    @PutMapping("/Update")
    public ResponseEntity<String> actualizarClient(@RequestBody Client Client) {
        this.clientservice.actualizarClient(Client.getId(), Client);
        return new ResponseEntity<String>("Client Actualizada", HttpStatus.CREATED);
    }
}
