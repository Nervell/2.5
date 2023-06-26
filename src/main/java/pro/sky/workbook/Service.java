package pro.sky.workbook;

import java.util.ArrayList;

@org.springframework.stereotype.Service
public class Service {
    public ArrayList<Employee> employees = new ArrayList<>();
    static final int constant = 10;
    static int counter = 0;
    public ArrayList<Employee> addEmployee(String firstName, String lastName) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        for (Employee employee : employees) {
            if (employee.equals(new Employee(firstName, lastName))) {
                throw new EmployeeAlreadyAddedException();
            }
        }
        if (counter > constant) {
            throw new EmployeeStorageIsFullException();
        }
        employees.add(new Employee(firstName, lastName));
        counter++;
        return employees;
    }

    public ArrayList<Employee> removeEmployee(String firstName, String lastName) throws EmployeeNotFoundException, EmployeeStorageIsFullException {
        if (!employees.contains(new Employee(firstName, lastName))) {
            throw new EmployeeNotFoundException();
        }

        for (Employee employee : employees) {
            if (employee.equals(new Employee(firstName, lastName))) {
                employees.remove(employee);
                counter++;
                break;
            }
        }
        return employees;
    }

    public Employee findEmployee(String firstName, String lastName) throws EmployeeNotFoundException {
        if (!employees.contains(new Employee(firstName, lastName))) {
            throw new EmployeeNotFoundException();
        }
        return new Employee(firstName, lastName);
    }
}
