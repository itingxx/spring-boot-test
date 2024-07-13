package com.seatingchart.model;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.model.Employee;
import com.employee.model.EmpRepository;

@Service("SeatingChartService")
public class SeatingChartServiceImpl implements SeatingChartService {
    
    @Autowired
    private SeatingChartRepository seatingChartRepository;
    
    @Autowired
    private EmpRepository empRepository;

    public List<SeatingChart> getAll() {
        return seatingChartRepository.findAll();
    }

    public void updateSeat(SeatingChart seatingChart) {
        seatingChartRepository.save(seatingChart);
    }

    public SeatingChart getOneSeat(Integer floorSeatSeq) {
        Optional<SeatingChart> optional = seatingChartRepository.findById(floorSeatSeq);
        return optional.orElse(null);
    }

    public void clearSeat(Integer floorSeatSeq) {
        SeatingChart seat = getOneSeat(floorSeatSeq);
        if (seat != null && seat.getEmployee() != null) {
            Employee emp = seat.getEmployee();
            emp.setSeatingChart(null);
            empRepository.save(emp);
        }
    }
}

