package back.platform.exceptions.registrationException;

public class EmailAlreadyExistException extends Exception {
    public EmailAlreadyExistException() {
    }

    public EmailAlreadyExistException(String message) {
        super(message);
    }
}
