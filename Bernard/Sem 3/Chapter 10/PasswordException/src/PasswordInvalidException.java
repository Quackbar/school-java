public class PasswordInvalidException extends PasswordException{
    private static int count;

    public PasswordInvalidException(){
        super("Invalid password.");
        ++count;
    }
    public PasswordInvalidException(String pswd){
        super(pswd);
        ++count;
    }
    public String usage(){
        return new String("This password is invalid");
    }
    public final void resetCount(){
        count = 0;
    }
    public final int getCount(){
        return count;
    }
}
