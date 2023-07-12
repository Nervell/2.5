package pro.sky.workbook.service;

import pro.sky.workbook.exception.EmployeeAlreadyAddedException;
import pro.sky.workbook.exception.EmployeeNotFoundException;
import pro.sky.workbook.exception.EmployeeStorageIsFullException;
import pro.sky.workbook.model.Employee;

import java.util.Collection;

public interface EmployeeInterface {

    Employee addEmployee(String firstName, String lastName, int department, int salary) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException;

    Employee removeEmployee(String firstName, String lastName, int department, int salary) throws EmployeeNotFoundException, EmployeeStorageIsFullException;

    Employee findEmployee(String firstName, String lastName, int department, int salary);
    Collection<Employee> findAll();
}
