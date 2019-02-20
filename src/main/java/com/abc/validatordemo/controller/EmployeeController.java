package com.abc.validatordemo.controller;

import com.abc.validatordemo.entity.Employee;
import com.abc.validatordemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/test", produces = MediaType.TEXT_PLAIN_VALUE)
    public String testApi() {
        return "Hola!";
    }

    @PostMapping(value = {"/", ""}, produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employee createEmployeeRecord(@RequestBody Employee employee) {
        return employeeService.createEmployeeRecord(employee);
    }


}
