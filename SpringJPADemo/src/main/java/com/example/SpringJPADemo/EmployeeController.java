package com.example.SpringJPADemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServive employeeServive;

    @PostMapping
    private ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) throws URISyntaxException {
        employee=employeeServive.craeteEmployee(employee);
        URI location=new URI("/employee/"+employee.getId());
        return ResponseEntity.created(location).body(employee);
    }

}
