package com.example.demo.plant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/ark/planta")
public class PlantController {
        
        private final PlantService plantService;

        @Autowired
        public PlantController(PlantService plantService) {
                this.plantService = plantService;
        }

        @GetMapping
        public List<Plant> getPlantList() {
                return plantService.getPlants();
        }

        @PostMapping
        public void registerNewPlant(@RequestBody Plant plant) {
                plantService.addNewPlant(plant);
        }

        @DeleteMapping(path = "{plantId}")
        public void deletePlant(@PathVariable("plantId") Long plantId) {
                plantService.deletePlant(plantId);
        }

        @PutMapping(path = "{plantId}")
        public void updatePlant(
                @PathVariable("plantId") Long plantId,
                @RequestParam(required = false) String nomePopular,
                @RequestParam(required = false) String nomeCientifico,
                @RequestParam(required = false) String familia,
                @RequestParam(required = false) String categoria,
                @RequestParam(required = false) String clima, 
                @RequestParam(required = false) String origem,
                @RequestParam(required = false) String altura,
                @RequestParam(required = false) String luminosidade
        )
        {
                plantService.updatePlant(plantId, nomeCientifico, nomePopular, familia, categoria, clima, origem, altura, luminosidade);
        }
}
