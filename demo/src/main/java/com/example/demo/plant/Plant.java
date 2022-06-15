package com.example.demo.plant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Plant {
      
        @Id
        @SequenceGenerator(
                name = "plant_sequence",
                sequenceName = "plant_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "plant_sequence"
        )
        private Long id;
        private String nomePopular;
        private String nomeCientifico;
        private String familia;
        private String categoria;
        private String clima;
        private String origem;
        private String altura;
        private String luminosidade;

        public Plant() {
        }
        

        public Plant(String nomePopular, String nomeCientifico, String familia, String categoria, String clima,
                        String origem, String altura, String luminosidade) {
                this.nomePopular = nomePopular;
                this.nomeCientifico = nomeCientifico;
                this.familia = familia;
                this.categoria = categoria;
                this.clima = clima;
                this.origem = origem;
                this.altura = altura;
                this.luminosidade = luminosidade;
        }


        public Plant(Long id, String nomePopular, String nomeCientifico, String familia, String categoria, String clima,
                        String origem, String altura, String luminosidade) {
                this.id = id;
                this.nomePopular = nomePopular;
                this.nomeCientifico = nomeCientifico;
                this.familia = familia;
                this.categoria = categoria;
                this.clima = clima;
                this.origem = origem;
                this.altura = altura;
                this.luminosidade = luminosidade;
        }



        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getNomePopular() {
                return nomePopular;
        }

        public void setNomePopular(String nomePopular) {
                this.nomePopular = nomePopular;
        }

        public String getNomeCientifico() {
                return nomeCientifico;
        }

        public void setNomeCientifico(String nomeCientifico) {
                this.nomeCientifico = nomeCientifico;
        }

        public String getFamilia() {
                return familia;
        }

        public void setFamilia(String familia) {
                this.familia = familia;
        }

        public String getCategoria() {
                return categoria;
        }

        public void setCategoria(String categoria) {
                this.categoria = categoria;
        }

        public String getClima() {
                return clima;
        }

        public void setClima(String clima) {
                this.clima = clima;
        }

        public String getOrigem() {
                return origem;
        }

        public void setOrigem(String origem) {
                this.origem = origem;
        }

        public String getAltura() {
                return altura;
        }

        public void setAltura(String altura) {
                this.altura = altura;
        }

        public String getLuminosidade() {
                return luminosidade;
        }

        public void setLuminosidade(String luminosidade) {
                this.luminosidade = luminosidade;
        }
        
}
