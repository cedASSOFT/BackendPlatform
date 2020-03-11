package back.platform.exceptions.registrationException;

public class UsernameAlreadyExistException extends Exception {
    public UsernameAlreadyExistException() {
    }

    public UsernameAlreadyExistException(String message) {
        super(message);
    }
}
