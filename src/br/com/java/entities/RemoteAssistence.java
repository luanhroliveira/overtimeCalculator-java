package br.com.java.entities;

public class RemoteAssistence extends ExtraHours{
	
	public RemoteAssistence(String hoursPerformed, Double dsrPercentage, Double employeeSalary) {
		super(hoursPerformed, dsrPercentage, employeeSalary);
	}

	public RemoteAssistence() {
	super();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nHours performed: "   + getHoursPerformed());
		sb.append("\nBase salary    : R$" + String.format("%.2f", getEmployeeSalary()));
		sb.append("\nBase DSR       : "   + getDsrPercentage() + "%");
		sb.append("\nValue final    : R$" + String.format("%.2f", calculationHours()));
		sb.append("\n");
					 
		return sb.toString();
	}
}