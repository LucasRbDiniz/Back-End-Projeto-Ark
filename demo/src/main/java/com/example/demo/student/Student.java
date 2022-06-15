package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Student {

        @Id
        @SequenceGenerator(
                name = "student_sequence",
                sequenceName = "student_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "student_sequence"
        )
        private Long id;
        private String name;
        private String email;
        private String username;
        private LocalDate dateOfBirth;

        @Transient
        private Integer age;

        public Student() {

        }

        public Student(Long id, String name, String email, String username, LocalDate dateOfBirth) {
                this.id = id;
                this.name = name;
                this.email = email;
                this.username = username;
                this.dateOfBirth = dateOfBirth;
        }

        public Student(String name, String email, String username, LocalDate dateOfBirth) {
                this.name = name;
                this.email = email;
                this.username = username;
                this.dateOfBirth = dateOfBirth;
        }

        public Integer getAge() {
                return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
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

        public LocalDate getDateOfBirth() {
                return dateOfBirth;
        }

        public void setDateOfBirth(LocalDate dateOfBirth) {
                this.dateOfBirth = dateOfBirth;
        }

        public void setAge(Integer age) {
                this.age = age;
        }
        
        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }
        

}
