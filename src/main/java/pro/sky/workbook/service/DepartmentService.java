package pro.sky.workbook.service;

import org.springframework.stereotype.Service;
import pro.sky.workbook.model.Employee;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class DepartmentService implements DepartmentInterface {

    private EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //    private final Map<String, Employee > employees = new HashMap<>(employeeService.getEmployees());

    @Override
    public Optional<Employee> findLowestSalaryInDep(int department) {
        return employeeService.getEmployees().values().stream()
                .filter(employee1 -> employee1.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary));
    }

    @Override
    public Optional<Employee> findHighestSalaryInDep(int department) {
        return employeeService.getEmployees().values().stream()
                .filter(employee1 -> employee1.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary));
    }

    @Override
    public List<Employee> printDepartment(int department) {
        return employeeService.getEmployees().values().stream()
                .filter(employee1 -> employee1.getDepartment() == department)
                .collect(Collectors.toList());
    }


    @Override
    public List<Employee> printDepartmentsInOrder() {
        return employeeService.getEmployees().values().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                .collect(Collectors.toList());
    }
}
