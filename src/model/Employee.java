package model;

public class Employee {
    private int employeeId;
    private String name;
    private int age;
    private String gender;
    private String email;
    private String phoneNumber;
    private String department;
    private String jobTitle;
    private double salary;
    private int experience;
    private String dateJoined;

    public Employee() {

    }

    public Employee(int employeeId, 
                    String name, 
                    int age, 
                    String gender, 
                    String email, 
                    String phoneNumber, 
                    String department, 
                    String jobTitle, 
                    double salary, 
                    int experience, 
                    String dateJoined) {
        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.experience = experience;
        this.dateJoined = dateJoined;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDepartment() {
        return department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public int getExperience() {
        return experience;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId = " + employeeId +
                ", name = '" + name + '\'' +
                ", age = " + age +
                ", gender = '" + gender + '\'' +
                ", email = '" + email + '\'' +
                ", phoneNumber = '" + phoneNumber + '\'' +
                ", department = '" + department + '\'' +
                ", jobTitle = '" + jobTitle + '\'' +
                ", salary = " + salary +
                ", experience = " + experience +
                ", dateJoined = '" + dateJoined + '\'' +
                '}';
    }
}

