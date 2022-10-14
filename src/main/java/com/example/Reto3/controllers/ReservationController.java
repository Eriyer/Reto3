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

import com.example.Reto3.entities.Reservation;
import com.example.Reto3.services.ReservationService;

@Service
@RestController
@RequestMapping("api/Reservation")

public class ReservationController {
    @Autowired
    ReservationService reservationservice;

    public ReservationController(ReservationService reservationservice) {
        this.reservationservice = reservationservice;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getReservations() {
        return new ResponseEntity<List<Reservation>>(this.reservationservice.getListReservation(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable("id") int id) {
        return new ResponseEntity<Reservation>(this.reservationservice.getReservation(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Reservation> crearReservation(@RequestBody Reservation reservation) {
        return new ResponseEntity<Reservation>(this.reservationservice.crearReservation(reservation),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReservation(@PathVariable("id") int id) {
        this.reservationservice.eliminarReservation(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> actualizarReservation(@RequestBody Reservation reservation) {
        this.reservationservice.actualizarReservation(reservation.getId(), reservation);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
