package pro.sky.workbook.service;

import pro.sky.workbook.model.Employee;
import pro.sky.workbook.exception.EmployeeAlreadyAddedException;
import pro.sky.workbook.exception.EmployeeNotFoundException;
import pro.sky.workbook.exception.EmployeeStorageIsFullException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@org.springframework.stereotype.Service
public class Service implements EmployeeSevice{
    private final List<Employee> employees;

    public Service(List<Employee> employees) {
        this.employees = employees;
    }
    @Override
    public Employee addEmployee(String firstName, String lastName) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }
    @Override
    public Employee removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException, EmployeeStorageIsFullException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }

        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(new Employee(firstName, lastName))) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }
    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employees);
    }
}
