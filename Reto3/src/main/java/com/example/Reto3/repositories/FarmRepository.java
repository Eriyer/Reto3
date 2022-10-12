package com.example.Reto3.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Reto3.entities.Farm;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Integer> {

}
