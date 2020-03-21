package back.platform.exceptions.notFoundExceptions;

public class CourseNotFoundException extends NullPointerException {
    private String message;

    public CourseNotFoundException(String message) {
        this.message = message;
    }
}
