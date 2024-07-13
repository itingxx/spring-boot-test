package com.seat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.model.Employee;
import com.employee.model.EmployeeService;
import com.seatingchart.model.SeatingChart;
import com.seatingchart.model.SeatingChartService;

@Controller
public class SeatController {


	@Autowired
	EmployeeService employeeService;

	@Autowired
	SeatingChartService seatingChartService;

	@GetMapping("/")
	public String index(Model model) {
		  List<SeatingChart> seatList = seatingChartService.getAll();
		  List<Employee> employeeList = employeeService.getAvailable();
	        model.addAttribute("seatListData", seatList);
	        model.addAttribute("employeeList", employeeList);
		return "index"; // view
	}
	@PostMapping("/updateSeats")
    public String saveSeatAssignment(
    	          	          @RequestParam(required = false) Integer selectedSeatId,
                              @RequestParam(required = false) Integer employeeId,
                              @RequestParam(required = false) Integer clearSeatId ) {
		  if (clearSeatId != null) {
	            seatingChartService.clearSeat(clearSeatId);
	        } else if (selectedSeatId != null && employeeId != null) {
	        	employeeService.assignSeatToEmployee(selectedSeatId, employeeId);
	        }
	
        return "redirect:/";
    }
	
}
