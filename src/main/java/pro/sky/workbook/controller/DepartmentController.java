package pro.sky.workbook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.workbook.model.Employee;
import pro.sky.workbook.service.DepartmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/min-salary")
    public Optional<Employee> minSalary(@RequestParam("departmentId") int id) {
        return departmentService.findLowestSalaryInDep(id);
    }

    @GetMapping(path = "/max-salary")
    public Optional<Employee> maxSalary(@RequestParam("departmentId") int id) {
        return departmentService.findHighestSalaryInDep(id);
    }

    @GetMapping(path = "/all")
    public List<Employee> printDep(@RequestParam("departmentId") int id) {
        return departmentService.printDepartment(id);
    }

    @GetMapping(path = "/allDep")
    public List<Employee> printDepsInOrder() {
        return departmentService.printDepartmentsInOrder();
    }
}
