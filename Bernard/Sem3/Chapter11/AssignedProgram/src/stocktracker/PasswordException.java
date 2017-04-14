package stocktracker;
public abstract class PasswordException extends Exception {
    public PasswordException() {
        super("Password Exception");
    }

    public PasswordException(String msg) {
        super(msg);
    }

    public abstract String usage();
}
