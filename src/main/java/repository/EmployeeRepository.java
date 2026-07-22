package repository;

import model.Employee;
import config.DatabaseConnection;
import enums.Gender;

import java.util.ArrayList;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDate;




public class EmployeeRepository {

    private Employee mapResultSetToEmployee(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("employeeId");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        Gender gender = Gender.valueOf(resultSet.getString("gender"));
        String email = resultSet.getString("email");
        String phoneNumber = resultSet.getString("phoneNumber");
        String department = resultSet.getString("department");
        String jobTitle = resultSet.getString("jobTitle");
        double salary = resultSet.getDouble("salary");
        int experience = resultSet.getInt("experience");
        LocalDate dateJoined = resultSet.getDate("dateJoined").toLocalDate();

        return new Employee(
            id,
            name,
            age,
            gender,
            email,
            phoneNumber,
            department,
            jobTitle,
            salary,
            experience,
            dateJoined
        );
    }

    public int addEmployee(Employee employee) throws SQLException {
        String sql = """
            INSERT INTO employees 
            (
                name,
                age,
                gender,
                email,
                phoneNumber,
                department,
                jobTitle,
                salary,
                experience,
                dateJoined
            )
            VALUES
            (
                ?, ?, ?, ?, ?, ?, ?, ?, ?, ?
            )
            """;

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setString(1,employee.getName());
            preparedStatement.setInt(2,employee.getAge());
            preparedStatement.setString(3,employee.getGender().name());
            preparedStatement.setString(4,employee.getEmail());
            preparedStatement.setString(5,employee.getPhoneNumber());
            preparedStatement.setString(6,employee.getDepartment());
            preparedStatement.setString(7,employee.getJobTitle());
            preparedStatement.setDouble(8,employee.getSalary());
            preparedStatement.setInt(9,employee.getExperience());
            preparedStatement.setDate(10,Date.valueOf(employee.getDateJoined()));

            return preparedStatement.executeUpdate();
        }
    }

    public Employee getEmployeeById(int employeeId) throws SQLException {
        
        String sql = "SELECT * FROM employees WHERE employeeId = ?";

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1,employeeId);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()) {
                    return mapResultSetToEmployee(resultSet);
                }
            }
        }
        return null;
    }

    public ArrayList<Employee> getAllEmployees() throws SQLException {

        ArrayList<Employee> employees = new ArrayList<>();

        String sql = "SELECT * FROM employees";

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while(resultSet.next()) {
                employees.add(mapResultSetToEmployee(resultSet));
            }
        }

        return employees;
    }
    
    public void deleteEmployee(int employeeId) throws SQLException {
        String sql = "DELETE FROM employees WHERE employeeId = ?";

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setInt(1,employeeId);
            preparedStatement.executeUpdate();
        }
    }

    public void updateEmployeeName(int employeeId, String newName) throws SQLException {
        String sql = "UPDATE employees SET name = ? WHERE employeeId = ?";

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setString(1,newName);
            preparedStatement.setInt(2, employeeId);
            preparedStatement.executeUpdate();
        }
    }

    public void updateEmployeeAge(int employeeId, int newAge) throws SQLException {
        String sql = "UPDATE employees SET age = ? WHERE employeeId = ?";

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setInt(1,newAge);
            preparedStatement.setInt(2, employeeId);
            preparedStatement.executeUpdate();
        }
    }

    public void updateEmployeeGender(int employeeId, Gender newGender) throws SQLException {
        String sql = "UPDATE employees SET gender = ? WHERE employeeId = ?";

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setString(1,newGender.name());
            preparedStatement.setInt(2, employeeId);
            preparedStatement.executeUpdate();
        }
    }

    public void updateEmployeeEmail(int employeeId, String newEmail) throws SQLException {
        String sql = "UPDATE employees SET email = ? WHERE employeeId = ?";

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setString(1,newEmail);
            preparedStatement.setInt(2, employeeId);
            preparedStatement.executeUpdate();
        }
    }

    public void updateEmployeePhoneNumber(int employeeId, String newPhoneNumber) throws SQLException {
        String sql = "UPDATE employees SET phoneNumber = ? WHERE employeeId = ?";

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setString(1,newPhoneNumber);
            preparedStatement.setInt(2, employeeId);
            preparedStatement.executeUpdate();
        }
    }

    public void updateEmployeeDepartment(int employeeId, String newDepartment) throws SQLException {
        String sql = "UPDATE employees SET department = ? WHERE employeeId = ?";

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setString(1,newDepartment);
            preparedStatement.setInt(2, employeeId);
            preparedStatement.executeUpdate();
        }
    }

    public void updateEmployeeJobTitle(int employeeId, String newJobTitle) throws SQLException {
        String sql = "UPDATE employees SET jobTitle = ? WHERE employeeId = ?";

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setString(1,newJobTitle);
            preparedStatement.setInt(2, employeeId);
            preparedStatement.executeUpdate();
        }
    }

    public void updateEmployeeSalary(int employeeId, double newSalary) throws SQLException {
        String sql = "UPDATE employees SET salary = ? WHERE employeeId = ?";

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setDouble(1,newSalary);
            preparedStatement.setInt(2, employeeId);
            preparedStatement.executeUpdate();
        }
    }

    public void updateEmployeeExperience(int employeeId, int newExperience) throws SQLException {
        String sql = "UPDATE employees SET experience = ? WHERE employeeId = ?";

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setInt(1,newExperience);
            preparedStatement.setInt(2, employeeId);
            preparedStatement.executeUpdate();
        }
    }

    public void updateEmployeeDateJoined(int employeeId, LocalDate newDateJoined) throws SQLException {
        String sql = "UPDATE employees SET dateJoined = ? WHERE employeeId = ?";

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setDate(1,Date.valueOf(newDateJoined));
            preparedStatement.setInt(2, employeeId);
            preparedStatement.executeUpdate();
        }
    }


}