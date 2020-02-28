package br.com.java.entities;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public abstract class ExtraHours {

	private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	
	private String hoursPerformed;
	private Double dsrPercentage;
	private Double employeeSalary;
	
	public ExtraHours() {
	}

	public ExtraHours(String hoursPerformed, Double dsrPercentage, Double employeeSalary) {
		this.hoursPerformed = hoursPerformed;
		this.dsrPercentage  = dsrPercentage;
		this.employeeSalary = employeeSalary;
	}

	public String getHoursPerformed() {
		return hoursPerformed;
	}

	public void setHoursPerformed(String hoursPerformed) {
		this.hoursPerformed = hoursPerformed;
	}

	public Double getDsrPercentage() {
		return dsrPercentage;
	}

	public void setDsrPercentage(Double dsrPercentage) {
		this.dsrPercentage = dsrPercentage;
	}

	public Double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(Double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	
	
	  public Integer minutesPerformed() { 
		  Calendar cal = Calendar.getInstance();
		  Date d = Date.from(Instant.parse(getHoursPerformed())); sdf.format(d);
		  cal.setTime(d); 
		  int hours = cal.get(Calendar.HOUR); 
		  int minutes = cal.get(Calendar.MINUTE);
	  
		  return (hours * 60) + minutes; 
	}
	 	
	public double calculationHours() {
		double valueMinute = getEmployeeSalary() / 13200;
		valueMinute *= minutesPerformed();
		double addPercentage = valueMinute * 0.5;
		valueMinute += addPercentage;
		double dsrPercentage = valueMinute * (getDsrPercentage() / 100);
		
		return valueMinute + dsrPercentage;
	}
}