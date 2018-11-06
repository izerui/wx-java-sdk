
package com.qq.weixin;

/**
 * Created by serv on 16/4/20.
 */
public class WxException extends RuntimeException {

    private String errcode;

    public WxException(String errcode, String message) {
        super(message);
        this.errcode = errcode;
    }

    public WxException(String errcode, String message, Throwable cause) {
        super(message, cause);
        this.errcode = errcode;
    }

    public String getErrcode() {
        return errcode;
    }

    @Override
    public String toString() {
        return String.format("WxException[errcode=%s,errmsg=%s]", errcode, getMessage());
    }
}
