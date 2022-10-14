package com.example.Reto3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reto3.entities.Reservation;
import com.example.Reto3.repositories.ReservationRepository;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // METODOS CRUD
    // metogo GET que me trae todos los estudiantes
    public List<Reservation> getListReservation() {
        return this.reservationRepository.findAll();

    }

    // metodo GET que me trae un sólo estudiante
    public Reservation getReservation(int id) {
        return this.reservationRepository.findById(id).get();
    }

    // metodoo POST
    public Reservation crearReservation(Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }

    // metodo DELETE
    public void eliminarReservation(int id) {
        this.reservationRepository.deleteById(id);

    }

    // metodoo PUT
    public void actualizarReservation(int id, Reservation reservation) {
        if (this.reservationRepository.findById(id).isEmpty()) {
            Reservation reservationDB = this.reservationRepository.findById(id).get();

            this.reservationRepository.save(reservationDB);
        }

    }

}
