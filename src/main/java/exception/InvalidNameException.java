package exception;

public class InvalidNameException extends EmployeeException {
    public InvalidNameException(String message) {
        super(message);
    }
}