public class MyException extends Exception {
    ExceptionType id;
    public ExceptionType getId(){
        return id;
    }
    public MyException(ExceptionType id, String message){
        super(message);
        this.id = id;
    }
}
