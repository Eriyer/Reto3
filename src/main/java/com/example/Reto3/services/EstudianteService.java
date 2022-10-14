package com.example.Reto3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reto3.entities.Estudiante;
import com.example.Reto3.repositories.EstudianteRepository;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    // METODOS CRUD
    // metogo GET que me trae todos los estudiantes
    public List<Estudiante> getListEstudiantes() {
        return this.estudianteRepository.findAll();

    }

    // metodo GET que me trae un sólo estudiante
    public Estudiante getEstudiante(int id) {
        return this.estudianteRepository.findById(id).get();
    }

    // metodoo POST
    public Estudiante crearEstudiante(Estudiante estudiante) {
        return this.estudianteRepository.save(estudiante);
    }

    // metodo DELETE
    public void eliminarEstudiante(int id) {
        this.estudianteRepository.deleteById(id);

    }

}
