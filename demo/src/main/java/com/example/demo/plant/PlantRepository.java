package com.example.demo.plant;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
        
        Optional<Plant> findPlantByNomeCientifico(String nomeCientifico);
}
