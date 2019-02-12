package cn.ecomb.engine.dto;

import lombok.Data;

import java.util.List;

/**
 * @author zhouzhigang
 * @date 2018-12-26.
 */
@Data
public class Response {

    private String uid;
    private String body;
    private List<PoiList> poiList;
    private List<ServiceList> serviceList;
    private Request request;

    /**
     * 记录链路状态信息
     */
    private String message;

    public Response() {
    }

    public Response(String uid, Request request) {
        this.uid = uid;
        this.request = request;
    }

}
