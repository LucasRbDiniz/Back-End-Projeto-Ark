package com.example.demo.employee;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
        
        private final EmployeeRepository employeeRepository;
        
        @Autowired
        public EmployeeService(EmployeeRepository employeeRepository) {
                this.employeeRepository = employeeRepository;
        }

        public List<Employee> getEmployees() {
                return employeeRepository.findAll();
        }

        public void addNewEmployee(Employee employee) {

                Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(employee.getEmail());

                if (employeeOptional.isPresent()) {
                        throw new IllegalStateException("Email ja utilizado");
                }

                employeeRepository.save(employee);
        }

        public void deleteEmployee(Long employeeId) {
                boolean exists = employeeRepository.existsById(employeeId);

                if (!exists) {
			throw new IllegalStateException("funcionario com id [" + employeeId + "] nao existe");
		}
		employeeRepository.deleteById(employeeId);
        }

        @Transactional
        public void updateEmployee(Long employeeId, String name, String email) {

                Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                        () -> new IllegalStateException(
                                "student with id [" + employeeId + "] does not exists"
                                )
                        );

                if (name != null && name.length() > 0 && !Objects.equals(employee.getName(), name)) {
                        employee.setName(name);
                }
                
                if (email != null && email.length() > 0 && !Objects.equals(employee.getEmail(), email)) {

                        Optional <Employee> employeeOptional = employeeRepository.findEmployeeByEmail(email);

                        if (employeeOptional.isPresent()) {
                                throw new IllegalStateException("Email ja utilizado");
                        }

                        employee.setEmail(email);
                }
        }
}
