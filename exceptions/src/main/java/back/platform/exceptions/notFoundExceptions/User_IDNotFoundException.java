package back.platform.exceptions.notFoundExceptions;

public class User_IDNotFoundException extends NullPointerException {
    private String message;

    public User_IDNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
