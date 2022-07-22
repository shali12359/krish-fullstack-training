import java.util.List;

import com.prabath.training.salesManager.model.Employee;
import com.prabath.training.salesManager.service.EmployeeImpl;
import com.prabath.training.salesManager.service.EmployeeService;

public class Application {
	
	public static void main(String[] args) {
		EmployeeService employeeservice = new EmployeeImpl();
		
		List<Employee> employees = employeeservice.getAllEmployees();
		
		for(Employee employee : employees) {
			System.out.print(employee.getEmployeeName() +" at "+ employee.getEmployeeLocation());
		}
	}
}
