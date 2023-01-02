package com.example.SpringJPADemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeServive {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private  EmployeeRepo employeeRepo;

    @Autowired
    private BranchRepo branchRepo;

    @Transactional
    public Employee craeteEmployee(Employee employee) {
        Integer value=10;
        Branch branch=branchRepo.findById(1).get();
        employee.setBranch(branch);
        addressRepo.save(employee.getAddress());
        employeeRepo.save(employee);

        System.out.println(value.equals(10));
        return employee;
    }
}
