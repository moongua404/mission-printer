package mission;

public class ProgramTerminateException extends RuntimeException {
    public ProgramTerminateException() {}

    public ProgramTerminateException(String message) {
        super(message);
    }
}
