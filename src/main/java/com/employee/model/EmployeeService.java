package com.employee.model;

import java.util.List;

public interface  EmployeeService {

    public Employee getOneEmp(Integer empId) ;

    public List<Employee> getAll() ;

    public List<Employee> getAvailable() ;

    public void assignSeatToEmployee(Integer floorSeatSeq, Integer empId);
    
}
