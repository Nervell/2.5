package pro.sky.workbook.service;

import pro.sky.workbook.model.Employee;
import pro.sky.workbook.exception.EmployeeAlreadyAddedException;
import pro.sky.workbook.exception.EmployeeNotFoundException;
import pro.sky.workbook.exception.EmployeeStorageIsFullException;

import java.util.*;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service implements EmployeeSevice{
    private final Map<String, Employee > employees = new HashMap<>();


    @Override
    public Employee addEmployee(String firstName, String lastName, int department, int salary) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.containsKey(firstName + lastName)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(firstName + lastName, employee);
        return employee;
    }
    @Override
    public Employee removeEmployee(String firstName, String lastName, int department, int salary) throws EmployeeNotFoundException, EmployeeStorageIsFullException {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.containsKey(firstName + lastName)) {
            employees.remove(firstName + lastName);
            return employee;
        }

        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int department, int salary) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.containsKey(firstName + lastName)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Optional<Employee> findLowestSalaryInDep(int department) {
        return employees.values().stream()
                .filter(employee1 -> employee1.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary));
    }

    @Override
    public Optional<Employee> findHighestSalaryInDep(int department) {
        return employees.values().stream()
                .filter(employee1 -> employee1.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary));
    }

    @Override
    public List<Employee> printDepartment(int department) {
        return employees.values().stream()
                .filter(employee1 -> employee1.getDepartment() == department)
                .collect(Collectors.toList());
    }


    @Override
    public List<Employee> printDepartmentsInOrder() {
        return employees.values().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                .collect(Collectors.toList());
    }
    @Override
    public Collection<Employee> findAll() {
        //return Collections.unmodifiableList((List<? extends Employee>) employees);
        return Collections.unmodifiableCollection(employees.values());
    }
}
