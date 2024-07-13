package com.javatest.springboot_java;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.seatingchart.model.SeatingChart;
import com.seatingchart.model.SeatingChartRepository;
import com.seatingchart.model.SeatingChartService;



	public class TestUnit {
	    
		@Autowired
		SeatingChartRepository repository ;
		
//		public static void main(String[] args) {
//			List<SeatingChart> seatlist =SeatingChartService. getAll();
//			for (SeatingChart seat : seatlist) {
//				System.out.print(seat.toString() + ",");
//			}
//	    }

	    

}
