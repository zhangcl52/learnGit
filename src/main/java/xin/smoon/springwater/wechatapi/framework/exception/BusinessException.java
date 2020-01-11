package xin.smoon.springwater.wechatapi.framework.exception;

public class BusinessException extends RuntimeException {

    private int code;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String msgTemplate, Object... args) {
        super(String.format(msgTemplate, args));
    }

    public BusinessException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
