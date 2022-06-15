package com.example.demo.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
      
        @Id
        @SequenceGenerator(
                name = "employee_sequence",
                sequenceName = "employee_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "employee_sequence"
        )
        private Long id;
        private String name;
        private String email;
        private String cargo;
        

        
        public Employee() {
        }

        
        public Employee(Long id, String name, String email, String cargo) {
                this.id = id;
                this.name = name;
                this.email = email;
                this.cargo = cargo;
        }

        public Employee(String name, String email, String cargo) {
                this.name = name;
                this.email = email;
                this.cargo = cargo;
        }


        
        public String getCargo() {
                return cargo;
        }

        public void setCargo(String cargo) {
                this.cargo = cargo;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

}
