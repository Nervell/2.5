package pro.sky.workbook.service;

import pro.sky.workbook.model.Employee;
import pro.sky.workbook.exception.EmployeeAlreadyAddedException;
import pro.sky.workbook.exception.EmployeeNotFoundException;
import pro.sky.workbook.exception.EmployeeStorageIsFullException;

import java.util.*;

@org.springframework.stereotype.Service
public class EmployeeService implements EmployeeInterface {
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
    public Collection<Employee> findAll() {
        //return Collections.unmodifiableList((List<? extends Employee>) employees);
        return Collections.unmodifiableCollection(employees.values());
    }

    public Map<String, Employee> getEmployees() {
        return employees;
    }
}
