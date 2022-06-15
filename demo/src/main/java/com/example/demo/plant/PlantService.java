package com.example.demo.plant;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantService {
        
        private final PlantRepository plantRepository;

        @Autowired
        public PlantService(PlantRepository plantRepository) {
                this.plantRepository = plantRepository;
        }

        public List<Plant> getPlants() {
                return plantRepository.findAll();
        }

        public void addNewPlant(Plant plant) {

                Optional<Plant> plantOptional = plantRepository.findPlantByNomeCientifico(plant.getNomeCientifico());

                if (plantOptional.isPresent()) {
                        throw new IllegalStateException("Planta ja cadastrada");
                }

                plantRepository.save(plant);
        }

        public void deletePlant(Long plantId) {
                boolean exists = plantRepository.existsById(plantId);

                if (!exists) {
                        throw new IllegalStateException("planta com o id [" + plantId + "] nao existe");
                }

                plantRepository.deleteById(plantId);
        }

        
        @Transactional
        public void updatePlant(Long plantId, String nomeCientifico, String nomePopular, String familia, 
                        String categoria, String clima, String origem, String altura, String luminosidade) {

                Plant plant = plantRepository.findById(plantId).orElseThrow(
                        () -> new IllegalStateException(
                                "planta com o id [" + plantId + "] nao existe"
                        )
                );

                if (nomePopular != null && nomePopular.length() > 0 && !Objects.equals(plant.getNomePopular(), nomePopular)) {
                        plant.setNomePopular(nomePopular);
                }

                if (nomeCientifico != null && nomeCientifico.length() > 0 && !Objects.equals(plant.getNomeCientifico(), nomeCientifico)) {
                        plant.setNomeCientifico(nomeCientifico);
                }

                if (familia != null && familia.length() > 0 && !Objects.equals(plant.getFamilia(), familia)) {
                        plant.setFamilia(familia);
                }

                if (categoria != null && categoria.length() > 0 && !Objects.equals(plant.getCategoria(), categoria)) {
                        plant.setCategoria(categoria);
                }

                if (clima != null && clima.length() > 0 && !Objects.equals(plant.getClima(), clima)) {
                        plant.setClima(clima);
                }

                if (origem != null && origem.length() > 0 && !Objects.equals(plant.getOrigem(), origem)) {
                        plant.setOrigem(origem);
                }

                if (altura != null && altura.length() > 0 && !Objects.equals(plant.getAltura(), altura)) {
                        plant.setAltura(altura);
                }

                if (luminosidade != null && luminosidade.length() > 0 && !Objects.equals(plant.getLuminosidade(), luminosidade)) {
                        plant.setLuminosidade(luminosidade);
                }                
        }        
}
