package br.com.java.entities;

public class PersonalAssistence extends ExtraHours{

	private Integer numberTrips;
	
	public PersonalAssistence() {
		super();
	}

	public PersonalAssistence(String hoursPerformed, Double dsrPercentage, Double employeeSalary, Integer numberTrips) {
		super(hoursPerformed, dsrPercentage, employeeSalary);
		this.numberTrips = numberTrips;
	}

	public Integer getNumberTrips() {
		return numberTrips;
	}

	public void setNumberTrips(Integer numberTrips) {
		this.numberTrips = numberTrips;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nHours performed: "   + getHoursPerformed());
		sb.append("\nBase salary    : R$" + String.format("%.2f", getEmployeeSalary()));
		sb.append("\nBase DSR       : "   + getDsrPercentage() + "%");
		sb.append("\nNumber of trips: "   + getNumberTrips());
		sb.append("\nValue final    : R$" + String.format("%.2f", calculationHours() + (getNumberTrips() * 10)));
		sb.append("\n");
		
		return sb.toString();
	}
}