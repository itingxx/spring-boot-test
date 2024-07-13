package com.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.seatingchart.model.SeatingChart;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Integer empId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name = "floor_seat_seq", referencedColumnName = "floor_seat_seq")
    private SeatingChart seatingChart;

    // Constructors
    public Employee() {}

    public Employee(String name, String email, SeatingChart seatingChart) {
        this.name = name;
        this.email = email;
        this.seatingChart = seatingChart;
    }

    // Getters and Setters
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SeatingChart getSeatingChart() {
        return seatingChart;
    }

    public void setSeatingChart(SeatingChart seatingChart) {
        this.seatingChart = seatingChart;
    }

    @Override
    public String toString() {
        return "Employee [員編=" + empId + ", 員工姓名=" + name + ", 員工電子郵件=" + email + ", 座位資訊=" + seatingChart + "]";
    }
}
