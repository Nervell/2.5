package pro.sky.workbook;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final Service service;
    public EmployeeController(Service service) {
        this.service = service;
    }

    @ResponseStatus
    @GetMapping(path = "/add")
    public String add(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) {
        try {
            return String.valueOf(service.addEmployee(firstName, lastName));
        } catch (EmployeeAlreadyAddedException e) {
            return "Employee already added";
        } catch (EmployeeStorageIsFullException e) {
            return "There is no more places for new employee";
        }
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName) {
        try {
            return String.valueOf(service.removeEmployee(firstName, lastName));
        } catch (EmployeeNotFoundException e) {
            return "There is no employee with such name";
        }
    }

    @GetMapping(path = "/find")
    public String find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {
            return String.valueOf(service.findEmployee(firstName, lastName));
        } catch (EmployeeNotFoundException e) {
            return "There is no employee with such name";
        }
    }


}
