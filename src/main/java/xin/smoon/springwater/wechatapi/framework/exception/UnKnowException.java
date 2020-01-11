package xin.smoon.springwater.wechatapi.framework.exception;

public class UnKnowException extends RuntimeException {

    public UnKnowException() {
    }

    public UnKnowException(String message) {
        super(message);
    }

    public UnKnowException(String msgTemplate, Object... args) {
        super(String.format(msgTemplate, args));
    }

    public UnKnowException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnKnowException(Throwable cause, String msgTemplate, Object... args) {
        super(String.format(msgTemplate, args), cause);
    }

    public UnKnowException(Throwable cause) {
        super(cause);
    }

}
