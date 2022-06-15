package com.example.demo.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
        
	private final StudentRepository studentRepository;	

	@Autowired
        public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public void addNewStudent(Student student) {

		Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
		Optional<Student> sOptional = studentRepository.findStudentByUsername(student.getUsername());

		if (studentOptional.isPresent()) {
			throw new IllegalStateException("Email ja utilizado");
		}
		
		if (sOptional.isPresent()) {
			throw new IllegalStateException("Nome de usuario ja utilizado");
		}

		studentRepository.save(student);

	}

        public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);

		if (!exists) {
			throw new IllegalStateException("student with id [" + studentId + "] does not exists");
		}
		studentRepository.deleteById(studentId);
        }

	@Transactional
        public void updateStudent(Long studentId, String name, String email, String username) {

		Student student = studentRepository.findById(studentId).orElseThrow(
			() -> new IllegalStateException(
				"student with id [" + studentId + "] does not exists"));

		if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
			student.setName(name);
		}

		if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
			Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);

			if (studentOptional.isPresent()) {
				throw new IllegalStateException("Email ja utilizado");
			}

			student.setEmail(email);
		}

		if (username != null && username.length() > 0 && !Objects.equals(student.getUsername(), username)) {
			Optional<Student> sOptional = studentRepository.findStudentByUsername(username);

			if (sOptional.isPresent()) {
				throw new IllegalStateException("Nome de usuario ja utilizado");
			}

			student.setUsername(username);
		}
        }

        
}
