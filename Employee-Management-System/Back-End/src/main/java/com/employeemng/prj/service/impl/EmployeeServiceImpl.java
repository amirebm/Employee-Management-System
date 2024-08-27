package com.employeemng.prj.service.impl;

import com.employeemng.prj.dto.EmployeeDto;
import com.employeemng.prj.entity.Employee;
import com.employeemng.prj.exception.ResourceNotFoundException;
import com.employeemng.prj.mapper.EmployeeMapper;
import com.employeemng.prj.repository.EmployeeRepository;
import com.employeemng.prj.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto){
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee= employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee= employeeRepository.findById(employeeId)
                .orElseThrow(()->
                            new ResourceNotFoundException("Employee is not exists with this ID"+ employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee>employees=employeeRepository.findAll();

      //  return employees.stream().map((employee -> EmployeeMapper.mapToEmployeeDto(employee)));
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto) // Employee -> EmployeeDto
                .collect(Collectors.toList()); // Collect the stream into a List<EmployeeDto>
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee is not exist with the given Id: "+ employeeId));

        employee.setFirstName(updatedEmployee.getFirstname());
        employee.setLastName(updatedEmployee.getLastname());
        employee.setEmail(updatedEmployee.getEmail());
        Employee updatedEmployeeObj= employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee is not exist with the given Id: "+ employeeId));
        employeeRepository.deleteById(employeeId);
    }
}
