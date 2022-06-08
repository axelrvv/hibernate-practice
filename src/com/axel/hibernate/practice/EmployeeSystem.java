package com.axel.hibernate.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import javax.persistence.Convert;

public class EmployeeSystem {

	public static void main(String[] args) {
		
		EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
		Scanner myObj = new Scanner(System.in);
		int opc = 0;
		
		do {
			System.out.println("Eliga una opcion. Presione 9 para salir");
			System.out.println("----------------------------------------\n");
			System.out.println("1. Crear nuevo empleado");
			System.out.println("2. Buscar todos los empleados");
			System.out.println("3. Buscar todos los empleados por empresa");
			System.out.println("4. Buscar empleado por Id");
			System.out.println("5. Actualizar nombre del empleado");
			System.out.println("6. Actualizar apellido del empleado");
			System.out.println("7. Actualizar empresa del empleado");
			System.out.println("8. Eliminar empleado");
			System.out.println("9. Salir");
			System.out.println("----------------------------------------\n");
			
			try {
				opc = Integer.parseInt(myObj.nextLine());
				
				if(opc >= 1 && opc <= 9) {
					
					switch (opc) {
					case 1:
						employeeServiceImpl.CreateEmployee();
						break;
					case 2:
						employeeServiceImpl.ListAllEmployees();
						break;
					case 3:
						employeeServiceImpl.ListAllEmployeesByCompany();
						break;
					case 4:
						employeeServiceImpl.GetEmployeeById();
						break;
					case 5:
						employeeServiceImpl.UpdateFirstname();
						break;
					case 6:
						employeeServiceImpl.UpdateLastname();
						break;
					case 7:
						employeeServiceImpl.UpdateCompany();
						break;
					case 8:
						employeeServiceImpl.DeleteEmployee();
						break;
					case 9:
						System.out.println("Gracias por usar nuestro servicio \n");
						break;
					default:
						break;
					}
					
				}else {
					System.out.println("Debes escribir una opcion valida o presione 8 para salir");
				}
				
			}catch(Exception e) {
				System.out.println("Debes escribir un digito");
			}
			
		} while (opc != 9);


	}
	
	

}
