package pro.sky.workbook.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.workbook.model.Employee;
import pro.sky.workbook.service.Service;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final Service service;
    public EmployeeController(Service service) {
        this.service = service;
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName) {
        return service.addEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName) {
        return service.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return service.findEmployee(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return service.findAll();
    }
}
