package service;

import model.Employee;
import repository.EmployeeRepository;
import exception.*;
import enums.Gender;

import java.util.ArrayList;
import java.time.LocalDate;
import java.sql.SQLException;

public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService() {
        repository = new EmployeeRepository();
    }


/*  =====================>          VALIDATION METHODS        <===========================              */


    // EmployeeId validation

    private void validateEmployeeExists(Employee employee)
            throws EmployeeException {

        if(employee == null) {
            throw new EmployeeNotFoundException("Employee doesn't exist.");
        }
    }

    // Employee Name Validation

    private void validateName(String name)
            throws EmployeeException {

        if (name == null || name.trim().isEmpty()) {
            throw new InvalidNameException("Name cannot be empty.");
        }

        if (!name.matches("[A-Za-z ]+")) {
            throw new InvalidNameException("Name should contain only alphabets.");
        }
    }

    // Employee Age Validation

    private void validateAge(int age)
            throws EmployeeException {

        if(age < 18 || age > 65) {
            throw new InvalidAgeException("Employee must be atleast 18 years old.");
        }
    }

    // Employee Salary Validation

    private void validateSalary(double salary)
            throws EmployeeException {

        if(salary <= 0) {
            throw new InvalidSalaryException("Salary must be greater than 0.");
        }

        if (salary > 10000000) {
            throw new InvalidSalaryException("Salary is unrealistic.");
        }
    }

    // Employee Gender Validation

    private void validateGender(Gender gender)
            throws EmployeeException {

        if(gender == null) {
            throw new EmployeeException("Gender cannot be null.");
        }
    }

    // Employee Email Validation

    private void validateEmail(String email)
            throws EmployeeException {

        if (email == null || email.trim().isEmpty()) {
            throw new EmployeeException("Email cannot be empty.");
        }

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (!email.matches(regex)) {
            throw new EmployeeException("Invalid email format.");
        }
    }

    // Employee Phonenumber validation

    private void validatePhoneNumber(String phoneNumber)
            throws EmployeeException {

        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new EmployeeException("Phone number cannot be empty.");
        }

        if (!phoneNumber.matches("\\d{10}")) {
            throw new EmployeeException("Phone number must contain exactly 10 digits.");
        }
    }

    // Employee Department Validation

    private void validateDepartment(String department)
            throws EmployeeException {

        if (department == null || department.trim().isEmpty()) {
            throw new EmployeeException("Department cannot be empty.");
        }
    }

    // Employee JobTitle Validation

    private void validateJobTitle(String jobTitle)
            throws EmployeeException {

        if (jobTitle == null || jobTitle.trim().isEmpty()) {
            throw new EmployeeException("Job title cannot be empty.");
        }
    }

    // Employee Experience Validation

    private void validateExperience(int experience)
            throws EmployeeException {

        if (experience < 0) {
            throw new EmployeeException("Experience cannot be negative.");
        }

        if (experience > 45) {
            throw new EmployeeException("Invalid experience.");
        }
    }

    // Employee Joining Date Validation

    private void validateDateJoined(LocalDate dateJoined)
            throws EmployeeException {

        if (dateJoined == null) {
            throw new EmployeeException("Joining Date cannot be empty.");
        }

        if (dateJoined.isAfter(LocalDate.now())) {
            throw new EmployeeException("Joining date cannot be in the future.");
        }
    }


/*  =====================>                ADD A EMPLOYEE         <===========================             */


    public int addEmployee(Employee employee) throws EmployeeException {
        try {
            validateSalary(employee.getSalary());
            validateAge(employee.getAge());
            validateName(employee.getName());

            if(repository.getEmployeeById(employee.getEmployeeId()) != null) {
                throw new DuplicateEmployeeException("Employee ID already exists.");
            }
            
            return repository.addEmployee(employee);

        } catch (SQLException e) {
            throw new EmployeeException("Failed to add employee.", e);
        }
    }


/*  =====================>          DISPLAY ALL EMPLOYEE         <===========================             */


    public ArrayList<Employee> getAllEmployees() throws EmployeeException{
        try {
            return repository.getAllEmployees();
        } catch (SQLException e) {
            throw new EmployeeException("Unable to retrieve employees from the database.", e);
        }
    }


