package com.employeemng.prj.controller;

import com.employeemng.prj.dto.EmployeeDto;
import com.employeemng.prj.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    



    //Build Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
        return  new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build Get Employee Rest API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeId(@PathVariable("id") Long EmployeeId){
        EmployeeDto employeeDto=employeeService.getEmployeeById(EmployeeId);
        return ResponseEntity.ok(employeeDto);
    }


    //Build Get All Employees Rest API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees= employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //Build update Employee Rest API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId,updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }
    //Build delete Employee Rest API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
    employeeService.deleteEmployee(employeeId);
    return ResponseEntity.ok("Employee deleted successfully");
    }

}
