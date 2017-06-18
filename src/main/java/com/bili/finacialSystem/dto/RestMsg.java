package com.bili.finacialSystem.dto;

/**
 * web信息返回封装
 * Created by bili on 2017/6/18.
 */
public class RestMsg {
    public static final String SUCCESS = "success";//返回成功状态
    public static final String ERROR = "error";//返回失败状态


    private String msg; //返回信息
    private String status;//返回状态

    public RestMsg() {
        this("",SUCCESS);
    }

    public RestMsg(String msg, String status) {
        this.msg = msg;
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public String getStatus() {
        return status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RestMsg{" +
                "msg='" + msg + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
