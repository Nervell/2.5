package pro.sky.workbook.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.workbook.model.Employee;
import pro.sky.workbook.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService service;
    public EmployeeController(EmployeeService service) {
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

}
