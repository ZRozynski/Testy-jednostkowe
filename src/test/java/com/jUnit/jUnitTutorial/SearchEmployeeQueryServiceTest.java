package com.jUnit.jUnitTutorial;

import Classes.Employee;
import Classes.EmployeeDto;
import Interfaces.EmployeeRepository;
import Services.SearchEmployeeQueryService;
import junit.framework.TestCase;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SearchEmployeeQueryServiceTest {

    @Test
    public void should_return_info_about_the_youngest_workers() throws Exception{

        //given
        EmployeeRepository employeeRepository = new EmployeeRepository() {
            @Override
            public List<Employee> findAll() {
                ArrayList<Employee> employees = new ArrayList<>();
                employees.add(new Employee("Tytus", "Dezoo", BigDecimal.valueOf(11000.00), LocalDate.parse("2010-01-13")));
                employees.add(new Employee("Romek", "Nowak", BigDecimal.valueOf(12000.00), LocalDate.parse("2009-01-03")));
                employees.add(new Employee("Atomek", "Michalski", BigDecimal.valueOf(14000.00), LocalDate.parse("2017-02-15")));
                return employees;
            }
        };
        SearchEmployeeQueryService searchEmployeeQueryService = new SearchEmployeeQueryService(employeeRepository);

        //when
        List<EmployeeDto> youngestWorkers = searchEmployeeQueryService.findYoungestWorkers();

        //then
        Assertions.assertThat(youngestWorkers)
                .first()
                .isEqualTo(new EmployeeDto("Atomek Michalski", BigDecimal.valueOf(14000.00)));
    }
}
