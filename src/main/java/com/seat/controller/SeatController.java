package com.seat.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
//當前座位表
    @GetMapping("/")
    public String index(Model model) {
        List<SeatingChart> seatList = seatingChartService.getAll();
        List<Employee> employeeList = employeeService.getAvailable();

        // 按 floorNo 分組
        Map<Integer, List<SeatingChart>> seatsByFloor = seatList.stream()
            .collect(Collectors.groupingBy(SeatingChart::getFloorNo));

        model.addAttribute("seatsByFloor", seatsByFloor);
        model.addAttribute("employeeList", employeeList);

        return "index"; // 視圖名稱
    }

    @PostMapping("/updateSeats")
    public String updateSeats(
    		                  @RequestParam(required = false) Integer selectedSeatId,
                              @RequestParam(required = false) Integer employeeId,
                              @RequestParam(required = false) Integer clearSeatId,
                              Model model) {
    	//清除佔有該座位員工
        if (clearSeatId != null) {
            seatingChartService.clearSeat(clearSeatId);
            return "redirect:/";
        }
       //將選擇座位的員工存到資料庫,並重導至"/"返回視圖
        if (selectedSeatId != null && employeeId != null) {
            employeeService.assignSeatToEmployee(selectedSeatId, employeeId);
       //顯示錯誤訊息,並返回原視圖
        } else if (selectedSeatId == null || employeeId == null) {
            model.addAttribute("errorMessage", "請選擇座位和員工");
            List<SeatingChart> updatedSeatList = seatingChartService.getAll();
            Map<Integer, List<SeatingChart>> updatedSeatsByFloor = updatedSeatList.stream()
                .collect(Collectors.groupingBy(SeatingChart::getFloorNo));
            model.addAttribute("seatsByFloor", updatedSeatsByFloor);
            model.addAttribute("employeeList", employeeService.getAvailable());
            return "index";
        }
        return "redirect:/";
    }
}
