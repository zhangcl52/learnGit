package xin.smoon.springwater.wechatapi.framework.common;

import xin.smoon.springwater.wechatapi.framework.common.enums.ResponseCodeEnum;

import java.io.Serializable;

public class Response implements Serializable {

    private static final long serialVersionUID = 1033074173010414019L;

    /**
     * 返回结果
     **/
    private int code;
    /**
     * 提示信息
     **/
    private String msg;
    /**
     * 返回结果
     **/
    private Object result;

    public Response() {

    }

    public Response(Object result) {
        this(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMsg(), result);
    }

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(int code, String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    /**
     * 返回成功信息
     *
     * @return
     */
    public static Response success() {
        return new Response(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMsg());
    }

    /**
     * 返回成功信息
     *
     * @return
     */
    public static Response success(Object result) {
        return new Response(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMsg(), result);
    }

    /**
     * 返回成功信息
     *
     * @return
     */
    public static Response success(String msg) {
        return new Response(ResponseCodeEnum.SUCCESS.getCode(), msg);
    }

    /**
     * 返回成功信息
     *
     * @return
     */
    public static Response success(String msg, Object result) {
        return new Response(ResponseCodeEnum.SUCCESS.getCode(), msg, result);
    }

    /**
     * 返回成功信息
     *
     * @return
     */
    public static Response success(int code, String msg) {
        return new Response(code, msg);
    }

    /**
     * 返回错误信息
     *
     * @return
     */
    public static Response error(String msg) {
        return error(ResponseCodeEnum.ERROR.getCode(), msg);
    }

    /**
     * 返回错误信息
     *
     * @return
     */
    public static Response error(int code, String msg) {
        return new Response(code, msg);
    }

    /**
     * 返回错误信息
     *
     * @return
     */
    public static Response error(int code, String msg, Object result) {
        return new Response(code, msg, result);
    }

    /**
     * 返回结果
     *
     * @return
     */
    public static Response result(Object result) {
        return new Response(result);
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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

}
