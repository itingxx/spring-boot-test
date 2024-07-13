package com.seatingchart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.employee.model.Employee;

@Entity
@Table(name = "seatingchart")
public class SeatingChart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "floor_seat_seq")
    private Integer floorSeatSeq;

    @Column(name = "floor_no", nullable = false)
    private Integer floorNo;

    @Column(name = "seat_no", nullable = false)
    private Integer seatNo;

    @OneToOne(mappedBy = "seatingChart") 
    private Employee employee;

    
    public SeatingChart() {}

    public SeatingChart(Integer floorSeatSeq, Integer floorNo, Integer seatNo) {
        this.floorSeatSeq = floorSeatSeq;
        this.floorNo = floorNo;
        this.seatNo = seatNo;
    }

 
    public Integer getFloorSeatSeq() {
        return floorSeatSeq;
    }

    public void setFloorSeatSeq(Integer floorSeatSeq) {
        this.floorSeatSeq = floorSeatSeq;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Integer floorNo) {
        this.floorNo = floorNo;
    }

    public Integer getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(Integer seatNo) {
        this.seatNo = seatNo;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "SeatingChart [序號=" + floorSeatSeq +
               ", 樓層編號=" + floorNo +
               ", 座位編號=" + seatNo +
               ", 員編=" + (employee != null ? employee.getEmpId() : "none") + "]";
    }

}
