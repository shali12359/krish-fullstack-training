import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.prabath.training.salesManager.config.ApplicationConfiguration;
import com.prabath.training.salesManager.model.Employee;
import com.prabath.training.salesManager.service.EmployeeService;

public class Application {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		EmployeeService employeeService = applicationContext.getBean("employeeService",EmployeeService.class);
		
		System.out.println(employeeService.toString());
		
		EmployeeService employeeService2 = applicationContext.getBean("employeeService",EmployeeService.class);
		
		System.out.println(employeeService2.toString());
		
		List<Employee> employees = employeeService.getAllEmployees();
		
		for(Employee employee : employees) {
			System.out.print(employee.getEmployeeName() +" at "+ employee.getEmployeeLocation());
		}
	}

} 
