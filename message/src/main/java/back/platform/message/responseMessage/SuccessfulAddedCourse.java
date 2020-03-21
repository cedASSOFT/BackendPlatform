package back.platform.message.responseMessage;

public class SuccessfulAddedCourse {
    private String message;

    public SuccessfulAddedCourse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
