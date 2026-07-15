package repository;

import model.Employee;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmployeeRepository {
    private ArrayList<Employee> employees;
    private static final String FILE_NAME = "employees.txt";

    public EmployeeRepository() {
        employees = new ArrayList<>();

        loadEmployeesFromFile();
    }

    private void loadEmployeesFromFile() {
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] employeeData = line.split(",");
                Employee employee = new Employee(employeeData);
                employees.add(employee);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void saveEmployeesToFile() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for(Employee employee : employees) {
                writer.write(employee.toCsv());
                writer.newLine();
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        saveEmployeesToFile();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        saveEmployeesToFile();
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
    
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        saveEmployeesToFile();
    }

}