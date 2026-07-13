package exception;

public class InvalidSalaryException extends EmployeeException {
    public InvalidSalaryException(String message) {
        super(message);
    }
}