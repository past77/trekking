package polo.exception;

public class UserIsNotExist extends RuntimeException {
    public UserIsNotExist() {
        super();
    }

    public UserIsNotExist(String message) {
        super(message);
    }

    public UserIsNotExist(String message, Throwable cause) {
        super(message, cause);
    }

    public UserIsNotExist(Throwable cause) {
        super(cause);
    }
}
