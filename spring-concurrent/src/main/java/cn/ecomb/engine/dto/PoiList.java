package cn.ecomb.engine.dto;

import lombok.Data;

/**
 * @author zhouzg
 * @date 2019/1/24
 */
@Data
public class PoiList {

    private String sceneType;
    private String name;

    private Response response;

    public PoiList(String sceneType, String name) {
        this.sceneType = sceneType;
        this.name = name;
    }
}
