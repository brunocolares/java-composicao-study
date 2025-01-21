package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel workerLevel;
	private Double baseSalary;
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();

	private Worker() {
		
	}

	public Worker(String name, WorkerLevel workerLevel, Double baseSalary, Department department) {
		this.name = name;
		this.workerLevel = workerLevel;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getWorkerLevel() {
		return workerLevel;
	}

	public void setWorkerLevel(WorkerLevel workerLevel) {
		this.workerLevel = workerLevel;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	
	public void addContract(HourContract hourContract) {
		this.contracts.add(hourContract);
	}
	
	public void removeContract(HourContract hourContract) {
		this.contracts.remove(hourContract);
	}
	
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for(HourContract hourContract : contracts) {
			cal.setTime(hourContract.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if(c_year == year && c_month == month) {
				sum += hourContract.totalValue();
			}
		}
		return sum;
	}
}
