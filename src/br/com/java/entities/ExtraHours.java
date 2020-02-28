package br.com.java.entities;

public abstract class ExtraHours {

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
		  int hours   = Integer.parseInt(getHoursPerformed().substring(0, 2));
		  int minutes = Integer.parseInt(getHoursPerformed().substring(3));
		  
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