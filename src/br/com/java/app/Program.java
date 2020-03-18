package br.com.java.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.java.entities.Employee;
import br.com.java.entities.ExtraHours;
import br.com.java.entities.PersonalAssistence;
import br.com.java.entities.RemoteAssistence;
import br.com.java.enums.Department;

public class Program {

	/**
	 * @LuanOliveira
	**/
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		List<Employee> employeeList = new ArrayList<>();

		Employee employee = new Employee();
		int n = 0;
		
		while(n == 0) {
			try {
				System.out.println("Calculate how many employee? ");
				n = sc.nextInt();
				
				if(n == 0) {
					System.out.println("Quantity must be greater than zero, try again.\n");
				}
			}catch(InputMismatchException e){
				System.out.println("Only allowed numbers of the whole type, try again.\n ");
			}
			sc.nextLine();
		}
		
		
		for (int i = 1; i <= n; i++) {
			try {
				System.out.println("Enter #" + i + " employee data:");
				System.out.print("Name: ");
				String name = sc.nextLine();

				System.out.print("CPF: ");
				String cpf = sc.nextLine();

				int idBadge = 0;
				while(idBadge == 0) {
					try {
						System.out.print("Badge: ");
						 idBadge = sc.nextInt();

					}catch(InputMismatchException e) {
						System.out.println("invalid entry, try again.\n ");
					}
					sc.nextLine();
				}

				double salary = 0;
				while(salary == 0) {
					try {
						System.out.print("Salary: ");
						salary = sc.nextDouble();

					}catch(InputMismatchException e) {
						System.out.println("invalid entry, try again.\n ");
					}
					sc.nextLine();
				}

				System.out.println();
				System.out.println("Enter department data: ");

				Department department = null;
				while(department == null) {
					try {
						System.out.print("Department: ");
						department = Department.valueOf(sc.nextLine());

					}catch(IllegalArgumentException e) {
						System.out.println("invalid entry, try again.\n ");
					}
				}

				System.out.println();
				System.out.println("Enter data for calculation: ");
				System.out.print("Hours performed (HH:mm): ");
				String hoursPerformed = sc.nextLine();

				double dsrPercentage = 0;
				while(dsrPercentage == 0) {
					try {
						System.out.print("current dsr percentage: ");
						dsrPercentage = sc.nextDouble();

					}catch(InputMismatchException e) {
						System.out.println("invalid entry, try again.\n ");
					}
					sc.nextLine();
				}

				System.out.println("Personal assistence(y/n)? ");
				char x = sc.next().charAt(0);

				if(x == 'y') {
					int travels = 0;
					while(travels == 0) {
						try {
							System.out.print("Travels: ");
							travels = sc.nextInt();	

						}catch(InputMismatchException e) {
							System.out.println("invalid entry, try again.\n ");
						}
						sc.nextLine();
					}

					ExtraHours personal = new PersonalAssistence(hoursPerformed, dsrPercentage, salary, travels);

					employee = new Employee(new Date(), name, idBadge, cpf, salary, department, personal);
				}else {
					ExtraHours remote = new RemoteAssistence(hoursPerformed, dsrPercentage, salary);

					employee = new Employee(new Date(), name, idBadge, cpf, salary, department, remote);
				}
				employeeList.add(employee);
				System.out.println();

				employee.workersList(employeeList);

				}catch(InputMismatchException e) {
					System.out.println("Entrada inválida, tente novamente.");
				}
			}
		sc.close();
	}
}
