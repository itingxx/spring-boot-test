package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employee.model.EmpRepository;
import com.employee.model.Employee;
import com.employee.model.EmployeeService;
import com.seatingchart.model.SeatingChart;
import com.seatingchart.model.SeatingChartRepository;
import com.seatingchart.model.SeatingChartService;

@SpringBootApplication
public class Test_Application_CommandLineRunner implements CommandLineRunner {

	@Autowired
	EmpRepository empRepository;

	@Autowired
	SeatingChartRepository seatingChartRepository;

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	SeatingChartService seatingChartService;

    public static void main(String[] args) {
        SpringApplication.run(Test_Application_CommandLineRunner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
System.out.println("測試");
// 新增座位
//SeatingChart  seat1= new SeatingChart();
//seat1.setFloorNo(5);
//seat1.setSeatNo(1);
//seatingChartRepository.save(seat1);

	List<SeatingChart> seatlist = seatingChartService.getAll();
	for (SeatingChart seat : seatlist) {
		System.out.println(seat.toString() + ",");
	}
	
	List<Employee> employeelist = employeeService.getAll();
	for (Employee employee : employeelist) {
		System.out.println(employee.toString() + ",");
	}

    }
}
