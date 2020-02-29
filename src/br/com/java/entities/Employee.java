package br.com.java.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.java.enums.Department;

public class Employee {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private String name;
	private Integer idBadge;
	protected String cpf;
	private Double salary;
	Department department;
	private Date date;
	
	ExtraHours extraHours;
	
	public Employee() {
	}

	public Employee(Date date, String name, Integer idBadge, String cpf, Double salary, Department department, ExtraHours extraHours) {
		this.date 		= date;
		this.name 		= name;
		this.idBadge 	= idBadge;
		this.cpf 		= cpf;
		this.salary 	= salary;
		this.department = department;
		this.extraHours = extraHours;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIdBadge() {
		return idBadge;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public void setIdBadge(Integer idBadge) {
		this.idBadge = idBadge;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public ExtraHours getExtraHours() {
		return extraHours;
	}

	public void setExtraHours(ExtraHours extraHours) {
		this.extraHours = extraHours;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void workersList(List<Employee> employeeList){	
		System.out.println("------------------------------------------------------------------");
		System.out.println("SUMMARY:");
		
		for(Employee emp : employeeList) {
			System.out.println(emp);
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Date           : " + sdf.format(getDate()));
		sb.append("\nBadge          : " + getIdBadge());
		sb.append("\nName           : " + getName());
		sb.append("\nCPF            : " + getCpf());
		sb.append("\nDepartment     : " + getDepartment());
			
		sb.append(extraHours);
		
		return sb.toString();
	}
}