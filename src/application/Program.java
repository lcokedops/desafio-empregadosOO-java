package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome do departamento: ");
		String department = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Telefone: ");
		int phone = sc.nextInt();
		
		Department dept = new Department(department, payDay, new Address(email, phone));

		System.out.print("Quantos funcionários tem o departamento? ");
		int n = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.printf("Dados do funcionário %d:%n", i+1);
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salário: ");
			double salary = sc.nextDouble();
			dept.addEmployee(new Employee(name, salary));
		}
		
		showReport(dept);
		
		sc.close();
		
	}
	
	private static void showReport(Department dept) {
		System.out.printf("FOLHA DE PAGAMENTO:%nDepartamento %s = R$ %.2f%nPagamento realizado no dia %d%nFuncionários:%n", dept.getName(), dept.payroll(), dept.getPayDay());
		for (Employee e : dept.getEmployees()) {
			System.out.println(e.getName());
		}
		System.out.printf("Para dúvidas favor entrar em contato: %s", dept.getAddress().getEmail());
	}

}
