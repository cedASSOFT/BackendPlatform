package back.platform.message.responseMessage;

public class SuccessRegistration {
    private String message;

    public SuccessRegistration(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
