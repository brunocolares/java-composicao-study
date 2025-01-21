package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
				
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		Double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, 
				WorkerLevel.valueOf(workerLevel), 
				baseSalary, 
				new Department(departmentName));
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		
		
		for(int i = 1; i <= n; i++) {
			System.out.printf("Enter contract #%d data: %n", n);
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHourContract = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hoursContracts = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHourContract, hoursContracts);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income(YY/YYYY): ");
		String monthAndYear = sc.next();
		
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		double income = worker.income(year, month);
		
		System.out.println("Name: "+worker.getName());
		System.out.println("Deparment: "+worker.getDepartment().getName());
		System.out.println("Income for "+ monthAndYear+": "+String.format("%.2f", income));
		
		
		sc.close();
	}
}
