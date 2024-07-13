package com.seatingchart.model;

import java.util.List;
public interface SeatingChartService {

    public List<SeatingChart> getAll() ;

    public SeatingChart getOneSeat(Integer floorSeatSeq);
   //將已占位子的員工清除
    public void clearSeat(Integer floorSeatSeq);
    
}
