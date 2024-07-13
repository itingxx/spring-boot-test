package com.seatingchart.model;

import java.util.List;
public interface SeatingChartService {

    public List<SeatingChart> getAll() ;

    public void updateSeat(SeatingChart seatingChart);

    public SeatingChart getOneSeat(Integer floorSeatSeq);

    public void clearSeat(Integer floorSeatSeq);
    
}
