package repository;

import model.Employee;
import java.util.ArrayList;

public class EmployeeRepository {
    private ArrayList<Employee> employees;

    public EmployeeRepository() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee getEmployeeById(int employeeId) {
        for(Employee employee : employees)
        {
            if(employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }
        return null;
    }

    public ArrayList<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    /*public boolean updateEmployee(Employee employee) {
        return;
    }
    
    public boolean removeEmployee(int employeeId) {
        return;
    }*/

}