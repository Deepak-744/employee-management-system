package exception;

public class InvalidAgeException extends EmployeeException {
    public InvalidAgeException(String message) {
        super(message);
    }
}