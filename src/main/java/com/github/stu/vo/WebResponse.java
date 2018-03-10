package com.github.stu.vo;

/**
 * 请求返回结果
 */
public class WebResponse<T>  {
    // 请求状态
    private int status = WebConf.STATUS_OK;
    private T data;


    private String message;

    public WebResponse(int status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public WebResponse() {
    }

    public static WebResponse getSuccessWebResponse() {
        WebResponse<Object> webResponse = new WebResponse<Object>();
        webResponse.setStatus(WebConf.STATUS_OK);
        webResponse.setMessage(WebConf.SUCCESS_MESSAGE);
        return webResponse;
    }

    public static WebResponse getAuthErrorWebResponse() {
        WebResponse<Object> webResponse = new WebResponse<Object>();
        webResponse.setStatus(WebConf.AUTH_ERROR);
        webResponse.setMessage(WebConf.AUTH_ERROR_MESSAGE);

        return webResponse;
    }

    public static WebResponse getTokenErrorWebResponse() {
        WebResponse<Object> webResponse = new WebResponse<Object>();
        webResponse.setStatus(WebConf.TOKEN_ERROR);
        webResponse.setMessage(WebConf.TOKEN_ERROR_MESSAGE);

        return webResponse;
    }

    public static WebResponse getParamErrorWebResponse() {
        WebResponse<Object> webResponse = new WebResponse<Object>();
        webResponse.setStatus(WebConf.PARAM_ERROR);
        webResponse.setMessage(WebConf.PARAM_ERROR_MESSAGE);
        return webResponse;
    }

    public static WebResponse getParamErrorWebResponse(String msg) {
        WebResponse<Object> webResponse = new WebResponse<Object>();
        webResponse.setStatus(WebConf.PARAM_ERROR);
        webResponse.setMessage(WebConf.PARAM_ERROR_MESSAGE + ", 详情: " + msg);
        return webResponse;
    }

    public static WebResponse getErrorWebResponse() {
        WebResponse<Object> webResponse = new WebResponse<Object>();
        webResponse.setStatus(WebConf.SYSTEM_ERROR);
        webResponse.setMessage(WebConf.SYSTEM_ERROR_MESSAGE);
        return webResponse;
    }

    public static WebResponse getErrorWebResponse(String detailMsg) {
        WebResponse<Object> webResponse = new WebResponse<Object>();
        webResponse.setStatus(WebConf.SYSTEM_ERROR);
        webResponse.setMessage(WebConf.SYSTEM_ERROR_MESSAGE + " detail:" + detailMsg);
        return webResponse;
    }



    public <E extends WebResponse> E status(int status) {
        setStatus(status);
        return (E) this;
    }

    public <E extends WebResponse> E data(T data) {
        setData(data);
        return (E) this;
    }

    public <E extends WebResponse> E message(String message) {
        setMessage(message);
        return (E) this;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
