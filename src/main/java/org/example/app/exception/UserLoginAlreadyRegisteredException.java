package org.example.app.exception;

public class UserLoginAlreadyRegisteredException extends RuntimeException {
    public UserLoginAlreadyRegisteredException(String login) {
    }

    public UserLoginAlreadyRegisteredException() {
        super();
    }

    public UserLoginAlreadyRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserLoginAlreadyRegisteredException(Throwable cause) {
        super(cause);
    }

    protected UserLoginAlreadyRegisteredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
