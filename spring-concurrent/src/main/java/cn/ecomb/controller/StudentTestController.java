package cn.ecomb.controller;


import cn.ecomb.engine.EcombEngineV;
import cn.ecomb.engine.dto.PoiList;
import cn.ecomb.engine.dto.Request;
import cn.ecomb.engine.dto.Response;
import cn.ecomb.service.UserServiceAbstract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhouzhigang
 * @date 2018/7/25.
 */
@RestController
public class StudentTestController {

    @Autowired
    public UserServiceAbstract userServiceAbstract;
    @Autowired
    public EcombEngineV ecombEngineV;

    @GetMapping("/user/test")
    public String getStudentTestBySno() {

        Request request = new Request();
        Response response = new Response("R1", request);
        request.setResponse(response);
        List<PoiList> poiLists = new LinkedList<>();
        poiLists.add(new PoiList("MALL", "海岸城"));
        poiLists.add(new PoiList("STORE", "八合里"));
        response.setPoiList(poiLists);
        ecombEngineV.start(request);
        return "fasd";
    }
}
