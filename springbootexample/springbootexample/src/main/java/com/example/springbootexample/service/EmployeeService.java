package com.example.springbootexample.service;


import com.example.springbootexample.entity.EmployeeDTORequest;
import com.example.springbootexample.entity.EmployeeDTOResponse;
import com.example.springbootexample.entity.ProductDTORequest;
import com.example.springbootexample.entity.ProductDTOResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    public ResponseEntity<List<EmployeeDTOResponse>> findAllEmployee();

    public ResponseEntity<EmployeeDTOResponse> findByIdEmployee(Integer id);

    public ResponseEntity<EmployeeDTOResponse> createEmployee(EmployeeDTORequest employeeDTORequest);

    public ResponseEntity<EmployeeDTOResponse> updateEmployee(Integer id, ProductDTORequest productDTORequest);

    public ResponseEntity<Void> deleteEmployee(Integer id);
}
