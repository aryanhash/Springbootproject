package com.example._stproject.controllers;

import com.example._stproject.dto.EmployeeDto;
import com.example._stproject.services.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/{employeeId}")
    public EmployeeDto getEmployeeById(@PathVariable(name = "employeeId") Long id){
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees(@RequestParam(required = false, name = "inputAge")Integer age,
                                                @RequestParam(required = false)String sortBy){
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDto createNewEmployee(@RequestBody EmployeeDto inputEmployee){
        return employeeService.createNewEmployee(inputEmployee);
    }
    @PutMapping("/{employeeId}")
    public EmployeeDto updateEmployeeById(@RequestBody EmployeeDto employeeDto, @PathVariable(name = "employeeId") Long id){

        return employeeService.updateEmployeeById(employeeDto, id);
    }
    @DeleteMapping("/{employeeId}")
    public void deleteEmployeeById(@PathVariable(name = "employeeId") Long id){
        employeeService.deleteEmployeeById(id);
    }
}
