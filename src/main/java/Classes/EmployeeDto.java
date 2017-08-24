package Classes;

import lombok.Value;

import java.math.BigDecimal;

public class EmployeeDto {
    private String fullName;
    private BigDecimal salary;

    public EmployeeDto(String fullName, BigDecimal salary) {
        this.fullName = fullName;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "fullName='" + fullName + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        EmployeeDto employeeDto = (EmployeeDto)obj;
        return employeeDto.getFullName().equals(this.getFullName()) && employeeDto.salary.equals(this.getSalary());
    }
}
