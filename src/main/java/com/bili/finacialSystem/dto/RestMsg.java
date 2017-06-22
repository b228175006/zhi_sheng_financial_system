package com.bili.finacialSystem.dto;

import java.util.Map;

import static com.sun.javafx.tools.resource.DeployResource.Type.data;

/**
 * web信息返回封装
 * Created by bili on 2017/6/18.
 */
public class RestMsg {
    public static final String SUCCESS = "success";//返回成功状态
    public static final String ERROR = "error";//返回失败状态


    private String msg; //返回信息
    private String status;//返回状态
    private Map data;

    public RestMsg() {
        this("",SUCCESS);
    }

    public RestMsg(String msg, String status) {
        this.msg = msg;
        this.status = status;
    }
    public RestMsg(String msg,String status,Map data){
        this.msg = msg;
        this.status = status;
        this.data = data;
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


    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RestMsg{" +
                "msg='" + msg + '\'' +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
