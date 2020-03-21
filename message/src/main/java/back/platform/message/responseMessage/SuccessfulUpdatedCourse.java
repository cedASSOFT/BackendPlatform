package back.platform.message.responseMessage;

public class SuccessfulUpdatedCourse {
    private String message;

    public SuccessfulUpdatedCourse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
