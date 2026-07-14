import model.Employee;
import service.EmployeeService;
import exception.EmployeeException;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        while(true) {
            System.out.println("\n======================================");
            System.out.println("\n      EMPLOYEE MANAGEMENT SYSTEM      ");
            System.out.println("\n======================================\n");
            System.out.println("1. Add Employee\n");
            System.out.println("2. Display All Employees\n");
            System.out.println("3. Update Employee\n");
            System.out.println("4. Delete Employee\n");
            System.out.println("5. Search Employee\n");
            System.out.println("6. Exit\n");
            System.out.println("\n======================================\n");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1 : {
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Gender: ");
                    String gender = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter Job Title: ");
                    String jobTitle = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    System.out.print("Enter Experience: ");
                    int experience = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Date Joined: ");
                    String dateJoined = sc.nextLine();

                    Employee employee = new Employee(
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

                    try {
                        service.addEmployee(employee);
                        System.out.println("✓ Employee Added Successfully");
                    }
                    catch (EmployeeException e) {
                        System.out.println(e.getMessage());
                    }
                                     
                    break;
                }

                case 2 : { 
                    ArrayList<Employee> employees = service.getAllEmployees();
                    if(employees.isEmpty()) {
                        System.out.println("No Employees Found");
                    }
                    else {
                        for(Employee emp : employees) {
                            System.out.println(emp);
                        }
                    }
                    break;
                }
                
                case 3 : {
                    System.out.print("Enter Employee ID :");
                    int employeeId = sc.nextInt();
                    sc.nextLine();
                    try {
                        Employee existingEmployee = service.getEmployeeById(employeeId);
                        boolean updateMenu = true;

                        while (updateMenu) {

                            System.out.println("\n========== UPDATE EMPLOYEE ==========");
                            System.out.println("1. Update Name");
                            System.out.println("2. Update Age");
                            System.out.println("3. Update Gender");
                            System.out.println("4. Update Email");
                            System.out.println("5. Update Phone Number");
                            System.out.println("6. Update Department");
                            System.out.println("7. Update Job Title");
                            System.out.println("8. Update Salary");
                            System.out.println("9. Update Experience");
                            System.out.println("10. Update Date Joined");
                            System.out.println("11. Exit");
                            System.out.print("Enter Your Choice : ");

                            int updateChoice = sc.nextInt();
                            sc.nextLine();

                            switch (updateChoice) {

                                case 1:
                                    System.out.print("Enter New Name: ");
                                    String newName = sc.nextLine();

                                    service.updateEmployeeName(existingEmployee, newName);

                                    System.out.println("✓ Name Updated Successfully.");
                                    System.out.println(existingEmployee);
                                    break;

                                case 2:
                                    System.out.print("Enter New Age: ");
                                    int newAge = sc.nextInt();
                                    sc.nextLine();

                                    service.updateEmployeeAge(existingEmployee, newAge);

                                    System.out.println("✓ Age Updated Successfully.");
                                    System.out.println(existingEmployee);
                                    break;

                                case 3:
                                    System.out.print("Enter Gender: ");
                                    String newGender = sc.nextLine();

                                    service.updateEmployeeGender(existingEmployee, newGender);

                                    System.out.println("✓ Gender Updated Successfully.");
                                    System.out.println(existingEmployee);
                                    break;

                                case 4:
                                    System.out.print("Enter New Email: ");
                                    String newEmail = sc.nextLine();

                                    service.updateEmployeeEmail(existingEmployee, newEmail);

                                    System.out.println("✓ Email Updated Successfully.");
                                    System.out.println(existingEmployee);
                                    break;

                                case 5:
                                    System.out.print("Enter New Phone Number: ");
                                    String newPhoneNumber = sc.nextLine();

                                    service.updateEmployeePhoneNumber(existingEmployee, newPhoneNumber);

                                    System.out.println("✓ Phone Number Updated Successfully.");
                                    System.out.println(existingEmployee);
                                    break;

                                case 6:
                                    System.out.print("Enter New Department: ");
                                    String newDepartment = sc.nextLine();

                                    service.updateEmployeeDepartment(existingEmployee, newDepartment);

                                    System.out.println("✓ Department Updated Successfully.");
                                    System.out.println(existingEmployee);
                                    break;

                                case 7:
                                    System.out.print("Enter New Job Title: ");
                                    String newJobTitle = sc.nextLine();

                                    service.updateEmployeeJobTitle(existingEmployee, newJobTitle);

                                    System.out.println("✓ Job Title Updated Successfully.");
                                    System.out.println(existingEmployee);
                                    break;

                                case 8:
                                    System.out.print("Enter New Salary: ");
                                    double newSalary = sc.nextDouble();
                                    sc.nextLine();

                                    service.updateEmployeeSalary(existingEmployee, newSalary);

                                    System.out.println("✓ Salary Updated Successfully.");
                                    System.out.println(existingEmployee);
                                    break;

                                case 9:
                                    System.out.print("Enter Experience: ");
                                    int newExperience = sc.nextInt();
                                    sc.nextLine();

                                    service.updateEmployeeExperience(existingEmployee, newExperience);

                                    System.out.println("✓ Experience Updated Successfully.");
                                    System.out.println(existingEmployee);
                                    break;

                                case 10:
                                    System.out.print("Enter new Joining Date: ");
                                    String newDateJoined = sc.nextLine();

                                    service.updateEmployeeDateJoined(existingEmployee, newDateJoined);

                                    System.out.println("✓ Joining Date Updated Successfully.");
                                    System.out.println(existingEmployee);
                                    break;

                                case 11:
                                    updateMenu = false;
                                    break;

                                default:
                                    System.out.println("Invalid Choice");
                            }
                        }
                    }
                    catch (EmployeeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 4 : {
                    System.out.print("Enter Employee ID :");
                    int employeeId = sc.nextInt();
                    sc.nextLine();
                    try {
                        service.deleteEmployee(employeeId);
                        System.out.println("✓ Employee Deleted Successfully");
                    }
                    catch(EmployeeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 5 : {
                    System.out.print("Enter Employee ID :");
                    int employeeId = sc.nextInt();
                    sc.nextLine();
                    try {
                        Employee employee = service.getEmployeeById(employeeId);
                        System.out.println(employee);
                    }
                    catch(EmployeeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 6 : {
                    System.out.println("Thank You!");
                    return;
                }

                default :
                    System.out.println("Invalid Choice");
            }
        }
    }
}