package br.com.java.entities;

import java.text.SimpleDateFormat;

public class RemoteAssistence extends ExtraHours{
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

	
	public RemoteAssistence(String hoursPerformed, Double dsrPercentage, Double employeeSalary) {
		super(hoursPerformed, dsrPercentage, employeeSalary);
	}

	public RemoteAssistence() {
	super();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nHours performed: "   + sdf.format(getHoursPerformed()));
		sb.append("\nBase salary    : R$" + String.format("%.2f", getEmployeeSalary()));
		sb.append("\nBase DSR       : "   + getDsrPercentage() + "%");
		sb.append("\nValue final    : R$" + calculationHours());
		
		return sb.toString();
	}
}