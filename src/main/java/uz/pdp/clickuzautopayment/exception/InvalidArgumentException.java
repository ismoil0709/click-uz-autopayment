package uz.pdp.clickuzautopayment.exception;

public class InvalidArgumentException extends RuntimeException{
    public InvalidArgumentException(String m){
        super(m + " is invalid");
    }
}
