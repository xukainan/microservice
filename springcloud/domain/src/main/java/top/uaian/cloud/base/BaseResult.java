package top.uaian.cloud.base;

import lombok.Data;

/**
 * description:  <br>
 * date: 2020/8/18 10:00 <br>
 * @author: xukainan <br>
 * version: 1.0 <br>
 */
@Data
public class BaseResult<T> {
    private int code;
    private String message;
    private T data;
    private boolean success;

    public BaseResult renderSuccess(T data) {
        this.code = 200;
        this.message = "成功";
        this.data = data;
        this.success = true;
        return this;
    }

    public boolean isSuccess(){
        return this.success;
    }

    public BaseResult renderError(int code, String msg) {
        this.code = code;
        this.message = msg;
        this.data = null;
        this.success = false;
        return this;
    }

}
