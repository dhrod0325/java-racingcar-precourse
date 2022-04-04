package racing.exception;

public class RacingException extends Exception {
    public RacingException(String message) {
        super("[ERROR] " + message);
    }
}
