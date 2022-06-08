package com.axel.hibernate.practice;

import java.util.List;
import java.util.Scanner;
import com.axel.hibernate.practice.EmployeeService;
import com.axel.hibernate.practice.entity.Employee;

public class EmployeeServiceImpl {

	public void CreateEmployee() {
		
		Employee employee = new Employee();
		EmployeeService employeeService = new EmployeeService();
		Scanner myObj = new Scanner(System.in);
		
		System.out.println("Escriba el primer nombre del empleado que desea crear \n");
		try {
			employee.setFirstname(myObj.nextLine());
		}catch(Exception e) {
			
			System.out.println("Escriba un nombre valido\n");
			
		}
		
		System.out.println("Escriba el primer apellido del empleado que desea crear\n");
		try {
			employee.setLastname(myObj.nextLine());
		}catch(Exception e) {
			
			System.out.println("Escriba un apellido valido\n");
			
		}
		
		System.out.println("Escriba el nombre de la empresa a que pertenece\n");
		try {
			employee.setCompany(myObj.nextLine());
		}catch(Exception e) {
			
			System.out.println("Escriba un nombre valido\n");
			
		}
		
		try {
			
			employeeService.createEmployee(employee);
			System.out.println("Empleado creado exitosamente!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void ListAllEmployees() {
		
		EmployeeService employeeService = new EmployeeService();
		
		try {
			
			List<Employee> employees = employeeService.getAllEmployees();
			
			if(employees.isEmpty()) {
				
				System.out.println("La consulta no arrojo resultados");
				
			}else {
				
				System.out.println("Resultado: \n");
				ListEmployees(employees);
				
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
public void ListAllEmployeesByCompany() {
		
		EmployeeService employeeService = new EmployeeService();
		String company = null;
		Scanner myObj = new Scanner(System.in);
		
		System.out.println("Escriba el nombre de la empresa a consultar \n");
		try {
			company = myObj.nextLine();
		}catch(Exception e) {
			
			System.out.println("Escriba un nombre valido\n");
			
		}
		
		try {
			
			List<Employee> employees = employeeService.getAllEmployeesByCompany(company);
			
			if(employees.isEmpty()) {
				
				System.out.println("La consulta no arrojo resultados");
				
			}else {
				System.out.println("Resultado: \n");
				ListEmployees(employees);
				
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

	public void GetEmployeeById() {
		
		EmployeeService employeeService = new EmployeeService();
		Employee employee = null;
		Scanner myObj = new Scanner(System.in);
		int Id = 0;
		System.out.println("Escriba el Id del empleado que desea buscar");
		
		
		try {
			Id = Integer.parseInt(myObj.nextLine());
			employee = employeeService.getEmployeeById(Id);

		}catch(Exception e) {
			
			System.out.println("El Id no existe o es invalido");
		}
		
		System.out.println("Resultado: \n");
		System.out.println("|------------------------------------------------|");
		System.out.println("|   Id   |   Nombre   |   Apellido   |   Empresa   |");
		System.out.println("|   "+employee.getId()+"   |   "+employee.getFirstname()+"   |   "+employee.getLastname()+"   |   "+employee.getCompany()+"   |");
		System.out.println("|------------------------------------------------|\n");
		
	}
	
	public void UpdateFirstname() {
		
		EmployeeService employeeService = new EmployeeService();
		Employee employee = null;
		Scanner myObj = new Scanner(System.in);
		int Id = 0;
		String firstname = "";
		System.out.println("Escriba el Id del empleado que desea buscar");
		
		
		try {
			Id = Integer.parseInt(myObj.nextLine());
			employee = employeeService.getEmployeeById(Id);

		}catch(Exception e) {
			System.out.println("El Id no existe o es invalido");
		}
		
		System.out.println("Escriba el nuevo nombre del empleado");
		
		try {
			firstname = myObj.nextLine();
			
			employeeService.updateEmployeeFirstname(Id, firstname);
			System.out.println(employee.getFirstname()+" "+employee.getLastname()+ ": Ha sido actualizado");
			System.out.println(employee.getFirstname()+" ha sido actualizado a: "+ firstname+"\n");

		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void UpdateLastname() {
			
			EmployeeService employeeService = new EmployeeService();
			Employee employee = null;
			Scanner myObj = new Scanner(System.in);
			int Id = 0;
			String lastname = "";
			System.out.println("Escriba el Id del empleado que desea buscar");
			
			
			try {
				Id = Integer.parseInt(myObj.nextLine());
				employee = employeeService.getEmployeeById(Id);
	
			}catch(Exception e) {
				System.out.println("El Id no existe o es invalido");
			}
			
			System.out.println("Escriba el nuevo apellido del empleado");
			
			try {
				lastname = myObj.nextLine();
				
				employeeService.updateEmployeeLastname(Id, lastname);;
				System.out.println(employee.getFirstname()+" "+employee.getLastname()+ ": Ha sido actualizado");
				System.out.println(employee.getLastname()+" ha sido actualizado a: "+ lastname+"\n");
	
			}catch(Exception e) {
				
				e.printStackTrace();
			}
			
		}

	public void UpdateCompany() {
			
			EmployeeService employeeService = new EmployeeService();
			Employee employee = null;
			Scanner myObj = new Scanner(System.in);
			int Id = 0;
			String company = "";
			System.out.println("Escriba el Id del empleado que desea buscar");
			
			
			try {
				Id = Integer.parseInt(myObj.nextLine());
				employee = employeeService.getEmployeeById(Id);
	
			}catch(Exception e) {
				System.out.println("El Id no existe o es invalido");
			}
			
			System.out.println("Escriba el nuevo nombre de la empresa del empleado");
			
			try {
				company = myObj.nextLine();
				
				employeeService.updateEmployeeCompany(Id, company);
				System.out.println(employee.getCompany()+" ha sido actualizado en el empleado: "+ employee.getFirstname()+" "+employee.getLastname());
				System.out.println(employee.getCompany()+" ha sido actualizado a: "+company+"\n");
	
			}catch(Exception e) {
				
				e.printStackTrace();
			}
			
		}
	
	public void DeleteEmployee() {
		
		EmployeeService employeeService = new EmployeeService();
		Scanner myObj = new Scanner(System.in);
		Employee employee = null;
		int Id = 0;
		System.out.println("Escriba el Id del empleado a eliminar");
		
		try {
			Id = Integer.parseInt(myObj.nextLine());
			employee = employeeService.getEmployeeById(Id);
			
		}catch(Exception e) {
			
			System.out.println("El Id no existe o es invalido");
		}
		
		try {
			
			employeeService.deleteEmployee(Id);
			System.out.println(employee.getFirstname()+" "+employee.getLastname()+" ha sido eliminado");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private void ListEmployees(List<Employee> employees) {
		System.out.println("|------------------------------------------------|");
		System.out.println("|   Id   |   Nombre   |   Apellido   |   Empresa   |");
		for (Employee employee : employees) {
			System.out.println("|   "+employee.getId()+"   |   "+employee.getFirstname()+"   |   "+employee.getLastname()+"   |   "+employee.getCompany()+"   |");
		}
		System.out.println("|------------------------------------------------|\n");
	}
	
}
