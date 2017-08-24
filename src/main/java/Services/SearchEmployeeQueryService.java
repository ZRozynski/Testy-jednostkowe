package Services;

import Classes.Employee;
import Classes.EmployeeDto;
import Interfaces.EmployeeRepository;
import org.apache.catalina.LifecycleState;
import org.apache.tomcat.jni.Local;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SearchEmployeeQueryService {
    private ArrayList<Employee> employees;

    public SearchEmployeeQueryService(EmployeeRepository employeeRepository) {
        this.employees = (ArrayList<Employee>)employeeRepository.findAll();
    }
    public List<EmployeeDto> findYoungestWorkers(){
        ArrayList<EmployeeDto> youngestEmployees = new ArrayList<>();
        for (Employee employee:
             this.employees) {
            if(this.IsWorkingLessThanAYear(employee.getStartDate()))
                youngestEmployees.add(this.ParseToDataTransferObject(employee));
        }
        return youngestEmployees;
    }
    private EmployeeDto ParseToDataTransferObject(Employee employee){
        String fullName = employee.getFirstName() + " " + employee.getLastName();
        BigDecimal employeeSalary = employee.getSalary();
        return new EmployeeDto(fullName,employeeSalary);
    }

    private boolean IsWorkingLessThanAYear(LocalDate employeeStartDate){
        return (LocalDate.now().getYear() - employeeStartDate.getYear()) < 1;
    }
}
