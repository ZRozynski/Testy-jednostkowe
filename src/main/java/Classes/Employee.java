package Classes;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private LocalDate startDate;

    public Employee(String firstName, String lastName, BigDecimal salary, LocalDate startDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.startDate = startDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
