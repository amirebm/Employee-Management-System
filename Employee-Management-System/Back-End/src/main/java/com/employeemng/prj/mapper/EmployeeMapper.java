    package com.employeemng.prj.mapper;

    import com.employeemng.prj.dto.EmployeeDto;
    import com.employeemng.prj.entity.Employee;

    public class EmployeeMapper {
        public  static EmployeeDto mapToEmployeeDto(Employee employee)
        {
            return new EmployeeDto(
                    employee.getId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getEmail()
            );

        }

//        public static Employee mapToEmployee(EmployeeDto employeeDto){
//            return new Employee(
//                    employeeDto.getId(),
//                    employeeDto.getFirstname(),
//                    employeeDto.getLastname(),
//                    employeeDto.getEmail()
//            );
//        }

        public static Employee mapToEmployee(EmployeeDto employeeDto) {
            Employee employee = new Employee();
//            if (employeeDto.getId() != null) {
//                employee.setId(employeeDto.getId());
//            }
            employee.setFirstName(employeeDto.getFirstName());
            employee.setLastName(employeeDto.getLastName());
            employee.setEmail(employeeDto.getEmail());
            return employee;
        }

    }
