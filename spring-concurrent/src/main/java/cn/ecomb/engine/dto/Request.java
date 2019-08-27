package cn.ecomb.engine.dto;

import lombok.Data;

/**
 * @author zhouzhigang
 * @date 2018-12-26.
 */
@Data
public class Request {
    private String param;
    private AppInfo appInfo;
    private ClientInfo clientInfo;
    private RequestParam requestParam;
    private Response response;

    public Request() {
    }

    public Request(String param) {
        this.param = param;
    }

    public String getParam() {
        return param;
    }

    public Request setParam(String param) {
        this.param = param;
        return this;
    }

    public Response getResponse() {
        return response;
    }

    public Request setResponse(Response response) {
        this.response = response;
        return this;
    }
}
