package com.employee.model;

import java.util.List;

public interface  EmployeeService {

    public Employee getOneEmp(Integer empId) ;

    public List<Employee> getAll() ; 
    //未選擇位子的員工
    public List<Employee> getAvailable() ;
   //儲存選擇位子的員工
    public void assignSeatToEmployee(Integer floorSeatSeq, Integer empId);
    
}
