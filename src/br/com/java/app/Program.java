package br.com.java.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.java.entities.Employee;
import br.com.java.entities.ExtraHours;
import br.com.java.entities.PersonalAssistence;
import br.com.java.entities.RemoteAssistence;
import br.com.java.enums.Department;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		List<Employee> employeeList = new ArrayList<>();

		Employee employee;
		
		System.out.println("Calculate how many employee? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " employee data:");
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();

			System.out.print("CPF: ");
			String cpf = sc.nextLine();

			System.out.print("Badge: ");
			int idBadge = sc.nextInt();

			System.out.print("Salary: ");
			double salary = sc.nextDouble();

			System.out.println();
			System.out.println("Enter department data: ");
			System.out.print("Department: ");
			sc.nextLine();
			Department department = Department.valueOf(sc.nextLine());

			System.out.println();
			System.out.println("Enter data for calculation: ");
			System.out.print("Hours performed (HH:mm): ");
			String hoursPerformed = sc.nextLine();
			
			System.out.print("current dsr percentage: ");
			double dsrPercentage = sc.nextDouble();
		
			System.out.println("Personal assistence(y/n)? ");
			char x = sc.next().charAt(0);
		
			if(x == 'y') {
				System.out.print("Travels: ");
				int travels = sc.nextInt();

				ExtraHours personal = new PersonalAssistence(hoursPerformed, dsrPercentage, salary, travels);
				
				employee = new Employee(new Date(), name, idBadge, cpf, salary, department, personal);
			}else {
				ExtraHours remote = new RemoteAssistence(hoursPerformed, dsrPercentage, salary);

				employee = new Employee(new Date(), name, idBadge, cpf, salary, department, remote);
			}
			employeeList.add(employee);
			System.out.println();
		}
		System.out.println("------------------------------------------------------------------");
		System.out.println("SUMMARY:");
		
		for(Employee emp : employeeList) {
			System.out.println(emp);
		}
		
		sc.close();
	}
}