package com.employeemng.prj.service.impl;

import com.employeemng.prj.dto.EmployeeDto;
import com.employeemng.prj.entity.Employee;
import com.employeemng.prj.mapper.EmployeeMapper;
import com.employeemng.prj.repository.EmployeeRepository;
import com.employeemng.prj.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
