package pro.sky.workbook.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.workbook.model.Employee;
import pro.sky.workbook.service.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = {"/employee", "/departments"})
public class EmployeeController {
    private final Service service;
    public EmployeeController(Service service) {
        this.service = service;
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName,
                        @RequestParam("department") int department,
                        @RequestParam("salary") int salary) {
        return service.addEmployee(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("department") int department,
                           @RequestParam("salary") int salary) {
        return service.removeEmployee(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName,
                         @RequestParam("department") int department,
                         @RequestParam("salary") int salary) {
        return service.findEmployee(firstName, lastName, department, salary);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return service.findAll();
    }

    @GetMapping(path = "/min-salary")
    public Optional<Employee> minSalary(@RequestParam("departmentId") int id) {
        return service.findLowestSalaryInDep(id);
    }

    @GetMapping(path = "/max-salary")
    public Optional<Employee> maxSalary(@RequestParam("departmentId") int id) {
        return service.findHighestSalaryInDep(id);
    }

    @GetMapping(path = "/all")
    public List<Employee> printDep(@RequestParam("departmentId") int id) {
        return service.printDepartment(id);
    }

    @GetMapping(path = "/allDep")
    public List<Employee> printDepsInOrder() {
        return service.printDepartmentsInOrder();
    }

}
