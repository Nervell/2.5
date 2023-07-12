package pro.sky.workbook.service;

import pro.sky.workbook.model.Employee;

import java.util.List;
import java.util.Optional;

public interface DepartmentInterface {
    Optional<Employee> findLowestSalaryInDep(int department);

    Optional<Employee> findHighestSalaryInDep(int department);

    List<Employee> printDepartment(int department);

    List<Employee> printDepartmentsInOrder();
}
