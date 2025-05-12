package com.example.springbootexample.serviceImpl;

import com.example.springbootexample.entity.*;
import com.example.springbootexample.exception.ProductNotFoundException;
import com.example.springbootexample.repository.EmployeeRepository;
import com.example.springbootexample.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ResponseEntity<List<EmployeeDTOResponse>> findAllEmployee() {
        List<Employee> list = employeeRepository.findAll();
        List<EmployeeDTOResponse> updatedList = list.stream()
                .map(e-> new EmployeeDTOResponse(e.getId(), e.getName(), e.getEmail()))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(updatedList);
    }

    @Override
    public ResponseEntity<EmployeeDTOResponse> findByIdEmployee(Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException("Employee Not Found with id : "+id));
        EmployeeDTOResponse employeeDTOResponse = new EmployeeDTOResponse(employee.getId(), employee.getName(), employee.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(employeeDTOResponse);
    }

    @Override
    public ResponseEntity<EmployeeDTOResponse> createEmployee(EmployeeDTORequest employeeDTORequest) {
        Employee employee = new Employee();
        employee.setId(employeeDTORequest.getId());
        employee.setName(employeeDTORequest.getName());
        employee.setEmail(employeeDTORequest.getEmail());

        Employee updtaedEmployee = employeeRepository.save(employee);
        EmployeeDTOResponse employeeDTOResponse = new EmployeeDTOResponse(updtaedEmployee.getId(), updtaedEmployee.getName(), updtaedEmployee.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDTOResponse);

    }

    @Override
    public ResponseEntity<EmployeeDTOResponse> updateEmployee(Integer id, ProductDTORequest productDTORequest) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteEmployee(Integer id) {
        return null;
    }
}
