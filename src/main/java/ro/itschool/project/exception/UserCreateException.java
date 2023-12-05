package ro.itschool.project.exception;

public class UserCreateException extends RuntimeException{
    public UserCreateException(String message) {
        super(message);
    }
}
