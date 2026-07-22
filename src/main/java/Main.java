import model.Employee;
import service.EmployeeService;
import exception.EmployeeException;
import enums.Gender;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        while(true) {
            System.out.println("\n======================================");
            System.out.println("\n      EMPLOYEE MANAGEMENT SYSTEM      ");
            System.out.println("\n======================================\n");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search Employee");
            System.out.println("6. Exit");
            System.out.println("\n======================================\n");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1 : {

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Gender: ");
                    Gender gender = Gender.valueOf(sc.nextLine().toUpperCase());

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

                    System.out.print("Enter Date Joined (yyyy-MM-dd): ");
                    LocalDate dateJoined = LocalDate.parse(sc.nextLine());

                    Employee employee = new Employee(
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
                        int rows = service.addEmployee(employee);
                        if (rows == 1) {
                            System.out.println("[SUCCESS] Employee Added Successfully");
                        }
                    }
                    catch (EmployeeException e) {
                        System.out.println(e.getMessage());
                    }
                                     
                    break;
                }

                case 2 : { 
                    try {
                        ArrayList<Employee> employees = service.getAllEmployees();
                        if(employees.isEmpty()) {
                            System.out.println("No Employees Found");
                        }
                        else {
                            for(Employee emp : employees) {
                                System.out.println(emp);
                            }
                        }
                    }
                    catch(EmployeeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                
                case 3 : {
                    System.out.print("Enter Employee ID :");
                    int employeeId = sc.nextInt();
                    sc.nextLine();
                    try {
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

                                    service.updateEmployeeName(employeeId, newName);

                                    System.out.println("[SUCCESS] Name Updated Successfully.");
                                    System.out.println(service.getEmployeeById(employeeId));
                                    break;

                                case 2:
                                    System.out.print("Enter New Age: ");
                                    int newAge = sc.nextInt();
                                    sc.nextLine();

                                    service.updateEmployeeAge(employeeId, newAge);

                                    System.out.println("[SUCCESS] Age Updated Successfully.");
                                    System.out.println(service.getEmployeeById(employeeId));
                                    break;

                                case 3:
                                    System.out.print("Enter Gender: ");
                                    Gender newGender = Gender.valueOf(sc.nextLine().toUpperCase());

                                    service.updateEmployeeGender(employeeId, newGender);

                                    System.out.println("[SUCCESS] Gender Updated Successfully.");
                                    System.out.println(service.getEmployeeById(employeeId));
                                    break;

                                case 4:
                                    System.out.print("Enter New Email: ");
                                    String newEmail = sc.nextLine();

                                    service.updateEmployeeEmail(employeeId, newEmail);

                                    System.out.println("[SUCCESS] Email Updated Successfully.");
                                    System.out.println(service.getEmployeeById(employeeId));
                                    break;

                                case 5:
                                    System.out.print("Enter New Phone Number: ");
                                    String newPhoneNumber = sc.nextLine();

                                    service.updateEmployeePhoneNumber(employeeId, newPhoneNumber);

                                    System.out.println("[SUCCESS] Phone Number Updated Successfully.");
                                    System.out.println(service.getEmployeeById(employeeId));
                                    break;

                                case 6:
                                    System.out.print("Enter New Department: ");
                                    String newDepartment = sc.nextLine();

                                    service.updateEmployeeDepartment(employeeId, newDepartment);

                                    System.out.println("[SUCCESS] Department Updated Successfully.");
                                    System.out.println(service.getEmployeeById(employeeId));
                                    break;

                                case 7:
                                    System.out.print("Enter New Job Title: ");
                                    String newJobTitle = sc.nextLine();

                                    service.updateEmployeeJobTitle(employeeId, newJobTitle);

                                    System.out.println("[SUCCESS] Job Title Updated Successfully.");
                                    System.out.println(service.getEmployeeById(employeeId));
                                    break;

                                case 8:
                                    System.out.print("Enter New Salary: ");
                                    double newSalary = sc.nextDouble();
                                    sc.nextLine();

                                    service.updateEmployeeSalary(employeeId, newSalary);

                                    System.out.println("[SUCCESS] Salary Updated Successfully.");
                                    System.out.println(service.getEmployeeById(employeeId));
                                    break;

                                case 9:
                                    System.out.print("Enter Experience: ");
                                    int newExperience = sc.nextInt();
                                    sc.nextLine();

                                    service.updateEmployeeExperience(employeeId, newExperience);

                                    System.out.println("[SUCCESS] Experience Updated Successfully.");
                                    System.out.println(service.getEmployeeById(employeeId));
                                    break;

                                case 10:
                                    System.out.print("Enter New Joining Date (yyyy-MM-dd): ");
                                    LocalDate newDateJoined = LocalDate.parse(sc.nextLine());

                                    service.updateEmployeeDateJoined(employeeId, newDateJoined);

                                    System.out.println("[SUCCESS] Joining Date Updated Successfully.");
                                    System.out.println(service.getEmployeeById(employeeId));
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
                        System.out.println("[SUCCESS] Employee Deleted Successfully");
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
                    sc.close();
                    return;
                }

                default :
                    System.out.println("Invalid Choice");
            }
        }
    }
}