/*  =====================>          SEARCH EMPLOYEE BY ID         <===========================             */


    public Employee getEmployeeById(int employeeId) throws EmployeeException {
        try {
            Employee employee = repository.getEmployeeById(employeeId);
            validateEmployeeExists(employee);
            return employee;
        } catch(SQLException e) {
            throw new EmployeeException("Unable to retrieve employee from the database.", e);
        }
    }


/*  =====================>          UPDATE EMPLOYEE DETAILS      <===========================             */


    public void updateEmployeeName(int employeeId, String newName) throws EmployeeException {
        validateName(newName);
        try {
            getEmployeeById(employeeId);
            repository.updateEmployeeName(employeeId,newName);
        } catch(SQLException e) {
            throw new EmployeeException("Unable to update employee name in the database.", e);
        }
    }

    public void updateEmployeeAge(int employeeId, int newAge) throws EmployeeException {
        validateAge(newAge);
        try {
            getEmployeeById(employeeId);
            repository.updateEmployeeAge(employeeId,newAge);
        } catch(SQLException e) {
            throw new EmployeeException("Unable to update employee age in the database.", e);
        }
    }

    public void updateEmployeeGender(int employeeId, Gender newGender) throws EmployeeException {
        validateGender(newGender);
        try {
            getEmployeeById(employeeId);
            repository.updateEmployeeGender(employeeId,newGender);
        } catch(SQLException e) {
            throw new EmployeeException("Unable to update employee gender in the database.", e);
        }
    }

    public void updateEmployeeEmail(int employeeId, String newEmail) throws EmployeeException {
        validateEmail(newEmail);
        try {
            getEmployeeById(employeeId);
            repository.updateEmployeeEmail(employeeId,newEmail);
        } catch(SQLException e) {
            throw new EmployeeException("Unable to update employee email in the database.", e);
        }
    }

    public void updateEmployeePhoneNumber(int employeeId, String newPhoneNumber) throws EmployeeException {
        validatePhoneNumber(newPhoneNumber);
        try {
            getEmployeeById(employeeId);
            repository.updateEmployeePhoneNumber(employeeId,newPhoneNumber);
        } catch(SQLException e) {
            throw new EmployeeException("Unable to update employee Phonenumber in the database.", e);
        }
    }

    public void updateEmployeeDepartment(int employeeId, String newDepartment) throws EmployeeException {
        validateDepartment(newDepartment);
        try {
            getEmployeeById(employeeId);
            repository.updateEmployeeDepartment(employeeId,newDepartment);
        } catch(SQLException e) {
            throw new EmployeeException("Unable to update employee Department in the database.", e);
        }
    }

    public void updateEmployeeJobTitle(int employeeId, String newJobTitle) throws EmployeeException {
        validateJobTitle(newJobTitle);
        try {
            getEmployeeById(employeeId);
            repository.updateEmployeeJobTitle(employeeId,newJobTitle);
        } catch(SQLException e) {
            throw new EmployeeException("Unable to update employee JobTitle in the database.", e);
        }
    }

    public void updateEmployeeSalary(int employeeId, double newSalary) throws EmployeeException {
        validateSalary(newSalary);
        try {
            getEmployeeById(employeeId);
            repository.updateEmployeeSalary(employeeId,newSalary);
        } catch(SQLException e) {
            throw new EmployeeException("Unable to update employee salary in the database.", e);
        }
    }

    public void updateEmployeeExperience(int employeeId, int newExperience) throws EmployeeException {
        validateExperience(newExperience);
        try {
            getEmployeeById(employeeId);
            repository.updateEmployeeExperience(employeeId,newExperience);
        } catch(SQLException e) {
            throw new EmployeeException("Unable to update employee experience in the database.", e);
        }
    }

    public void updateEmployeeDateJoined(int employeeId, LocalDate newDateJoined) throws EmployeeException {
        validateDateJoined(newDateJoined);
        try {
            getEmployeeById(employeeId);
            repository.updateEmployeeDateJoined(employeeId,newDateJoined);
        } catch(SQLException e) {
            throw new EmployeeException("Unable to update employee Joining Date in the database.", e);
        }
    }

/*  =====================>      DELETE EMPLOYEE     <==================== */

    public void deleteEmployee(int employeeId) throws EmployeeException {
        try {
            getEmployeeById(employeeId);
            repository.deleteEmployee(employeeId);
        } catch (SQLException e) {
            throw new EmployeeException("Unable to delete employee due to a database error.");
        }
    }

}
