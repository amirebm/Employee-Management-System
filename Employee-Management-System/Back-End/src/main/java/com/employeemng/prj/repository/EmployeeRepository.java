package com.employeemng.prj.repository;

import com.employeemng.prj.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
//We have created the EmployeeRepository interface that extends JpaRepository interface,
// so this EmployeeRepository will get CRUD methods to perform CRUD database operations on Employee JPA entity.
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
