package com.example.Reto3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reto3.entities.Farm;
import com.example.Reto3.repositories.FarmRepository;

@Service
public class FarmService {
    @Autowired
    private FarmRepository farmRepository;

    public FarmService(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    // METODOS CRUD
    // metogo GET que me trae todos los estudiantes
    public List<Farm> getListFarms() {
        return this.farmRepository.findAll();

    }

    // metodo GET que me trae un sólo estudiante
    public Farm getFarm(int id) {
        if (!this.farmRepository.findById(id).isEmpty()) {
            return this.farmRepository.findById(id).get();
        } else {
            return null;
        }
    }

    // metodoo POST
    public Farm crearFarm(Farm farm) {
        return this.farmRepository.save(farm);
    }

    // metodo DELETE
    public void eliminarFarm(int id) {
        if (!this.farmRepository.findById(id).isEmpty()) {
            this.farmRepository.deleteById(id);
        }
    }

    // metodoo PUT
    public void actualizarFarm(int id, Farm farm) {
        if (!this.farmRepository.findById(id).isEmpty()) {
            Farm farmDB = this.farmRepository.findById(id).get();
            if (farm.getName() != null) {
                farmDB.setName(farm.getName());
            }
            if (farm.getAddress() != null) {
                farmDB.setAddress(farm.getAddress());
            }
            if (farm.getDescription() != null) {
                farmDB.setDescription(farm.getDescription());
            }
            if (farm.getExtension() != null) {
                farmDB.setExtension(farm.getExtension());
            }
            this.farmRepository.save(farmDB);
        }
    }
}
