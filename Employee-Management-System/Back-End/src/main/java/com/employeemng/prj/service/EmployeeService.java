package com.employeemng.prj.service;

import com.employeemng.prj.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
}
