package com.employee.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seatingchart.model.SeatingChart;
import com.seatingchart.model.SeatingChartService;

@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmpRepository employeeRepository;
    
    @Autowired
    private SeatingChartService seatingChartService;

    public Employee getOneEmp(Integer empId) {
        Optional<Employee> optional = employeeRepository.findById(empId);
        return optional.orElse(null);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public List<Employee> getAvailable() {
        return employeeRepository.findAvailableEmployees();
    }

    public void assignSeatToEmployee(Integer floorSeatSeq, Integer empId) {
        SeatingChart seat = seatingChartService.getOneSeat(floorSeatSeq);
        Employee emp = getOneEmp(empId);

        if (seat != null && emp != null) {
            emp.setSeatingChart(seat);
            employeeRepository.save(emp);
        }
    }
}

