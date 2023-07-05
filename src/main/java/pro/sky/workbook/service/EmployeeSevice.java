package pro.sky.workbook.service;

import pro.sky.workbook.model.Employee;

import java.util.Map;

public interface EmployeeSevice {
    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);

    Map<String, Employee> findAll();
}
