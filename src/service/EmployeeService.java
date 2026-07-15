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

    private void validateEmployeeExists(Employee employee)
            throws EmployeeException {

        if(employee == null) {
            throw new EmployeeException("Employee doesn't exist.");
        }
    }

    private void validateName(String name)
            throws EmployeeException {

        if(name.trim().isEmpty()) {
            throw new EmployeeException("Name cannot be empty.");
        }
    }

    private void validateAge(int age)
            throws EmployeeException {

        if(age < 18) {
            throw new EmployeeException("Employee must be atleast 18 years old.");
        }
    }

    private void validateSalary(double salary)
            throws EmployeeException {

        if(salary <= 0) {
            throw new EmployeeException("Salary must be greater than 0.");
        }
    }

    private void validateGender(String gender)
            throws EmployeeException {

        if(gender.trim().isEmpty()) {
            throw new EmployeeException("Gender cannot be empty.");
        }
    }

    private void validateEmail(String email)
            throws EmployeeException {

        if(email.trim().isEmpty()) {
            throw new EmployeeException("Email cannot be empty.");
        }
    }

    private void validatePhoneNumber(String phoneNumber)
            throws EmployeeException {

        if(phoneNumber.trim().isEmpty()) {
            throw new EmployeeException("Phone Number cannot be empty.");
        }
    }

    private void validateDepartment(String department)
            throws EmployeeException {

        if(department.trim().isEmpty()) {
            throw new EmployeeException("Department cannot be empty.");
        }
    }

    private void validateJobTitle(String jobTitle)
            throws EmployeeException {

        if(jobTitle.trim().isEmpty()) {
            throw new EmployeeException("Job Title cannot be empty.");
        }
    }

    private void validateExperience(int experience)
            throws EmployeeException {

        if(experience < 0) {
            throw new EmployeeException("Experience cannot be negative.");
        }
    }

    private void validateDateJoined(String dateJoined)
            throws EmployeeException {

        if(dateJoined.trim().isEmpty()) {
            throw new EmployeeException("Joining Date cannot be empty.");
        }
    }

    public void addEmployee(Employee employee) throws EmployeeException {
        if(repository.getEmployeeById(employee.getEmployeeId()) != null) {
            throw new EmployeeException("Employee ID already exists.");
        }

        validateSalary(employee.getSalary());
        validateAge(employee.getAge());
        validateName(employee.getName());
        
        repository.addEmployee(employee);
    }

    public ArrayList<Employee> getAllEmployees() {
        return repository.getAllEmployees();
    }

    public Employee getEmployeeById(int employeeId) throws EmployeeException {
        Employee employee = repository.getEmployeeById(employeeId);
        validateEmployeeExists(employee);
        return employee;
    }

    public void updateEmployeeName(Employee employee, String newName) throws EmployeeException {
        validateName(newName);
        employee.setName(newName);
        repository.save();
    }

    public void updateEmployeeAge(Employee employee, int newAge) throws EmployeeException {
        validateAge(newAge);
        employee.setAge(newAge);
        repository.save();
    }

    public void updateEmployeeGender(Employee employee, String newGender) throws EmployeeException {
        validateGender(newGender);
        employee.setGender(newGender);
        repository.save();
    }

    public void updateEmployeeEmail(Employee employee, String newEmail) throws EmployeeException {
        validateEmail(newEmail);
        employee.setEmail(newEmail);
        repository.save();
    }

    public void updateEmployeePhoneNumber(Employee employee, String newPhoneNumber) throws EmployeeException {
        validatePhoneNumber(newPhoneNumber);
        employee.setPhoneNumber(newPhoneNumber);
        repository.save();
    }

    public void updateEmployeeDepartment(Employee employee, String newDepartment) throws EmployeeException {
        validateDepartment(newDepartment);
        employee.setDepartment(newDepartment);
        repository.save();
    }

    public void updateEmployeeJobTitle(Employee employee, String newJobTitle) throws EmployeeException {
        validateJobTitle(newJobTitle);
        employee.setJobTitle(newJobTitle);
        repository.save();
    }

    public void updateEmployeeSalary(Employee employee, double newSalary) throws EmployeeException {
        validateSalary(newSalary);
        employee.setSalary(newSalary);
        repository.save();
    }

    public void updateEmployeeExperience(Employee employee, int newExperience) throws EmployeeException {
        validateExperience(newExperience);
        employee.setExperience(newExperience);
        repository.save();
    }

    public void updateEmployeeDateJoined(Employee employee, String newDateJoined) throws EmployeeException {
        validateDateJoined(newDateJoined);
        employee.setDateJoined(newDateJoined);
        repository.save();
    }

    public void deleteEmployee(int employeeId) throws EmployeeException {
        Employee employee = getEmployeeById(employeeId);
        repository.removeEmployee(employee);
    }
}
