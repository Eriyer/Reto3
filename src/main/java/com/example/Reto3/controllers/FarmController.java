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

import com.example.Reto3.entities.Farm;
import com.example.Reto3.services.FarmService;

@Service
@RestController
@RequestMapping("api/Farm")

public class FarmController {
    @Autowired
    FarmService farmservice;

    public FarmController(FarmService farmservice) {
        this.farmservice = farmservice;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Farm>> getFarms() {
        return new ResponseEntity<List<Farm>>(this.farmservice.getListFarms(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farm> getFarm(@PathVariable("id") int id) {
        return new ResponseEntity<Farm>(this.farmservice.getFarm(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Farm> crearFarm(@RequestBody Farm farm) {
        return new ResponseEntity<Farm>(this.farmservice.crearFarm(farm), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFarm(@PathVariable("id") int id) {
        this.farmservice.eliminarFarm(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> actualizarFarm(@RequestBody Farm farm) {
        this.farmservice.actualizarFarm(farm.getId(), farm);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
