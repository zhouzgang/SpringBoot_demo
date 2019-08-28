package cn.ecomb.face;

import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author zhouzg
 * @date 2019/3/1
 */
public class Sample {

    //设置APPID/AK/SK
    public static final String APP_ID = "15658169";
    public static final String API_KEY = "lmpSfQ0nHGg5Xcmz0OKAw67U";
    public static final String SECRET_KEY = "SVITnABPhGcgo9gFjSRhhXndGzaLRbwD";

    public static void main(String[] args) {
        // 初始化一个AipFace
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
//        HashMap<String, String> options = new HashMap<String, String>();
//        options.put("face_field", "age");
//        options.put("max_face_num", "2");
//        options.put("face_type", "LIVE");
//        String image = "http://cdn3.img.sputniknews.cn/images/102692/01/1026920145.jpg";
//        String imageType = "URL";
//
//        // 人脸检测
//        JSONObject res = client.detect(image, imageType, options);
//        System.out.println(res.toString(2));


        String image1 = "http://cdn3.img.sputniknews.cn/images/102692/01/1026920145.jpg";
        String image2 = "http://us.xinhuanet.com/2017-11/02/129731269_15095881082471n.jpg";

        // image1/image2也可以为url或facetoken, 相应的imageType参数需要与之对应。
        MatchRequest req1 = new MatchRequest(image1, "URL");
        MatchRequest req2 = new MatchRequest(image2, "URL");
        ArrayList<MatchRequest> requests = new ArrayList<MatchRequest>();
        requests.add(req1);
        requests.add(req2);

        JSONObject res = client.match(requests);
        System.out.println(res.toString(2));

    }
}
