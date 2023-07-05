package pro.sky.workbook.service;

import pro.sky.workbook.model.Employee;
import pro.sky.workbook.exception.EmployeeAlreadyAddedException;
import pro.sky.workbook.exception.EmployeeNotFoundException;
import pro.sky.workbook.exception.EmployeeStorageIsFullException;

import java.util.*;

@org.springframework.stereotype.Service
public class Service implements EmployeeSevice{
    private final Map<String, Employee > employees = new HashMap<>();


    @Override
    public Employee addEmployee(String firstName, String lastName) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsValue(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(firstName + lastName, employee);
        return employee;
    }
    @Override
    public Employee removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException, EmployeeStorageIsFullException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsValue(employee)) {
            employees.remove(employee);
            return employee;
        }

        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsValue(new Employee(firstName, lastName))) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }
    @Override
    public Map<String, Employee> findAll() {
        //return Collections.unmodifiableList((List<? extends Employee>) employees);
        return employees;
    }
}
