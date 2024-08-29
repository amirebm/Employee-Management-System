import React, { useEffect, useState } from "react";
import { listEmployees } from "../services/EmployeeService";
import { useNavigate } from "react-router-dom";
const ListEmployeeComponent = () => {
  const [employee, setEmployee] = useState([]);
  const navigator = useNavigate();
  useEffect(() => {
    listEmployees()
      .then((response) => {
        setEmployee(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  function addNewEmployee() {
    navigator("/add-employee");
  }
  //function ListEmployeeComponent() {
  // const DumyData = [
  //   {
  //     id: 1,
  //     firstName: "ali",
  //     lastName: "alavi",
  //     email: "a@a.com",
  //   },
  //   {
  //     id: 2,
  //     firstName: "alii",
  //     lastName: "alavii",
  //     email: "ai@ai.com",
  //   },
  //   {
  //     id: 3,
  //     firstName: "alis",
  //     lastName: "alavis",
  //     email: "as@as.com",
  //   },
  // ];

  return (
    <div className="container text-center">
      <h2>ListEmployeeComponent</h2>
      <button className="btn btn-primary mb-2" onClick={addNewEmployee}>
        Add Employee
      </button>
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Employee ID</th>
            <th>Employee First Name</th>
            <th>Employee Last Name</th>
            <th>Employee Email</th>
          </tr>
        </thead>
        <tbody>
          {employee.map((employee) => (
            <tr key={employee.id}>
              <td>{employee.id}</td>
              <td>{employee.firstName}</td>
              <td>{employee.lastName}</td>
              <td>{employee.email}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListEmployeeComponent;
