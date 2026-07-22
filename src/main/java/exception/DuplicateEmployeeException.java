package exception;

public class DuplicateEmployeeException extends EmployeeException {
    public DuplicateEmployeeException(String message) {
        super(message);
    }
}