package uz.pdp.clickuzautopayment.exception;

public class NullOrEmptyException extends RuntimeException{
    public NullOrEmptyException(String m) {
        super(m + " is empty");
    }
}
