package xin.smoon.springwater.wechatapi.framework.common.enums;

public enum ResponseCodeEnum {

    /**
     * success
     */
    SUCCESS(0, "success"),

    /**
     * 错误
     */
    ERROR(1, "error"),

    /**
     * 无结果
     */
    NO_RESULT(2, "no_result"),

    /**
     * 参数错误
     */
    PARAM_ERROR(3, "param_error");

    private int code;
    private String msg;

    ResponseCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 获取值对应的枚举对象
     *
     * @param code
     * @return
     */
    public static ResponseCodeEnum getInstance(int code) {
        for (ResponseCodeEnum obj : ResponseCodeEnum.values()) {
            if (obj.getCode() == code) {
                return obj;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
