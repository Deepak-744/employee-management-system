package service;

import model.Employee;
import repository.EmployeeRepository;
import exception.EmployeeException;

import java.util.ArrayList;

public class EmployeeService {

    private EmployeeRepository repository;

    public EmployeeService() {
        repository = new EmployeeRepository();
    }

    public void addEmployee(Employee employee) throws EmployeeException {
        if(repository.getEmployeeById(employee.getEmployeeId()) != null) {
            throw new EmployeeException("Employee ID already exists.");
        }

        if(employee.getSalary() <= 0) {
            throw new EmployeeException("Salary must be greater than 0.");
        }

        if(employee.getAge() < 18) {
            throw new EmployeeException("Employee must be atleast 18 years old.");
        }

        if(employee.getName().trim().isEmpty()) {
            throw new EmployeeException("Name cannot be empty.");
        }
        
        repository.addEmployee(employee);
    }

    public ArrayList<Employee> getAllEmployees() {
        return repository.getAllEmployees();
    }

    public Employee getEmployeeById(int employeeId) throws EmployeeException {
        Employee employee = repository.getEmployeeById(employeeId);

        if(employee == null)
            throw new EmployeeException("Employee doesn't exist");

        return employee;
    }

    public void updateEmployeeName(Employee employee, String newName) throws EmployeeException {
        if(newName.trim().isEmpty()) {
            throw new EmployeeException("Name cannot be empty.");
        }
       employee.setName(newName);
    }

    public void updateEmployeeAge(Employee employee, int newAge) throws EmployeeException {
        if(newAge < 18) {
            throw new EmployeeException("Employee must be atleast 18 years old.");
        }

        employee.setAge(newAge);
    }

    public void updateEmployeeGender(Employee employee, String newGender) throws EmployeeException {
        if(newGender.trim().isEmpty())
            throw new EmployeeException("Gender cannot be empty");

        employee.setGender(newGender);
    }

    public void updateEmployeeEmail(Employee employee, String newEmail) throws EmployeeException {
        if(newEmail.trim().isEmpty())
            throw new EmployeeException("Email cannot be empty");

        employee.setEmail(newEmail);
    }

    public void updateEmployeePhoneNumber(Employee employee, String newPhoneNumber) throws EmployeeException {
        if(newPhoneNumber.trim().isEmpty())
            throw new EmployeeException("PhoneNumber cannot be empty");

        employee.setPhoneNumber(newPhoneNumber);
    }

    public void updateEmployeeDepartment(Employee employee, String newDepartment) throws EmployeeException {
        if(newDepartment.trim().isEmpty())
            throw new EmployeeException("Department cannot be empty");

        employee.setDepartment(newDepartment);
    }

    public void updateEmployeeJobTitle(Employee employee, String newJobTitle) throws EmployeeException {
        if(newJobTitle.trim().isEmpty())
            throw new EmployeeException("JobTitle cannot be empty");

        employee.setJobTitle(newJobTitle);
    }

    public void updateEmployeeSalary(Employee employee, double newSalary) throws EmployeeException {
        if(newSalary<=0) {
            throw new EmployeeException("Salary must be greater than 0.");
        }

        employee.setSalary(newSalary);
    }

    public void updateEmployeeExperience(Employee employee, int newExperience) throws EmployeeException {
        if(newExperience < 0)
            throw new EmployeeException("Experience cannot be negative");

        employee.setExperience(newExperience);
    }

    public void updateEmployeeDateJoined(Employee employee, String newDateJoined) throws EmployeeException {
        if(newDateJoined.trim().isEmpty())
            throw new EmployeeException("Joining Date cannot be empty");

        employee.setDateJoined(newDateJoined);
    }

    public void deleteEmployee(int employeeId) throws EmployeeException {
        Employee employee = getEmployeeById(employeeId);
        repository.removeEmployee(employee);
    }
}
